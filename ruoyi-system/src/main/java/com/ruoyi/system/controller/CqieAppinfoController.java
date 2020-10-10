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
import com.ruoyi.system.domain.CqieAppinfo;
import com.ruoyi.system.service.ICqieAppinfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * appinfoController
 * 
 * @author sunly
 * @date 2020-09-28
 */
@Controller
@RequestMapping("/system/appinfo")
public class CqieAppinfoController extends BaseController
{
    private String prefix = "system/appinfo";

    @Autowired
    private ICqieAppinfoService cqieAppinfoService;

    @RequiresPermissions("system:appinfo:view")
    @GetMapping()
    public String appinfo()
    {
        return prefix + "/appinfo";
    }

    /**
     * 查询appinfo列表
     */
    @RequiresPermissions("system:appinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CqieAppinfo cqieAppinfo)
    {
        startPage();
        List<CqieAppinfo> list = cqieAppinfoService.selectCqieAppinfoList(cqieAppinfo);
        return getDataTable(list);
    }

    /**
     * 导出appinfo列表
     */
    @RequiresPermissions("system:appinfo:export")
    @Log(title = "appinfo", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CqieAppinfo cqieAppinfo)
    {
        List<CqieAppinfo> list = cqieAppinfoService.selectCqieAppinfoList(cqieAppinfo);
        ExcelUtil<CqieAppinfo> util = new ExcelUtil<CqieAppinfo>(CqieAppinfo.class);
        return util.exportExcel(list, "appinfo");
    }

    /**
     * 新增appinfo
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存appinfo
     */
    @RequiresPermissions("system:appinfo:add")
    @Log(title = "appinfo", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CqieAppinfo cqieAppinfo)
    {
        return toAjax(cqieAppinfoService.insertCqieAppinfo(cqieAppinfo));
    }

    /**
     * 修改appinfo
     */
    @GetMapping("/edit/{appiId}")
    public String edit(@PathVariable("appiId") Integer appiId, ModelMap mmap)
    {
        CqieAppinfo cqieAppinfo = cqieAppinfoService.selectCqieAppinfoById(appiId);
        mmap.put("cqieAppinfo", cqieAppinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存appinfo
     */
    @RequiresPermissions("system:appinfo:edit")
    @Log(title = "appinfo", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CqieAppinfo cqieAppinfo)
    {
        return toAjax(cqieAppinfoService.updateCqieAppinfo(cqieAppinfo));
    }

    /**
     * 删除appinfo
     */
    @RequiresPermissions("system:appinfo:remove")
    @Log(title = "appinfo", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cqieAppinfoService.deleteCqieAppinfoByIds(ids));
    }

    /**
     * 发布状态修改
     */
    @Log(title = "app版本", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:appinfo:edit")
    @PostMapping("/changePubStatus")
    @ResponseBody
    public AjaxResult changePubStatus(CqieAppinfo cqieAppinfo)
    {
//    	cqieAppinfoService.checkRoleAllowed(role);
        return toAjax(cqieAppinfoService.updateCqieAppinfo(cqieAppinfo));
    }

}
