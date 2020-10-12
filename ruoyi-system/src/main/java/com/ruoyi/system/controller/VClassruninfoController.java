package com.ruoyi.system.controller;

import java.util.List;
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
import com.ruoyi.system.domain.VClassruninfo;
import com.ruoyi.system.service.IVClassruninfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

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

    @RequiresPermissions("system:classruninfo:view")
    @GetMapping()
    public String classruninfo()
    {
        return prefix + "/classruninfo";
    }

    /**
     * 查询班级成绩列表
     */
    @RequiresPermissions("system:classruninfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VClassruninfo vClassruninfo)
    {
        startPage();
        List<VClassruninfo> list = vClassruninfoService.selectVClassruninfoList(vClassruninfo);
        return getDataTable(list);
    }

    /**
     * 导出班级成绩列表
     */
    @RequiresPermissions("system:classruninfo:export")
    @Log(title = "班级成绩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VClassruninfo vClassruninfo)
    {
        List<VClassruninfo> list = vClassruninfoService.selectVClassruninfoList(vClassruninfo);
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
}
