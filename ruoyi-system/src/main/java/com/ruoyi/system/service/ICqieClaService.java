package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CqieCla;
import com.ruoyi.system.domain.CqieClassTeacher;
import com.ruoyi.system.domain.CqieClassStudent;
import com.ruoyi.system.domain.CqieStudent;

/**
 * claService接口
 * 
 * @author sunly
 * @date 2020-09-28
 */
public interface ICqieClaService 
{
    /**
     * 查询cla
     * 
     * @param claId claID
     * @return cla
     */
    public CqieCla selectCqieClaById(Integer claId);

    /**
     * 查询cla列表
     * 
     * @param cqieCla cla
     * @return cla集合
     */
    public List<CqieCla> selectCqieClaList(CqieCla cqieCla);

    /**
     * 新增cla
     * 
     * @param cqieCla cla
     * @return 结果
     */
    public int insertCqieCla(CqieCla cqieCla);

    /**
     * 修改cla
     * 
     * @param cqieCla cla
     * @return 结果
     */
    public int updateCqieCla(CqieCla cqieCla);

    /**
     * 批量删除cla
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieClaByIds(String ids);

    /**
     * 删除cla信息
     * 
     * @param claId claID
     * @return 结果
     */
    public int deleteCqieClaById(Integer claId);

    //new code
    /**
     * 批量保存班级教师关系
     *
     * @param claId 班级ID
     * @param userIds 教师ID集合
     * @return 结果
     */
    public int insertAuthTeachers(Integer claId, String userIds);

    /**
     * 撤销班级教师关系
     *
     * @param claTeacher 班级教师关系信息
     * @return 结果
     */
    public int deleteAuthTeacher(CqieClassTeacher claTeacher);

    //李哲
    /**
     * 批量保存班级学生关系
     *
     * @param claId
     * @param stuIds
     * @return 结果
     */
    public int insertAuthStudents(Integer claId , String stuIds);

    /**
     * 撤销班级学生关系
     *
     * @param claStudent
     * @return
     */
    public int deleteAuthStudent(CqieClassStudent claStudent);

    /**
     * 根据教师id查询班级
     * 李哲
     * @param userId
     * @return
     */
    public List<CqieCla> selectCqieclabyteaId(Long userId);
}
