package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.CqieAppinfo;
import com.ruoyi.system.service.ICqieAppinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    private String prefix = "api_v1";

    @Autowired
    private ICqieAppinfoService cqieAppinfoService;


    /**
     * 查询最新发布的appinfo
     */
    @GetMapping("/getNewVersion")
    @ResponseBody
    public AjaxResult getNewVersion()
    {
        CqieAppinfo appinfo = cqieAppinfoService.selectCqieAppinfoLatest();
        HashMap<String,Object> data = new HashMap<String,Object>();
        data.put("newVersion",appinfo.getAppiVersion());
        data.put("forceUpdate",true);
        data.put("newVersionInfo",appinfo.getRemark());
        data.put("updateUrl",appinfo.getAppiAddress());
        return AjaxResult.returnJSON(AjaxResult.Type.SUCCESS2,"ok",data);
    }
}
