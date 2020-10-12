package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CqieScoreMapper;
import com.ruoyi.system.domain.CqieScore;
import com.ruoyi.system.service.ICqieScoreService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学期成绩Service业务层处理
 * 
 * @author xhd
 * @date 2020-10-09
 */
@Service
public class CqieScoreServiceImpl implements ICqieScoreService 
{
    @Autowired
    private CqieScoreMapper cqieScoreMapper;

    /**
     * 查询学期成绩
     * 
     * @param scoreId 学期成绩ID
     * @return 学期成绩
     */
    @Override
    public CqieScore selectCqieScoreById(Long scoreId)
    {
        return cqieScoreMapper.selectCqieScoreById(scoreId);
    }

    /**
     * 查询学期成绩列表
     * 
     * @param cqieScore 学期成绩
     * @return 学期成绩
     */
    @Override
    public List<CqieScore> selectCqieScoreList(CqieScore cqieScore)
    {
        return cqieScoreMapper.selectCqieScoreList(cqieScore);
    }

    /**
     * 新增学期成绩
     * 
     * @param cqieScore 学期成绩
     * @return 结果
     */
    @Override
    public int insertCqieScore(CqieScore cqieScore)
    {
        return cqieScoreMapper.insertCqieScore(cqieScore);
    }

    /**
     * 修改学期成绩
     * 
     * @param cqieScore 学期成绩
     * @return 结果
     */
    @Override
    public int updateCqieScore(CqieScore cqieScore)
    {
        return cqieScoreMapper.updateCqieScore(cqieScore);
    }

    /**
     * 删除学期成绩对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCqieScoreByIds(String ids)
    {
        return cqieScoreMapper.deleteCqieScoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学期成绩信息
     * 
     * @param scoreId 学期成绩ID
     * @return 结果
     */
    @Override
    public int deleteCqieScoreById(Long scoreId)
    {
        return cqieScoreMapper.deleteCqieScoreById(scoreId);
    }
}
