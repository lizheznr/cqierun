package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CqieStudent;
import com.ruoyi.system.domain.SysUser;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 查询学生信息
     * 王康
     * @param stuNo 学生信息ID
     * @return 学生信息
     */
    public CqieStudent selectCqieStudentByNo(@Param("stuNo") String stuNo);

    /**
     * login
     * 王康
     * @param stuNo
     * @param stuPass
     * @return 结果
     */
    public CqieStudent selectCqieStudentByNameAndPass(@Param("stuNo") String stuNo, @Param("stuPass") String stuPass);

    /**
     * 修改学生密码
     * 王康
     * @param stuNo     学号（账号）
     * @param oldPass   旧密码
     * @param newPass   新密码
     * @return 结果
     */
    public int updateCqieStudentPass(@Param("stuNo") String stuNo,@Param("oldPass") String oldPass,@Param("newPass") String newPass);

    /**
     * 修改头像
     * 王康
     * @param stuNo     学号（账号）
     * @param headImg   头像地址
     * @return 结果
     */
    public int updateHeadImg(@Param("stuNo") String stuNo,@Param("stuImg") String headImg);

    /**
     * 获得班级名称
     * 王康
     * @param stuNo     学号（账号）
     * @return 结果
     */
    public List<String> selectClassName(@Param("stuNo") String stuNo);

    /**
     * 根据教师ID查询学生
     * 李哲
     * @param userId
     * @return
     */
    public List<CqieStudent> selectCqiestudentbyteaId(Long userId);

    /**
     * 根据教师ID查询所属学生再查找指定条件学生
     * 李哲
     * @param userId
     * @param stuName
     * @param stuNo
     * @param stuSex
     * @return
     */
    public List<CqieStudent> selectCqiestudentbyteaId1(@Param("userId") Long userId,@Param("stuName")String stuName,@Param("stuNo")String stuNo,@Param("stuSex")String stuSex);
}
