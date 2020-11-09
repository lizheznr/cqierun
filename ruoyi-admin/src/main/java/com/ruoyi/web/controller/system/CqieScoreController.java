package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.CqieCla;
import com.ruoyi.system.domain.CqieScore;
import com.ruoyi.system.domain.CqieSpe;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ICqieRunService;
import com.ruoyi.system.service.ICqieScoreService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学期成绩Controller
 *
 * @author xhd
 * @date 2020-10-09
 */
@Controller
@RequestMapping("/system/score")
public class CqieScoreController extends BaseController
{
    private String prefix = "system/score";

    @Autowired
    private ICqieScoreService cqieScoreService;

    @Autowired
    private ICqieRunService cqieRunService;

    @RequiresPermissions("system:score:view")
    @GetMapping()
    public String score()
    {
        return prefix + "/score";
    }

    /**
     * 查询学期成绩列表
     * xhd
     */
    @RequiresPermissions("system:score:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CqieScore cqieScore)
    {

        List<CqieScore> list = null;
        SysUser user = ShiroUtils.getSysUser();
    if(CqieRunController.getUserRole(user)){
        cqieScore.setSysUser(setObj());
        startPage();
        list = cqieScoreService.selectCqieScoreListById(cqieScore);
    }else{
        startPage();
        list = cqieScoreService.selectCqieScoreListAll(cqieScore);
    }
        return getDataTable(list);
    }

    /**
     * 导出学期成绩列表
     * xhd
     */
    @RequiresPermissions("system:score:export")
    @Log(title = "学期成绩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CqieScore cqieScore)
    {

        List<CqieScore> list=null;
        SysUser user = ShiroUtils.getSysUser();
        if(CqieRunController.getUserRole(user)){
            cqieScore.setSysUser(setObj());
            list = cqieScoreService.selectCqieScoreListById(cqieScore);
        }else{
            list = cqieScoreService.selectCqieScoreListAll(cqieScore);
        }

        ExcelUtil<CqieScore> util = new ExcelUtil<CqieScore>(CqieScore.class);
        return util.exportExcel(list, "score");
    }

    /**
     * 新增学期成绩
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学期成绩
     */
    @RequiresPermissions("system:score:add")
    @Log(title = "学期成绩", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CqieScore cqieScore)
    {
        return toAjax(cqieScoreService.insertCqieScore(cqieScore));
    }

    /**
     * 修改学期成绩
     */
    @GetMapping("/edit/{scoreId}")
    public String edit(@PathVariable("scoreId") Long scoreId, ModelMap mmap)
    {
        CqieScore cqieScore = cqieScoreService.selectCqieScoreById(scoreId);
        mmap.put("cqieScore", cqieScore);
        return prefix + "/edit";
    }

    /**
     * 修改保存学期成绩
     */
    @RequiresPermissions("system:score:edit")
    @Log(title = "学期成绩", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CqieScore cqieScore)
    {
        return toAjax(cqieScoreService.updateCqieScore(cqieScore));
    }

    /**
     * 删除学期成绩
     */
    @RequiresPermissions("system:score:remove")
    @Log(title = "学期成绩", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cqieScoreService.deleteCqieScoreByIds(ids));
    }

    /**
     * xhd
     * 学期成绩存档
     */
    @RequiresPermissions("system:score:saveScore")
    @Log(title = "学期成绩存档", businessType = BusinessType.INSERT)
    @PostMapping("/saveScore")
    @ResponseBody
    public AjaxResult saveScore()
    {
        return toAjax(cqieScoreService.saveAllStudentScore());
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
