package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CqieScore;
import com.ruoyi.system.domain.CqieTerm;

/**
 * 学期成绩Service接口
 *
 * @author xhd
 * @date 2020-10-09
 */
public interface ICqieScoreService
{
    /**
     * 查询学期成绩
     *
     * @param scoreId 学期成绩ID
     * @return 学期成绩
     */
    public CqieScore selectCqieScoreById(Long scoreId);

    /**
     * 查询全部学期成绩列表
     *xhd
     * @param cqieScore 学期成绩
     * @return 全部学期成绩集合
     */
    public List<CqieScore> selectCqieScoreListAll(CqieScore cqieScore);

    /**
     * 全部学期成绩列表通过userId
     *xhd
     * @param cqieScore 学期成绩
     * @return 学期成绩集合
     */
    public List<CqieScore> selectCqieScoreListById(CqieScore cqieScore);

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
     * 批量删除学期成绩
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieScoreByIds(String ids);

    /**
     * 删除学期成绩信息
     *
     * @param scoreId 学期成绩ID
     * @return 结果
     */
    public int deleteCqieScoreById(Long scoreId);




    /**
     * 学期成绩存档
     *xhd
     * @return 结果
     */
    public int saveAllStudentScore();


    /**
     * 查询学生最新学期对象
     * @return
     */
    public int selectLatestTerm();
}
