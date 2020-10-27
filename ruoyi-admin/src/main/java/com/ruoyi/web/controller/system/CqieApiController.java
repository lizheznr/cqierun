package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.ICqieAppinfoService;
import com.ruoyi.system.service.ICqieRunService;
import com.ruoyi.system.service.ICqieStudentService;
import io.swagger.annotations.ApiImplicitParam;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * ApiController
 * 
 * @author sunly
 * @date 2020-10-10
 */
@Controller
@RequestMapping("/api_v1")
public class CqieApiController extends BaseController
{
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
     * @return data
     */
    @ApiOperation(value = "获取最新的APP版本",httpMethod = "POST")
    @PostMapping("/getNewVersion")
    @ResponseBody
    public AjaxResult getNewVersion()
    {
        CqieAppinfo appInfo = cqieAppinfoService.selectCqieAppinfoLatest();
        HashMap<String,Object> data = new HashMap<>();
        data.put("newVersion",appInfo.getAppiVersion());
        data.put("forceUpdate",true);
        data.put("newVersionInfo",appInfo.getRemark());
        data.put("updateUrl",appInfo.getAppiAddress());
        return AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功",data);
    }

    /**
     * 登录
     * 20201027 sunly edit
     * @param account   学号（账号）
     * @param password     密码
     * @return data
     */
    @ApiOperation(value = "登录",httpMethod = "POST")
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult login( String account, String password){
        try {
            CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
            if (cqieStudentService.login(account, passwordService.encryptPassword(cqieStudent.getStuName(),password,cqieStudent.getStuSalt())) != null){
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功");
            } else {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"账号或密码错误");
            }
        }catch (NullPointerException e){
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"账号或密码错误");
        }catch (Exception e){
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"发生未知错误");
        }
        return ajaxResult;

    }

    /**
     * 修改学生密码
     * @param account     学号（账号）
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return data
     */
    @ApiOperation(value = "修改学生密码",httpMethod = "POST")
    @PostMapping("/updatePassword")
    @ResponseBody
    public AjaxResult updatePassword(String account, String oldPassword, String newPassword){
        try {
            CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
            if (cqieStudentService.updateCqieStudentPass(account, passwordService.encryptPassword(cqieStudent.getStuName(),oldPassword,cqieStudent.getStuSalt()), passwordService.encryptPassword(cqieStudent.getStuName(),newPassword,cqieStudent.getStuSalt())) > 0){
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功");
            }else{
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "发生错误");
        }
        return ajaxResult;
    }

    /**
     * 获得用户信息接口
     * @param account 学号（账号）
     * @return data
     */
    @ApiOperation(value = "获得用户信息接口",httpMethod = "POST")
    @PostMapping("/getUserInfo")
    @ResponseBody
    public AjaxResult getUserinfo(String account){
        try {
            CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
            HashMap<String, Object> data = new HashMap<>();
            data.put("id",String.valueOf(cqieStudent.getStuId()));
            data.put("account",cqieStudent.getStuNo());
            data.put("nickName",cqieStudent.getStuName());
            data.put("department",cqieStudent.getClaId());
            data.put("sex",cqieStudent.getStuSex());
            data.put("age",null);
            data.put("birthday",cqieStudent.getStuBirthday());
            data.put("signature",cqieStudent.getStuRemark());
            data.put("headImgUrl",cqieStudent.getStuImg());
            if (cqieStudent != null) {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功", data);
            }else {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"查询错误","");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"发生错误","");
        }
        return ajaxResult;

    }

    /**
     * 运动开始
     * @param account   学号（账号）
     * @param startPoint  经纬度
     * @return data
     */
    @ApiOperation(value = "运动开始",httpMethod = "POST")
    @PostMapping("/startSport")
    @ResponseBody
    public AjaxResult startSport(String account, String startPoint){
        try {
            CqieRun cqieRun = new CqieRun();
            CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
            if (cqieStudent != null) {
                cqieRun.setRunStuId(cqieStudent.getStuId());
                cqieRun.setRunStar(startPoint);
                Date date = new Date();
                cqieRun.setRunTermId((long) 2);
                cqieRun.setRunAddtime(date);
                cqieRun.setRunStarTime(date);
                if (cqieRunService.startSport(cqieRun) > 0){
                    HashMap<String,Object> data = new HashMap<>();
                    data.put("id",String.valueOf(cqieRun.getRunId()));
                    data.put("startTime",date);
                    ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功",data);
                }else {
                    ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"添加失败","");
                }
            }else {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"添加失败","");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"发生错误","");
        }
        return ajaxResult;

    }

    /**
     * 运动结束
     * @param cqieRunEndSport     跑步信息对象
     * @return data
     */
    @ApiOperation(value = "运动结束",httpMethod = "POST")
    @ApiImplicitParam(value = "跑步信息对象",paramType = "CqieRunEndSport")
    @PostMapping("/endSport")
    @ResponseBody
    public AjaxResult endSport(CqieRunEndSport cqieRunEndSport){
        try {
            //提出app端数据
            CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(cqieRunEndSport.getAccount());
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
            //更改数据库
            int i = cqieRunService.endSport(cqieRun);
            //返回给app端数据
            CqieTotalRunInfo cqieTotalRunInfo = cqieRunService.getTotalRunInfo(cqieStudent.getStuId());
            HashMap<String, Object> data = new HashMap<>();
            data.put("distance",cqieTotalRunInfo.getTotalDistance());
            data.put("frequency",cqieTotalRunInfo.getTotalFrequency());
            data.put("duration",cqieTotalRunInfo.getTotalDuration());
            data.put("startTime",cqieTotalRunInfo.getRunStarTime());
            data.put("endTime",cqieRun.getRunEndTime());
            if (i > 0){
                data.put("status",1);
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功",data);
            }else{
                data.put("status",0);
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"保存失败",data);
            }
        }catch (Exception e) {
            e.printStackTrace();
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL, "发生错误", "");
        }
        return ajaxResult;

    }

    /**
     * 运动日历
     * @param account    学号（账号）
     * @param month     月份（数值）
     * @return data
     */
    @ApiOperation(value = "运动日历",httpMethod = "POST")
    @PostMapping("/getSportCalendar")
    @ResponseBody
    public AjaxResult getSportCalendar(String account, String month){
        try {
            List<String> sportCalendar = cqieRunService.getSportCalendar(account, month);
            if (sportCalendar != null){
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功",sportCalendar);
            }else{
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"查询失败","");
            }
        }catch (Exception e){
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"发生错误","");
        }
        return ajaxResult;

    }

    /**
     * 运动记录查询
     * @param account     学号（账号）
     * @param startdate      开始日期   YYYY-MM-DD
     * @param enddate       结束日期    YYYY-MM-DD
     * @return data
     */
    @ApiOperation(value = "运动记录查询",httpMethod = "POST")
    @PostMapping("/getSportRecord")
    @ResponseBody
    public AjaxResult getSportRecord(String account, String startdate, String enddate){
        try {
            List<CqieSportCalendar> cqieSportCalendars = cqieRunService.getSportRecord(account, startdate, enddate);
            if (cqieSportCalendars != null) {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功",cqieSportCalendars);
            } else{
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"查询失败",cqieSportCalendars);
            }
        }catch (NullPointerException e){
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"查不到该数据","");
        }catch (Exception e){
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"发生错误","");
        }
        return ajaxResult;

    }

    /**
     * 更改头像
     * @param account     学号（账号）
     * @param headImg   头像地址
     * @return data
     */
    @ApiOperation(value = "更改头像",httpMethod = "POST")
    @PostMapping("/updateHeadImg")
    @ResponseBody
    public AjaxResult updateHeadImg(String account, String headImg){
        try {
            if (cqieStudentService.updateHeadImg(account, headImg) > 0){
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功","");
            }else{
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"保存失败","");
            }
        }catch (Exception e){
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.FAIL,"发生错误","");
        }
        return ajaxResult;

    }
}
