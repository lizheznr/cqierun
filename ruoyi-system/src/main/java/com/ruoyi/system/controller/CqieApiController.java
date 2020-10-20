package com.ruoyi.system.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.CqieAppinfo;
import com.ruoyi.system.domain.CqieRun;
import com.ruoyi.system.domain.CqieRunEndSport;
import com.ruoyi.system.domain.CqieStudent;
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
        HashMap<String,Object> data = new HashMap<String,Object>();
        data.put("newVersion",appInfo.getAppiVersion());
        data.put("forceUpdate",true);
        data.put("newVersionInfo",appInfo.getRemark());
        data.put("updateUrl",appInfo.getAppiAddress());
        return AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功",data);
    }

    /**
     * 登录
     * @param account   学号（账号）
     * @param upass     密码
     * @return data
     */
    @ApiOperation(value = "登录",httpMethod = "POST")
    @PostMapping("/login/{id}/{pass}")
    @ResponseBody
    public AjaxResult login(@PathVariable("id") String account, @PathVariable("pass") String upass){
        CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
        System.out.println(cqieStudent.getStuSalt());
        if (cqieStudentService.login(account, new Md5Hash(cqieStudent.getStuName() + upass + cqieStudent.getStuSalt()).toHex()) != null){
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功","");
        }else{
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS,"查询错误","");
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
    @PostMapping("/updatePassword/{id}/{oldPass}/{newPass}")
    @ResponseBody
    public AjaxResult updatePassword(@PathVariable("id") String account,@PathVariable("oldPass") String oldPassword,@PathVariable("newPass") String newPassword){
        CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
        System.out.println(cqieStudent.getStuSalt());
        if (cqieStudentService.updateCqieStudentPass(account, new Md5Hash(cqieStudent.getStuName() + oldPassword + cqieStudent.getStuSalt()).toHex(), new Md5Hash(cqieStudent.getStuName() + newPassword + cqieStudent.getStuSalt()).toHex()) > 0){
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功","");
        }else{
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS,"修改错误","");
        }
        return ajaxResult;
    }

    /**
     * 获得用户信息接口
     * @param account 学号（账号）
     * @return data
     */
    @ApiOperation(value = "获得用户信息接口",httpMethod = "POST")
    @PostMapping("/getUserinfo/{id}")
    @ResponseBody
    public AjaxResult getUserinfo(@PathVariable("id") String account){
        CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
        HashMap<String, Object> data = new HashMap<>();
        data.put("id",cqieStudent.getStuId());
        data.put("account",cqieStudent.getStuNo());
        data.put("nickName",cqieStudent.getStuName());
        data.put("department",cqieStudent.getClaId());
        data.put("sex",cqieStudent.getStuSex());
        data.put("age",null);
        data.put("birthday",cqieStudent.getStuBirthday());
        data.put("signature",cqieStudent.getStuRemark());
        data.put("headImgUrl",cqieStudent.getStuImg());
        if (data != null) {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功", data);
        }else {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS,"查询错误","");
        }
        return ajaxResult;
    }

    /**
     * 运动开始
     * @param account   学号（账号）
     * @param runStar  经纬度
     * @return data
     */
    @ApiOperation(value = "运动开始",httpMethod = "POST")
    @PostMapping("/startSport/{id}/{runStar}")
    @ResponseBody
    public AjaxResult startSport(@PathVariable("id") String account,@PathVariable("runStar") String runStar){
        CqieRun cqieRun = new CqieRun();
        CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(account);
        if (cqieStudent != null) {
            cqieRun.setRunStuId(cqieStudent.getStuId());
            cqieRun.setRunStar(runStar);
            Date date = new Date();
            cqieRun.setRunAddtime(date);
            if (cqieRunService.startSport(cqieRun) > 0){
                HashMap<String,Object> data = new HashMap<>();
                data.put("id",cqieRun.getRunId());
                data.put("startTime",date);
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2, "成功",data);
            }else {
                ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS,"添加失败","");
            }
        }else {
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS,"添加失败","");
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
        //提出app数据
        CqieRun cqieRun = new CqieRun();
        cqieRun.setRunId(cqieRunEndSport.getRunId());
        cqieRun.setRunDistance(cqieRunEndSport.getRunDistance());
        cqieRun.setRunStar(cqieRunEndSport.getRunPathline());
        cqieRun.setRunDuration(cqieRunEndSport.getRunDuration());
        cqieRun.setRunCalorie(cqieRunEndSport.getRunCalorie());
        cqieRun.setRunDistribution(cqieRunEndSport.getRunDistribution());
        cqieRun.setRunMaxdistribution(cqieRunEndSport.getRunMaxdistribution());
        //返回数据
        HashMap<String, Object> data = new HashMap<>();
        data.put("distance",null);
        data.put("frequency",null);
        data.put("duration",null);
        if (cqieRunService.endSport(cqieRun) > 0){
            data.put("status",1);
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功",data);
        }else{
            data.put("status",0);
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS,"保存失败",data);
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
    @PostMapping("/getSportCalendar/{id}/{month}")
    @ResponseBody
    public AjaxResult getSportCalendar(@PathVariable("id") String account,@PathVariable("month") String month){
        List<String> sportCalendar = cqieRunService.getSportCalendar(account, month);
        if (sportCalendar != null){
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功",sportCalendar);
        }else{
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS,"查询失败","");
        }
        return ajaxResult;
    }

    /**
     * 运动记录查询
     * @param account     学号（账号）
     * @param date      日期   YYYY-MM-DD
     * @return data
     */
    @ApiOperation(value = "运动记录查询",httpMethod = "POST")
    @PostMapping("getSportRecord/{id}/{date}")
    @ResponseBody
    public AjaxResult getSportRecord(@PathVariable("id") String account,@PathVariable("date") String date){
        CqieRun sportRecord = cqieRunService.getSportRecord(account, date);
        HashMap<String, Object> data = new HashMap<>();
        data.put("运动距离", sportRecord.getRunDistance());
        data.put("运动时长", sportRecord.getRunDuration());
        data.put("消耗卡路里", sportRecord.getRunCalorie());
        data.put("平均配速", sportRecord.getRunDistribution());
        data.put("开始时间", sportRecord.getRunStarTime());
        data.put("结束时间", sportRecord.getRunEndTime());
        if (sportRecord != null) {
            data.put("数据状态", 1);
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功",data);
        } else{
            data.put("数据状态", 0);
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS,"查询失败",data);
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
    @PostMapping("/updateHeadImg/{id}/{headImg}")
    @ResponseBody
    public AjaxResult updateHeadImg(@PathVariable("id") String account,@PathVariable("headImg") String headImg){
        if (cqieStudentService.updateHeadImg(account, headImg) > 0){
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"成功","");
        }else{
            ajaxResult = AjaxResult.returnJSON(AjaxResult.Type.SUCCESS,"保存失败","");
        }
        return ajaxResult;
    }

}
