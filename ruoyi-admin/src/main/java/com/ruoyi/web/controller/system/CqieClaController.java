package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.ICqieClaService;
import com.ruoyi.system.service.ICqieStudentService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.framework.shiro.service.SysPasswordService;

import java.util.List;
import java.util.stream.Collectors;

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
    private SysPasswordService passwordService;

    @Autowired
    private ICqieClaService cqieClaService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ICqieStudentService cqieStudentService;

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
          Long userId = ShiroUtils.getUserId();
        SysUser user = ShiroUtils.getSysUser();
        List<SysRole> roles = user.getRoles();
        String rolekey = null;
        List<CqieCla> list = null;
        for (SysRole role : roles) {
            rolekey = role.getRoleKey();
        }
        if (rolekey.equals("common")){
            startPage();
            list = cqieClaService.selectCqieclabyteaId(userId);
        }else{
            startPage();
            list = cqieClaService.selectCqieClaList(cqieCla);
        }
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

    //new code
    /**
     * 查询已分配班级的教师列表
     */
    @RequiresPermissions("system:cla:list")
    @PostMapping("/authTeacher/classallocatedList")
    @ResponseBody
    public TableDataInfo classallocatedList(SysUser user)
    {
        startPage();
        List<SysUser> list = userService.selectClassAllocatedList(user);
        return getDataTable(list);
    }

    /**
     * 分配教师
     */
    @RequiresPermissions("system:cla:edit")
    @GetMapping("/authTeacher/{claId}")
    public String authTeacher(@PathVariable("claId") Integer claId, ModelMap mmap)
    {
        mmap.put("cqieCla", cqieClaService.selectCqieClaById(claId));
        return prefix + "/authTeacher";
    }

    /**
     * 选择教师
     */
    @GetMapping("/authTeacher/selectTeacher/{claId}")
    public String selectTeacher(@PathVariable("claId") Integer claId, ModelMap mmap)
    {
        mmap.put("cqieCla", cqieClaService.selectCqieClaById(claId));
        return prefix + "/selectTeacher";
    }

    /**
     * 查询所有教师列表
     */
    @RequiresPermissions("system:cla:list")
    @PostMapping("/authTeacher/teacherList")
    @ResponseBody
    public TableDataInfo teacherList(SysUser user)
    {

        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 保存班级教师关系
     */
    @Log(title = "为班级分配教师", businessType = BusinessType.GRANT)
    @PostMapping("/authTeacher/selectAll")
    @ResponseBody
    public AjaxResult selectAuthTeacherAll(Integer claId, String userIds)
    {
        return toAjax(cqieClaService.insertAuthTeachers(claId, userIds));

    }

    /**
     * 撤销班级教师关系
     */
    @Log(title = "从班级撤销教师", businessType = BusinessType.GRANT)
    @PostMapping("/authTeacher/cancel")
    @ResponseBody
    public AjaxResult cancelAuthTeacher(CqieClassTeacher claTeacher)
    {
        return toAjax(cqieClaService.deleteAuthTeacher(claTeacher));
    }

    //new code
    /**
     * 李哲
     * 查询已分配班级的学生列表
     */
    @RequiresPermissions("system:cla:list")
    @PostMapping("/authStudent/classallocatedList1")
    @ResponseBody
    public TableDataInfo classallocatedList1(CqieStudent student)
    {
        startPage();
        List<CqieStudent> list = cqieStudentService.selectClassAllocatedList1(student);
        return getDataTable(list);
    }
    /**
     * 李哲
     * 分配学生
     */
    @RequiresPermissions("system:cla:edit")
    @GetMapping("/authStudent/{claId}")
    public String authStudent(@PathVariable("claId") Integer claId, ModelMap mmap)
    {
        mmap.put("cqieCla", cqieClaService.selectCqieClaById(claId));
        return prefix + "/authStudent";
    }
    /**
     * 李哲
     * 选择分配学生
     */
    @RequiresPermissions("system:cla:edit")
    @GetMapping("/authStudent/selectStudent/{claId}")
    public String selectStudent(@PathVariable("claId") Integer claId, ModelMap mmap)
    {
        mmap.put("cqieCla", cqieClaService.selectCqieClaById(claId));
        return prefix + "/selectStudent";
    }
    /**
     * 李哲
     * 查询所有学生列表
     */
    @RequiresPermissions("system:cla:list")
    @PostMapping("/authStudent/studentList")
    @ResponseBody
    public TableDataInfo studentList(CqieStudent student)
    {
        startPage();
        List<CqieStudent> list = cqieStudentService.selectCqieStudentList(student);
        return getDataTable(list);
    }

    /**
     * 李哲
     * 保存班级学生关系
     */
    @Log(title = "为班级分配学生", businessType = BusinessType.GRANT)
    @PostMapping("/authStudent/selectAll")
    @ResponseBody
    public AjaxResult selectAuthStudentAll(Integer claId, String stuIds)
    {
        return toAjax(cqieClaService.insertAuthStudents(claId,stuIds));
    }

    /**
     * 李哲
     * 撤销班级学生关系
     */
    @Log(title = "从班级撤销学生", businessType = BusinessType.GRANT)
    @PostMapping("/authStudent/cancel")
    @ResponseBody
    public AjaxResult cancelAuthStudent(CqieClassStudent classStudent)
    {
        return toAjax(cqieClaService.deleteAuthStudent(classStudent));
    }

    /**
     * 导入
     * 李哲
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "导入学生的同时绑定班级关系", businessType = BusinessType.GRANT)
    @PostMapping("/authStudent/import")
    @ResponseBody
    @CrossOrigin
    public AjaxResult importData(MultipartFile file,boolean updateSupport,String claId) throws Exception {
        ExcelUtil<CqieStudent> util = new ExcelUtil<CqieStudent>(CqieStudent.class);
        List<CqieStudent> userList = util.importExcel(file.getInputStream());
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
        collect.stream().forEach(student->{
            //处理逻辑，打印出所有学生的姓名
            String no = student.getStuNo();
            CqieStudent cqieStudent = cqieStudentService.selectCqieStudentByNo(no);
            String stuIds = String.valueOf(cqieStudent.getStuId());
            cqieClaService.insertAuthStudents(Integer.valueOf(claId),stuIds);
        });
        return AjaxResult.success(message,claId);

    }
}