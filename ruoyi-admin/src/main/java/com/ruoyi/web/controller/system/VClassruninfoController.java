package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.ICqieRunService;
import com.ruoyi.system.service.IVClassruninfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级成绩Controller
 * 
 * @author xhd
 * @date 2020-10-09
 */
@Controller
@RequestMapping("/system/classruninfo")
public class VClassruninfoController extends BaseController
{
    private String prefix = "system/classruninfo";

    @Autowired
    private IVClassruninfoService vClassruninfoService;

    @Autowired
    private ICqieRunService cqieRunService;

    @RequiresPermissions("system:classruninfo:view")
    @GetMapping()
    public String classruninfo()
    {
        return prefix + "/classruninfo";
    }

    /**
     * 查询班级成绩列表
     * xhd
     */
    @RequiresPermissions("system:classruninfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VClassruninfo vClassruninfo)
    {
        
        List<VClassruninfo> list=null;
        SysUser user = ShiroUtils.getSysUser();
        if(CqieRunController.getUserRole(user)){
            vClassruninfo.setSysUser(setObj());
            startPage();
            list = vClassruninfoService.selectVClassruninfoListById(vClassruninfo);
        }else{
            startPage();
            list = vClassruninfoService.selectVClassruninfoListAll(vClassruninfo);
    }
        return getDataTable(list);
    }

    /**
     * 导出班级成绩列表
     * xhd
     */
    @RequiresPermissions("system:classruninfo:export")
    @Log(title = "班级成绩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VClassruninfo vClassruninfo)
    {
        List<VClassruninfo> list=null;
        SysUser user = ShiroUtils.getSysUser();
        if(CqieRunController.getUserRole(user)){
            vClassruninfo.setSysUser(setObj());
            list = vClassruninfoService.selectVClassruninfoListById(vClassruninfo);
        }else{
            list = vClassruninfoService.selectVClassruninfoListAll(vClassruninfo);
        }

        ExcelUtil<VClassruninfo> util = new ExcelUtil<VClassruninfo>(VClassruninfo.class);
        return util.exportExcel(list, "classruninfo");
    }

    /**
     * 新增班级成绩
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存班级成绩
     */
    @RequiresPermissions("system:classruninfo:add")
    @Log(title = "班级成绩", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VClassruninfo vClassruninfo)
    {
        return toAjax(vClassruninfoService.insertVClassruninfo(vClassruninfo));
    }

    /**
     * 修改班级成绩
     */
    @GetMapping("/edit/{stuNo}")
    public String edit(@PathVariable("stuNo") String stuNo, ModelMap mmap)
    {
        VClassruninfo vClassruninfo = vClassruninfoService.selectVClassruninfoById(stuNo);
        mmap.put("vClassruninfo", vClassruninfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存班级成绩
     */
    @RequiresPermissions("system:classruninfo:edit")
    @Log(title = "班级成绩", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VClassruninfo vClassruninfo)
    {
        return toAjax(vClassruninfoService.updateVClassruninfo(vClassruninfo));
    }
    /**
     * 删除班级成绩
     */
    @RequiresPermissions("system:classruninfo:remove")
    @Log(title = "班级成绩", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vClassruninfoService.deleteVClassruninfoByIds(ids));
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
