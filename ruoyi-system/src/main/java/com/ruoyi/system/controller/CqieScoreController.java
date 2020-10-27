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
import com.ruoyi.system.domain.CqieScore;
import com.ruoyi.system.service.ICqieScoreService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

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

    @RequiresPermissions("system:score:view")
    @GetMapping()
    public String score()
    {
        return prefix + "/score";
    }

    /**
     * 查询学期成绩列表
     */
    @RequiresPermissions("system:score:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CqieScore cqieScore)
    {
        startPage();
        List<CqieScore> list = cqieScoreService.selectCqieScoreList(cqieScore);
        return getDataTable(list);
    }

    /**
     * 导出学期成绩列表
     */
    @RequiresPermissions("system:score:export")
    @Log(title = "学期成绩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CqieScore cqieScore)
    {
        List<CqieScore> list = cqieScoreService.selectCqieScoreList(cqieScore);
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


}
