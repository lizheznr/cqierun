package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.CqieRun;
import com.ruoyi.system.domain.CqieStudent;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ICqieClaService;
import com.ruoyi.system.service.ICqieRunService;
import com.ruoyi.system.service.ICqieStudentService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CqieSpe;
import com.ruoyi.system.service.ICqieSpeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

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

    @RequiresPermissions("system:spe:view")
    @GetMapping()
    public String spe()
    {
        return prefix + "/spe";
    }

    /**
     * 查询免跑申请列表
     */
    @RequiresPermissions("system:spe:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CqieSpe cqieSpe)
    {
        startPage();
        List<CqieSpe> list = cqieSpeService.selectCqieSpeList(cqieSpe);
        return getDataTable(list);
    }

    /**
     * 导出免跑申请列表
     */
    @RequiresPermissions("system:spe:export")
    @Log(title = "免跑申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CqieSpe cqieSpe)
    {
        List<CqieSpe> list = cqieSpeService.selectCqieSpeList(cqieSpe);
        ExcelUtil<CqieSpe> util = new ExcelUtil<CqieSpe>(CqieSpe.class);
        return util.exportExcel(list, "spe");
    }

    /**
     * 新增免跑申请
     */
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
    @Log(title = "免跑申请", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:spe:edit")
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

}