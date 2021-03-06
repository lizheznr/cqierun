package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.CqieScoreMapper;
import com.ruoyi.system.service.ICqieRunService;
import com.ruoyi.system.service.ICqieSpeService;
import com.ruoyi.system.service.ICqieStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 免跑申请Controller
 *
 * @author xhd
 * @date 2020-09-29
 */
@Controller
@RequestMapping("/system/spe")
public class CqieSpeController extends BaseController
{
    private String prefix = "system/spe";

    @Autowired
    private ICqieSpeService cqieSpeService;

    @Autowired
    private ICqieStudentService cqieStudentService;

    @Autowired
    private ICqieRunService cqieRunService;

    @Autowired
    private CqieScoreMapper cqieScoreMapper;

    @RequiresPermissions("system:spe:view")
    @GetMapping()
    public String spe()
    {
        return prefix + "/spe";
    }

    /**
     * 查询免跑申请列表
     * xhd
     */
    @RequiresPermissions("system:spe:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CqieSpe cqieSpe)
    {
        List<CqieSpe> list = null;
        SysUser user = ShiroUtils.getSysUser();
       if(CqieRunController.getUserRole(user)){
           cqieSpe.setSysUser(setObj());
           startPage();
           list = cqieSpeService.selectCqieSpeListById(cqieSpe);
       }else{
           if(cqieSpe.getCqieCla().getClaName().equals("")){
               List<CqieCla> claList=cqieScoreMapper.selectAllCla();
               SysUser sysUser = new SysUser();
               sysUser.setCqieCla(claList.get(0));
               cqieSpe.setSysUser(sysUser);
           }
           startPage();
           list = cqieSpeService.selectCqieSpeListAll(cqieSpe);
       }
        return getDataTable(list);
    }

    /**
     * 导出免跑申请列表
     * xhd
     */
    @RequiresPermissions("system:spe:export")
    @Log(title = "免跑申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CqieSpe cqieSpe)
    {
        List<CqieSpe> list=null;
        SysUser user = ShiroUtils.getSysUser();
        if(CqieRunController.getUserRole(user)){
            cqieSpe.setSysUser(setObj());
            list = cqieSpeService.selectCqieSpeListById(cqieSpe);
        }else{
            if(cqieSpe.getCqieCla().getClaName().equals("")){
                List<CqieCla> claList=cqieScoreMapper.selectAllCla();
                SysUser sysUser = new SysUser();
                sysUser.setCqieCla(claList.get(0));
                cqieSpe.setSysUser(sysUser);
            }
            list = cqieSpeService.selectCqieSpeListAll(cqieSpe);
        }

        ExcelUtil<CqieSpe> util = new ExcelUtil<CqieSpe>(CqieSpe.class);
        return util.exportExcel(list, "spe");
    }

    /**
     * 新增免跑申请
     */
    @RequiresPermissions("system:spe:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存免跑申请
     */
    @RequiresPermissions("system:spe:add")
    @Log(title = "免跑申请", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CqieSpe cqieSpe)
    {
        return toAjax(cqieSpeService.insertCqieSpe(cqieSpe));
    }

    /**
     * 修改免跑申请
     */
    @RequiresPermissions("system:spe:edit")
    @GetMapping("/edit/{speId}")
    public String edit(@PathVariable("speId") Long speId, ModelMap mmap)
    {
        CqieSpe cqieSpe = cqieSpeService.selectCqieSpeById(speId);
        mmap.put("cqieSpe", cqieSpe);
        System.out.println(cqieSpe);
        return prefix + "/edit";
    }

    /**
     * 修改保存免跑申请
     */
    @RequiresPermissions("system:spe:edit")
    @Log(title = "免跑申请", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CqieSpe cqieSpe)
    {
        return toAjax(cqieSpeService.updateCqieSpe(cqieSpe));
    }

    /**
     * 删除免跑申请
     */
    @RequiresPermissions("system:spe:remove")
    @Log(title = "免跑申请", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cqieSpeService.deleteCqieSpeByIds(ids));
    }

    /**
     * xhd
     * 批准状态修改
     */
    @RequiresPermissions("system:spe:edit")
    @Log(title = "免跑申请", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(CqieSpe cqieSpe)
    {
        return toAjax(cqieSpeService.changeStatus(cqieSpe));
    }



    /**
     * xhd
     * 查询所有学生列表
     */
    @RequiresPermissions("system:spe:add:selectStudent")
    @PostMapping("/add/studentList")
    @ResponseBody
    public TableDataInfo studentList(CqieStudent student)
    {
        startPage();
        List<CqieStudent> list = cqieStudentService.selectCqieStudentList(student);
        return getDataTable(list);
    }

    /**
     * xhd
     * 选择分配学生
     */
    @RequiresPermissions("system:spe:add:selectStudent")
    @GetMapping("/add/selectStudent")
    public String selectStudent()
    {
        return prefix + "/selectStudent";
    }

    /**
     * 配置导出方法
     * */
    public SysUser setObj(){
        Long userId = ShiroUtils.getUserId();
        //设置用户id
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        //获取该用户的班级 获取所在班的第一个班
        List<CqieCla> claList=cqieRunService.selectAllClassByUserId(userId);
        CqieCla cla = claList.get(0);
        sysUser.setClaId(cla.getClaId());
        //将参数传入cqieRun
        return sysUser;
    }

}