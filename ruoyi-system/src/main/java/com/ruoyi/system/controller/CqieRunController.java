package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.VClassruninfo;
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
import com.ruoyi.system.domain.CqieRun;
import com.ruoyi.system.service.ICqieRunService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 跑步信息Controller
 *
 * @author xhd
 * @date 2020-09-28
 */
@Controller
@RequestMapping("/system/runinfo")
public class CqieRunController extends BaseController
{
    private String prefix = "system/runinfo";

    @Autowired
    private ICqieRunService cqieRunService;

    @RequiresPermissions("system:runinfo:view")
    @GetMapping()
    public String runinfo()
    {
        return prefix + "/runinfo";
    }

    /**
     * 查询跑步信息列表
     */
    @RequiresPermissions("system:runinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CqieRun cqieRun)
    {
        startPage();
        List<CqieRun> list = cqieRunService.selectCqieRunList(cqieRun);
        return getDataTable(list);
    }

    /**
     * 导出跑步信息列表
     */
    @RequiresPermissions("system:runinfo:export")
    @Log(title = "跑步信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CqieRun cqieRun)
    {
        List<CqieRun> list = cqieRunService.selectCqieRunList(cqieRun);
        ExcelUtil<CqieRun> util = new ExcelUtil<CqieRun>(CqieRun.class);
        return util.exportExcel(list, "runinfo");
    }

    /**
     * 新增跑步信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存跑步信息
     */
    @RequiresPermissions("system:runinfo:add")
    @Log(title = "跑步信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CqieRun cqieRun)
    {
        return toAjax(cqieRunService.insertCqieRun(cqieRun));
    }



    /**
     * 修改跑步信息
     */
    @GetMapping("/edit/{runId}")
    public String edit(@PathVariable("runId") Long runId, ModelMap mmap)
    {
        CqieRun cqieRun = cqieRunService.selectCqieRunById(runId);
        mmap.put("cqieRun", cqieRun);
        return prefix + "/edit";
    }
    /**
     * xhd
     * 查询详情
     * */
    @GetMapping("/detail/{runId}")
    public String detail(@PathVariable("runId") Long runId, ModelMap mmap)
    {
        CqieRun cqieRun = cqieRunService.selectCqieRunById(runId);
        mmap.put("cqieRun", cqieRun);
        return prefix + "/detail";
    }

    /**
     * 修改保存跑步信息
     */
    @RequiresPermissions("system:runinfo:edit")
    @Log(title = "跑步信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CqieRun cqieRun)
    {
        return toAjax(cqieRunService.updateCqieRun(cqieRun));
    }

    /**
     * 删除跑步信息
     */
    @RequiresPermissions("system:runinfo:remove")
    @Log(title = "跑步信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cqieRunService.deleteCqieRunByIds(ids));
    }

    /**
     * xhd
     * 期末存档
     */
    @RequiresPermissions("system:runinfo:saveAll")
    @Log(title = "跑步信息", businessType = BusinessType.INSERT)
    @PostMapping("/saveAll")
    @ResponseBody
    public AjaxResult saveAll(String ids)
    {
        return toAjax(cqieRunService.saveAllByIds(ids));
    }
}