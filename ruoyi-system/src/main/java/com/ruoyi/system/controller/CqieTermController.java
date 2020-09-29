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
import com.ruoyi.system.domain.CqieTerm;
import com.ruoyi.system.service.ICqieTermService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学期Controller
 * 
 * @author sunly
 * @date 2020-09-29
 */
@Controller
@RequestMapping("/system/term")
public class CqieTermController extends BaseController
{
    private String prefix = "system/term";

    @Autowired
    private ICqieTermService cqieTermService;

    @RequiresPermissions("system:term:view")
    @GetMapping()
    public String term()
    {
        return prefix + "/term";
    }

    /**
     * 查询学期列表
     */
    @RequiresPermissions("system:term:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CqieTerm cqieTerm)
    {
        startPage();
        List<CqieTerm> list = cqieTermService.selectCqieTermList(cqieTerm);
        return getDataTable(list);
    }

    /**
     * 导出学期列表
     */
    @RequiresPermissions("system:term:export")
    @Log(title = "学期", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CqieTerm cqieTerm)
    {
        List<CqieTerm> list = cqieTermService.selectCqieTermList(cqieTerm);
        ExcelUtil<CqieTerm> util = new ExcelUtil<CqieTerm>(CqieTerm.class);
        return util.exportExcel(list, "term");
    }

    /**
     * 新增学期
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学期
     */
    @RequiresPermissions("system:term:add")
    @Log(title = "学期", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CqieTerm cqieTerm)
    {
        return toAjax(cqieTermService.insertCqieTerm(cqieTerm));
    }

    /**
     * 修改学期
     */
    @GetMapping("/edit/{termId}")
    public String edit(@PathVariable("termId") Integer termId, ModelMap mmap)
    {
        CqieTerm cqieTerm = cqieTermService.selectCqieTermById(termId);
        mmap.put("cqieTerm", cqieTerm);
        return prefix + "/edit";
    }

    /**
     * 修改保存学期
     */
    @RequiresPermissions("system:term:edit")
    @Log(title = "学期", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CqieTerm cqieTerm)
    {
        return toAjax(cqieTermService.updateCqieTerm(cqieTerm));
    }

    /**
     * 删除学期
     */
    @RequiresPermissions("system:term:remove")
    @Log(title = "学期", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cqieTermService.deleteCqieTermByIds(ids));
    }
}
