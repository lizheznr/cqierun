package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CqieClassStudent;
import com.ruoyi.system.domain.CqieClassTeacher;

/**
 * 为班级选择学生Mapper接口
 * 
 * @author 李哲
 * @date 2020-10-09
 */
public interface CqieClassStudentMapper 
{
    /**
     * 查询为班级选择学生
     * 
     * @param clastuId 为班级选择学生ID
     * @return 为班级选择学生
     */
    public CqieClassStudent selectCqieClassStudentById(Long clastuId);

    /**
     * 查询为班级选择学生列表
     * 
     * @param cqieClassStudent 为班级选择学生
     * @return 为班级选择学生集合
     */
    public List<CqieClassStudent> selectCqieClassStudentList(CqieClassStudent cqieClassStudent);

    /**
     * 新增为班级选择学生
     * 
     * @param cqieClassStudent 为班级选择学生
     * @return 结果
     */
    public int insertCqieClassStudent(CqieClassStudent cqieClassStudent);

    /**
     * 修改为班级选择学生
     * 
     * @param cqieClassStudent 为班级选择学生
     * @return 结果
     */
    public int updateCqieClassStudent(CqieClassStudent cqieClassStudent);

    /**
     * 删除为班级选择学生
     * 
     * @param clastuId 为班级选择学生ID
     * @return 结果
     */
    public int deleteCqieClassStudentById(Long clastuId);

    /**
     * 批量删除为班级选择学生
     * 
     * @param clastuIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieClassStudentByIds(String[] clastuIds);

    //new code
    /**
     * 批量新增班级学生关系
     *
     * @param claStudentListList 班级教师关系列表
     * @return 结果
     */
    public int batchClassStudent(List<CqieClassStudent> claStudentListList);

    /**
     * 删除班级教师关联信息
     *
     * @param claStudent 用户和角色关联信息
     * @return 结果
     */
    public int deleteClassStudentInfo(CqieClassStudent claStudent);
}

