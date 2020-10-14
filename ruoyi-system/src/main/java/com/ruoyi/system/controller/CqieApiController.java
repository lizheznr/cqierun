package com.ruoyi.system.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.CqieAppinfo;
import com.ruoyi.system.service.ICqieAppinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;

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


    @ApiOperation("获取最新的APP版本")
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
