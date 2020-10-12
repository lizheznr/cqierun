package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CqieStudent;
import com.ruoyi.system.domain.SysUser;

/**
 * 学生信息Mapper接口
 * 
 * @author 李哲
 * @date 2020-09-29
 */
public interface CqieStudentMapper 
{
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
     * 删除学生信息
     * 
     * @param stuId 学生信息ID
     * @return 结果
     */
    public int deleteCqieStudentById(Long stuId);

    /**
     * 批量删除学生信息
     * 
     * @param stuIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieStudentByIds(String[] stuIds);


    //新增加代码
    /**
     * 根据条件分页查询已配班级的学生列表
     * 李哲
     * @param student 学生信息
     * @return 学生信息集合信息
     */
    public List<CqieStudent> selectClassAllocatedList1(CqieStudent student);

    /**
     * 重置密码
     * @param student
     * @return
     */
    public int rePassword(CqieStudent student);
}
