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
import com.ruoyi.system.service.ICqieStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private ICqieStudentService cqieStudentService;

    @RequiresPermissions("system:runinfo:view")
    @GetMapping()
    public String runinfo(Model model)
    {
        return prefix + "/runinfo";
    }


    /**
     * xhd
     * 搜索框消息
     * */
    @RequiresPermissions("system:runinfo:claAndTermDatas")
    @PostMapping("/claAndTermDatas")
    @ResponseBody
    public String claAndTermDatas(ModelMap mmap)
    {
        Long userId = ShiroUtils.getUserId();
        CqieRun cqieRun = cqieRunService.selectClaAndTermByUserId(userId);
        System.out.println("-------------------------------->>>>>>>>"+cqieRun);
        mmap.put("cqieRun", cqieRun);
        return prefix + "/claAndTermDatas";
    }



    /**
     * 查询跑步信息列表
     * xhd
     */
    @RequiresPermissions("system:runinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CqieRun cqieRun)
    {

        List<CqieRun> list=null;
        SysUser user = ShiroUtils.getSysUser();
          //为普通用户则根据所带班查看相应班级跑步信息
       if(getUserRole(user)){
           cqieRun.setSysUser(setObj());
           startPage();
           list= cqieRunService.selectCqieRunListById(cqieRun);
       }else {//非普通用户则查看全部信息
           startPage();
           list = cqieRunService.selectCqieRunListAll(cqieRun);
       }

        return getDataTable(list);
    }

    /**
     * 导出跑步信息列表
     * xhd
     */
    @RequiresPermissions("system:runinfo:export")
    @Log(title = "跑步信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CqieRun cqieRun)
    {
        List<CqieRun> list=null;
        SysUser user = ShiroUtils.getSysUser();
        if(getUserRole(user)){
            cqieRun.setSysUser(setObj());
            list = cqieRunService.selectCqieRunListById(cqieRun);
        }else{
            list = cqieRunService.selectCqieRunListAll(cqieRun);
         }
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
     * 获取普通用户角色
     * */
    public static boolean getUserRole(SysUser user){
        List<SysRole> roleList=user.getRoles();
        for(SysRole role:roleList){
            if(role.getRoleKey().equals("common")){
                return true;
            }
            break;
        }
        return false;
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