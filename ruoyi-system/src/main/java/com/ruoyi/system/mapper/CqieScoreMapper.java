package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CqieScore;

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
}
