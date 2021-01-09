package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.CqieStudent;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ICqieStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 学生信息Controller
 * 
 * @author 李哲
 * @date 2020-09-29
 */
@Controller
@RequestMapping("/system/student")
public class CqieStudentController extends BaseController {
    private String prefix = "system/student";

    @Autowired
    private SysPasswordService passwordService;
    @Autowired
    private ICqieStudentService cqieStudentService;

    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student() {
        return prefix + "/student";
    }

    /**
     * 查询学生信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CqieStudent cqieStudent) {
        Long userId = ShiroUtils.getUserId();
        SysUser user = ShiroUtils.getSysUser();
        List<SysRole> roles = user.getRoles();
        String rolekey = null;
        List<CqieStudent> list = null;
        for (SysRole role : roles) {
            rolekey = role.getRoleKey();
        }
        if (rolekey.equals("common")){
            startPage();
            list = cqieStudentService.selectCqiestudentbyteaId(userId);
        }else{
            startPage();
            list = cqieStudentService.selectCqieStudentList(cqieStudent);
        }
        return getDataTable(list);
    }

    @RequiresPermissions("system:student:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<CqieStudent> util = new ExcelUtil<CqieStudent>(CqieStudent.class);
        return util.importTemplateExcel("学生数据");
    }


    /**
     * 导出学生信息列表
     */
    @RequiresPermissions("system:student:export")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CqieStudent cqieStudent) {
        List<CqieStudent> list = cqieStudentService.selectCqieStudentList(cqieStudent);
        ExcelUtil<CqieStudent> util = new ExcelUtil<CqieStudent>(CqieStudent.class);
        return util.exportExcel(list, "student");
    }

    /**
     * 导入
     *
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @PostMapping("/import")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<CqieStudent> util = new ExcelUtil<CqieStudent>(CqieStudent.class);
        List<CqieStudent> userList = util.importExcel(file.getInputStream());

        System.out.println(userList);
        List<CqieStudent> collect = userList.stream()
                .filter(u -> u.getStuName() != "" && u.getStuNo() != "")
                .peek(u -> {
                            u.setStuImg("http://sunly98.gitee.io/cqierun_img/default_face.png");
                            u.setStuSalt(ShiroUtils.randomSalt());
                            u.setStuPassword(passwordService.encryptPassword(
                                    u.getStuName(),
                                    "123456",
                                    u.getStuSalt()));
                        }
                ).collect(Collectors.toList());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = cqieStudentService.importStudent(collect, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 新增学生信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存学生信息
     */
    @RequiresPermissions("system:student:add")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CqieStudent cqieStudent) {
        cqieStudent.setStuSalt(ShiroUtils.randomSalt());
        cqieStudent.setStuPassword("123456");
        cqieStudent.setStuPassword(passwordService.encryptPassword(cqieStudent.getStuName(), cqieStudent.getStuPassword(), cqieStudent.getStuSalt()));
        return toAjax(cqieStudentService.insertCqieStudent(cqieStudent));
    }

    /**
     * 修改学生信息
     */
    @GetMapping("/edit/{stuId}")
    public String edit(@PathVariable("stuId") Long stuId, ModelMap mmap) {
        CqieStudent cqieStudent = cqieStudentService.selectCqieStudentById(stuId);
        mmap.put("cqieStudent", cqieStudent);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生信息
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CqieStudent cqieStudent) {
        cqieStudent.setStuSalt(ShiroUtils.randomSalt());
        cqieStudent.setStuPassword(passwordService.encryptPassword(cqieStudent.getStuName(), cqieStudent.getStuPassword(), cqieStudent.getStuSalt()));
        return toAjax(cqieStudentService.updateCqieStudent(cqieStudent));
    }


    @RequiresPermissions("system:student:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.GRANT)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwdSave(CqieStudent cqieStudent){
        cqieStudent.setStuSalt(ShiroUtils.randomSalt());
        cqieStudent.setStuPassword("123456");
        cqieStudent.setStuPassword(passwordService.encryptPassword(cqieStudent.getStuName(), cqieStudent.getStuPassword(), cqieStudent.getStuSalt()));
        return toAjax(cqieStudentService.rePassword(cqieStudent));
    }

    /**
     * 删除学生信息
     */
    @RequiresPermissions("system:student:remove")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cqieStudentService.deleteCqieStudentByIds(ids));
    }
}
