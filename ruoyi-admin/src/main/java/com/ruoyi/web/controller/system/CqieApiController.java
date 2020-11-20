package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.ICqieAppinfoService;
import com.ruoyi.system.service.ICqieRunService;
import com.ruoyi.system.service.ICqieStudentService;
import com.ruoyi.web.controller.tool.CqieOperVerificationController;
import com.ruoyi.web.controller.tool.FromClassToMapController;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ApiController
 *
 * @author sunly
 * @date 2020-10-10
 */
@Controller
@RequestMapping("/api_v1")
public class CqieApiController extends BaseController {
    private static AjaxResult ajaxResult = null;
    private String prefix = "api_v1";

    @Autowired
    private ICqieAppinfoService cqieAppinfoService;
    @Autowired
    private ICqieStudentService cqieStudentService;
    @Autowired
    private ICqieRunService cqieRunService;
    @Autowired
    private SysPasswordService passwordService;

    /**
     * 获取最新的APP版本
     *
     * @param version 版本号
     * @return 返回信息
     */
    @ApiOperation(value = "获取最新的APP版本", httpMethod = "POST")
    @PostMapping("/getNewVersion")
    @ResponseBody
    public AjaxResult getNewVersion(String version) {
        try {
            CqieAppinfo appInfo = cqieAppinfoService.selectCqieAppinfoLatest();
            HashMap<String, Object> data = new HashMap<>();
            data.put("newVersion", appInfo.getAppiVersion());
            data.put("forceUpdate", true);
            data.put("newVersionInfo", appInfo.getRemark());
            data.put("updateUrl", appInfo.getAppiAddress());
            return AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功", data);
        } catch (Exception e) {
            return AjaxResult.returnJSON(AjaxResult.Type.FAIL, "发生错误");
        }

    }

    /**
     * 登录
     * 20201027 sunly edit
     *
     * @param account  学号（账号）
     * @param password 密码
     * @return 返回信息
     */
    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult login(String account, String password) {
        try {
            CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
            if (cqieStudentService.login(account, passwordService.encryptPassword(cqieStudent.getStuName(), password, cqieStudent.getStuSalt())) != null) {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功");
            } else {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "账号或密码错误");
            }
        } catch (NullPointerException e) {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "账号或密码错误");
        } catch (Exception e) {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "发生未知错误");
        }
        return ajaxResult;

    }

    /**
     * 修改学生密码
     *
     * @param account     学号（账号）
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 返回信息
     */
    @ApiOperation(value = "修改学生密码", httpMethod = "POST")
    @PostMapping("/updatePassword")
    @ResponseBody
    public AjaxResult updatePassword(String account, String oldPassword, String newPassword) {
        try {
            if (newPassword == null || newPassword.equals("")) {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "修改失败，密码不能为空");
                return ajaxResult;
            } else if (oldPassword.equals(newPassword)) {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "修改失败，新密码与旧密码相同");
                return ajaxResult;
            }
            CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
            if (cqieStudentService.updateCqieStudentPass(account, passwordService.encryptPassword(cqieStudent.getStuName(), oldPassword, cqieStudent.getStuSalt()), passwordService.encryptPassword(cqieStudent.getStuName(), newPassword, cqieStudent.getStuSalt())) > 0) {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功");
            } else {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "修改失败");
            }
        } catch (NullPointerException e) {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "无该数据");
        } catch (Exception e) {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "发生错误");
        }
        return ajaxResult;

    }

    /**
     * 获得用户信息接口
     *
     * @param account 学号（账号）
     * @return 返回信息
     */
    @ApiOperation(value = "获得用户信息接口", httpMethod = "POST")
    @PostMapping("/getUserInfo")
    @ResponseBody
    public AjaxResult getUserinfo(String account) {
        try {
            CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
            List<String> claName = cqieStudentService.getClaName(account);
            CqieTotalRunInfo cqieTotalRunInfo = cqieRunService.getTotalRunInfo(cqieStudent.getStuId());
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", String.valueOf(cqieStudent.getStuId()));
            data.put("account", cqieStudent.getStuNo());
            data.put("nickName", cqieStudent.getStuName());
            data.put("department", String.join(",", claName));
            data.put("sex", getStuSex(cqieStudent.getStuSex()));
            data.put("age", cqieStudent.getStuAge());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            data.put("birthday", cqieStudent.getStuBirthday() == null ? null : simpleDateFormat.format(cqieStudent.getStuBirthday()));
            data.put("signature", cqieStudent.getStuRemark());
            data.put("headImgUrl", cqieStudent.getStuImg());
            data.put("distance", cqieTotalRunInfo.getTotalDistance());
            data.put("frequency", cqieTotalRunInfo.getTotalFrequency());
            data.put("duration", cqieTotalRunInfo.getTotalDuration());
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功", data);
        } catch (NullPointerException e) {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "无该数据");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "发生错误");
        }
        return ajaxResult;

    }

    /**
     * 运动开始
     *
     * @param account    学号（账号）
     * @param startPoint 经纬度
     * @return 返回信息
     */
    @ApiOperation(value = "运动开始", httpMethod = "POST")
    @PostMapping("/startSport")
    @ResponseBody
    public AjaxResult startSport(String account, String startPoint/*, String sign, String timeStamp, String nonc*/) {
        try {
            CqieRun cqieRun = new CqieRun();
            CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
            if (cqieStudent != null) {
                cqieRun.setRunStuId(cqieStudent.getStuId());
                cqieRun.setRunStar(startPoint);
                Date date = new Date();
                cqieRun.setRunTermId((long) 2);// 学期ID   还未活用
                cqieRun.setRunAddtime(date);
                cqieRun.setRunStarTime(date);
                if (cqieRunService.startSport(cqieRun) > 0) {
                    HashMap<String, Object> data = new HashMap<>();
                    data.put("id", String.valueOf(cqieRun.getRunId()));
                    data.put("startTime", date);
                    ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功", data);
                } else {
                    ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "添加失败");
                }
            } else {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "发生错误");
        }
        return ajaxResult;

    }

    /**
     * 运动结束
     *
     * @param cqieRunEndSport 跑步信息对象
     * @return 返回信息
     */
    @ApiOperation(value = "运动结束", httpMethod = "POST")
    @ApiImplicitParam(value = "跑步信息对象", paramType = "CqieRunEndSport")
    @PostMapping("/endSport")
    @ResponseBody
    public AjaxResult endSport(CqieRunEndSport cqieRunEndSport/*, String sign, String timeStamp*/) {
        try {
            //提出app端数据
            CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(cqieRunEndSport.getAccount());
            CqieRun RunStarTime = cqieRunService.selectCqieRunById(Long.valueOf(cqieRunEndSport.getId()));
            CqieRun cqieRun = new CqieRun();
            cqieRun.setRunId(Long.valueOf(cqieRunEndSport.getId()));
            cqieRun.setRunStuId(cqieStudent.getStuId());
            cqieRun.setRunDistance(cqieRunEndSport.getDistance());
            cqieRun.setRunPathline(cqieRunEndSport.getPathLine());
            cqieRun.setRunDuration(cqieRunEndSport.getDuration());
            cqieRun.setRunCalorie(cqieRunEndSport.getCalorie());
            cqieRun.setRunDistribution(cqieRunEndSport.getDistribution());
            cqieRun.setRunMaxdistribution(cqieRunEndSport.getMaxDistribution());
            cqieRun.setRunEndTime(new Date());
            cqieRun.setRunIscomplete(getStatus(cqieStudent, cqieRunEndSport));
            //更改数据库
            int i = cqieRunService.endSport(cqieRun);
            //返回给app端数据
            CqieTotalRunInfo cqieTotalRunInfo = cqieRunService.getTotalRunInfo(cqieStudent.getStuId());
            HashMap<String, Object> data = new HashMap<>();
            data.put("distance", cqieTotalRunInfo.getTotalDistance());
            data.put("frequency", cqieTotalRunInfo.getTotalFrequency());
            data.put("duration", cqieTotalRunInfo.getTotalDuration());
            data.put("startTime", cqieTotalRunInfo.getRunStarTime());
            data.put("endTime", cqieRun.getRunEndTime());
            data.put("status", cqieRun.getRunIscomplete());
            if (i > 0) {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功", data);
            } else {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "数据保存失败，请联系管理员。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "发生错误");
        }
        return ajaxResult;

    }

    /**
     * 运动日历
     *
     * @param account 学号（账号）
     * @param month   月份（数值）
     * @return 返回信息
     */
    @ApiOperation(value = "运动日历", httpMethod = "POST")
    @PostMapping("/getSportCalendar")
    @ResponseBody
    public AjaxResult getSportCalendar(String account, String month) {
        try {
            List<String> sportCalendar = cqieRunService.getSportCalendar(account, month);
            if (sportCalendar != null) {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功", sportCalendar);
            } else {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "查询失败");
            }
        } catch (Exception e) {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "发生错误");
        }
        return ajaxResult;

    }

    /**
     * 运动记录查询
     *
     * @param account   学号（账号）
     * @param startdate 开始日期   YYYY-MM-DD
     * @param enddate   结束日期    YYYY-MM-DD
     * @return 返回信息
     */
    @ApiOperation(value = "运动记录查询", httpMethod = "POST")
    @PostMapping("/getSportRecord")
    @ResponseBody
    public AjaxResult getSportRecord(String account, String startdate, String enddate) {
        try {
            List<CqieSportCalendar> cqieSportCalendars = cqieRunService.getSportRecord(account, startdate, enddate);
            if (cqieSportCalendars != null) {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功", cqieSportCalendars);
            } else {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "查询失败");
            }
        } catch (NullPointerException e) {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "查不到该数据");
        } catch (Exception e) {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "发生错误");
        }
        return ajaxResult;

    }

    /**
     * 更改头像
     *
     * @param account 学号（账号）
     * @param headImg 头像地址
     * @return 返回信息
     */
    @ApiOperation(value = "更改头像", httpMethod = "POST")
    @PostMapping("/updateHeadImg")
    @ResponseBody
    public AjaxResult updateHeadImg(String account, String headImg) {
        try {
            if (cqieStudentService.updateHeadImg(account, headImg) > 0) {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功");
            } else {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "更改失败");
            }
        } catch (Exception e) {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "发生错误");
        }
        return ajaxResult;

    }

    /**
     * 判断跑步信息是否有效
     *
     * @param cqieStudent     学生信息对象
     * @param cqieRunEndSport 跑步信息对象
     * @return 是否有效
     */
    private static int getStatus(CqieStudent cqieStudent, CqieRunEndSport cqieRunEndSport) {
        if ("男".equals(cqieStudent.getStuSex())) {
            if (cqieRunEndSport.getDistance() >= 2.5 && cqieRunEndSport.getDistribution() >= 3 && cqieRunEndSport.getDistribution() <= 9) {
                return 1;
            }
        } else if ("女".equals(cqieStudent.getStuSex())) {
            if (cqieRunEndSport.getDistance() >= 2.0 && cqieRunEndSport.getDistribution() >= 3 && cqieRunEndSport.getDistribution() <= 11) {
                return 1;
            }
        } else {
            return 0;
        }
        return 0;
    }

    /**
     * 获得性别代数
     *
     * @param stuSex 性别
     * @return 0为男  1为女  -1为异常
     */
    private static int getStuSex(String stuSex) {
        if ("男".equals(stuSex)) {
            return 0;
        } else if ("女".equals(stuSex)) {
            return 1;
        } else {
            return -1;
        }
    }

}
