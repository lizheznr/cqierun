package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.CqieStudent;
import com.ruoyi.system.domain.SysUser;

/**
 * 学生信息Service接口
 *
 * @author 李哲
 * @date 2020-09-29
 */
public interface ICqieStudentService {
    /**
     * 查询学生信息
     *
     * @param stuId 学生信息ID
     * @return 学生信息
     */
    public CqieStudent selectCqieStudentById(Long stuId);

    /**
     * 查询学生信息列表
     *
     * @param cqieStudent 学生信息
     * @return 学生信息集合
     */
    public List<CqieStudent> selectCqieStudentList(CqieStudent cqieStudent);

    /**
     * 新增学生信息
     *
     * @param cqieStudent 学生信息
     * @return 结果
     */
    public int insertCqieStudent(CqieStudent cqieStudent);

    /**
     * 修改学生信息
     *
     * @param cqieStudent 学生信息
     * @return 结果
     */
    public int updateCqieStudent(CqieStudent cqieStudent);

    /**
     * 批量删除学生信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieStudentByIds(String ids);

    /**
     * 删除学生信息信息
     *
     * @param stuId 学生信息ID
     * @return 结果
     */
    public int deleteCqieStudentById(Long stuId);

    /**
     * 导入用户数据
     *
     * @param studentList     用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    public String importStudent(List<CqieStudent> studentList, Boolean isUpdateSupport, String operName);

    //new code

    /**
     * 根据条件分页查询已配班级的学生列表
     * 李哲
     *
     * @param student 学生信息
     * @return 教师信息集合信息
     */
    public List<CqieStudent> selectClassAllocatedList1(CqieStudent student);

    /**
     * 重置学生密码
     * 李哲
     *
     * @param student
     * @return
     */
    public int rePassword(CqieStudent student);

    /**
     * app登录
     * 王康
     *
     * @param stuNo
     * @param stuPassword
     * @return data
     */
    public CqieStudent login(String stuNo, String stuPassword);

    /**
     * 查询学生信息
     * 王康
     *
     * @param stuNo 学生信息ID
     * @return 学生信息
     */
    public CqieStudent selectCqieStudentByNo(String stuNo);

    /**
     * 修改学生密码
     * 王康
     *
     * @param stuNo   学号（账号）
     * @param oldPass 旧密码
     * @param newPass 新密码
     * @return 结果
     */
    public int updateCqieStudentPass(String stuNo, String oldPass, String newPass);

    /**
     * 修改头像
     * 王康
     *
     * @param stuNo   学号（账号）
     * @param headImg 头像地址
     * @return 结果
     */
    public int updateHeadImg(String stuNo, String headImg);

    /**
     * 获得班级名称
     * 王康
     *
     * @param stuNo 学号（账号）
     * @return 结果
     */
    public List<String> getClaName(String stuNo);

    /**
     * 根据教师ID查询所属学生
     * 李哲
     * @param userId
     * @return
     */
    public List<CqieStudent> selectCqiestudentbyteaId(Long userId);
}

