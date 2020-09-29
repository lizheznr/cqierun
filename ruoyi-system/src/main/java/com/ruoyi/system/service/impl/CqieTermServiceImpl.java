package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CqieTermMapper;
import com.ruoyi.system.domain.CqieTerm;
import com.ruoyi.system.service.ICqieTermService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学期Service业务层处理
 * 
 * @author sunly
 * @date 2020-09-29
 */
@Service
public class CqieTermServiceImpl implements ICqieTermService 
{
    @Autowired
    private CqieTermMapper cqieTermMapper;

    /**
     * 查询学期
     * 
     * @param termId 学期ID
     * @return 学期
     */
    @Override
    public CqieTerm selectCqieTermById(Integer termId)
    {
        return cqieTermMapper.selectCqieTermById(termId);
    }

    /**
     * 查询学期列表
     * 
     * @param cqieTerm 学期
     * @return 学期
     */
    @Override
    public List<CqieTerm> selectCqieTermList(CqieTerm cqieTerm)
    {
        return cqieTermMapper.selectCqieTermList(cqieTerm);
    }

    /**
     * 新增学期
     * 
     * @param cqieTerm 学期
     * @return 结果
     */
    @Override
    public int insertCqieTerm(CqieTerm cqieTerm)
    {
        return cqieTermMapper.insertCqieTerm(cqieTerm);
    }

    /**
     * 修改学期
     * 
     * @param cqieTerm 学期
     * @return 结果
     */
    @Override
    public int updateCqieTerm(CqieTerm cqieTerm)
    {
        return cqieTermMapper.updateCqieTerm(cqieTerm);
    }

    /**
     * 删除学期对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCqieTermByIds(String ids)
    {
        return cqieTermMapper.deleteCqieTermByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学期信息
     * 
     * @param termId 学期ID
     * @return 结果
     */
    @Override
    public int deleteCqieTermById(Integer termId)
    {
        return cqieTermMapper.deleteCqieTermById(termId);
    }
}
