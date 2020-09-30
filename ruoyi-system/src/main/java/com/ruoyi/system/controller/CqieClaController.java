package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysPostService;
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
import com.ruoyi.system.domain.CqieCla;
import com.ruoyi.system.service.ICqieClaService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * claController
 * 
 * @author sunly
 * @date 2020-09-28
 */
@Controller
@RequestMapping("/system/cla")
public class CqieClaController extends BaseController
{
    private String prefix = "system/cla";

    @Autowired
    private ICqieClaService cqieClaService;

    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("system:cla:view")
    @GetMapping()
    public String cla(ModelMap mmap)
    {
        mmap.put("depts", deptService.selectDeptList(new SysDept()));
        return prefix + "/cla";
    }

    /**
     * 查询cla列表
     */
    @RequiresPermissions("system:cla:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CqieCla cqieCla)
    {
        startPage();
        List<CqieCla> list = cqieClaService.selectCqieClaList(cqieCla);
        return getDataTable(list);
    }

    /**
     * 导出cla列表
     */
    @RequiresPermissions("system:cla:export")
    @Log(title = "cla", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CqieCla cqieCla)
    {
        List<CqieCla> list = cqieClaService.selectCqieClaList(cqieCla);
        ExcelUtil<CqieCla> util = new ExcelUtil<CqieCla>(CqieCla.class);
        return util.exportExcel(list, "cla");
    }

    /**
     * 新增cla
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存cla
     */
    @RequiresPermissions("system:cla:add")
    @Log(title = "cla", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CqieCla cqieCla)
    {
        return toAjax(cqieClaService.insertCqieCla(cqieCla));
    }

    /**
     * 修改cla
     */
    @GetMapping("/edit/{claId}")
    public String edit(@PathVariable("claId") Integer claId, ModelMap mmap)
    {
        CqieCla cqieCla = cqieClaService.selectCqieClaById(claId);
        mmap.put("cqieCla", cqieCla);
        return prefix + "/edit";
    }

    /**
     * 修改保存cla
     */
    @RequiresPermissions("system:cla:edit")
    @Log(title = "cla", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CqieCla cqieCla)
    {
        return toAjax(cqieClaService.updateCqieCla(cqieCla));
    }

    /**
     * 删除cla
     */
    @RequiresPermissions("system:cla:remove")
    @Log(title = "cla", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cqieClaService.deleteCqieClaByIds(ids));
    }
}
