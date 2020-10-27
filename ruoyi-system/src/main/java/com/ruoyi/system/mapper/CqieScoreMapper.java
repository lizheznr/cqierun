package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.*;

/**
 * 学期成绩Mapper接口
 * 
 * @author xhd
 * @date 2020-10-09
 */
public interface CqieScoreMapper 
{
    /**
     * 查询学期成绩
     * 
     * @param scoreId 学期成绩ID
     * @return 学期成绩
     */
    public CqieScore selectCqieScoreById(Long scoreId);

    /**
     * 查询学期成绩列表
     * 
     * @param cqieScore 学期成绩
     * @return 学期成绩集合
     */
    public List<CqieScore> selectCqieScoreList(CqieScore cqieScore);

    /**
     * 新增学期成绩
     * 
     * @param cqieScore 学期成绩
     * @return 结果
     */
    public int insertCqieScore(CqieScore cqieScore);

    /**
     * 修改学期成绩
     * 
     * @param cqieScore 学期成绩
     * @return 结果
     */
    public int updateCqieScore(CqieScore cqieScore);

    /**
     * 删除学期成绩
     * 
     * @param scoreId 学期成绩ID
     * @return 结果
     */
    public int deleteCqieScoreById(Long scoreId);

    /**
     * 批量删除学期成绩
     * 
     * @param scoreIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieScoreByIds(String[] scoreIds);

    /**
     * xhd
     * 查询所有班级
     * @return 结果
     */
    public List<CqieCla> selectAllCla();

    /**
     * xhd
     * 通过claId查询该班所有学生
     * @return 结果
     */
    public List<CqieStudent> selectStudentByClaId(int claId);

    /**
     * xhd
     * 通过stuId查询该学生所有的跑步信息
     * @return 结果
     */
    public CqieScore  selectRuninfoByStuId(Long stuId);

    /**
     * xhd
     * 插入所有学生所有的跑步信息
     * @return 结果
     */
    public int insertCqieScoreByRunInfo(CqieScore cqieScore);


    /**
     * xhd
     * 查询所有免跑学生信息
     * @return 结果
     */
    public CqieSpe selectSpeStudentByStuId(Long stuId);


    /**
     * xhd
     * 查询最新的学期
     * */
    public CqieTerm selectLatestTerm();





}
