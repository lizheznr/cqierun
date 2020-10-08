package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CqieClassTeacher;
import com.ruoyi.system.domain.SysUserRole;

/**
 * 班级教师关系Mapper接口
 * 
 * @author sunly
 * @date 2020-10-08
 */
public interface CqieClassTeacherMapper 
{
    /**
     * 查询班级教师关系
     * 
     * @param clateaId 班级教师关系ID
     * @return 班级教师关系
     */
    public CqieClassTeacher selectCqieClassTeacherById(Long clateaId);

    /**
     * 查询班级教师关系列表
     * 
     * @param cqieClassTeacher 班级教师关系
     * @return 班级教师关系集合
     */
    public List<CqieClassTeacher> selectCqieClassTeacherList(CqieClassTeacher cqieClassTeacher);

    /**
     * 新增班级教师关系
     * 
     * @param cqieClassTeacher 班级教师关系
     * @return 结果
     */
    public int insertCqieClassTeacher(CqieClassTeacher cqieClassTeacher);

    /**
     * 修改班级教师关系
     * 
     * @param cqieClassTeacher 班级教师关系
     * @return 结果
     */
    public int updateCqieClassTeacher(CqieClassTeacher cqieClassTeacher);

    /**
     * 删除班级教师关系
     * 
     * @param clateaId 班级教师关系ID
     * @return 结果
     */
    public int deleteCqieClassTeacherById(Long clateaId);

    /**
     * 批量删除班级教师关系
     * 
     * @param clateaIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieClassTeacherByIds(String[] clateaIds);

    //new code
    /**
     * 批量新增班级教师关系
     *
     * @param claTeacherList 班级教师关系列表
     * @return 结果
     */
    public int batchClassTeacher(List<CqieClassTeacher> claTeacherList);

    /**
     * 删除班级教师关联信息
     *
     * @param claTeacher 用户和角色关联信息
     * @return 结果
     */
    public int deleteClassTeacherInfo(CqieClassTeacher claTeacher);
}
