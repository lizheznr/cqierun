package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CqieTerm;

/**
 * 学期Service接口
 * 
 * @author sunly
 * @date 2020-09-29
 */
public interface ICqieTermService 
{
    /**
     * 查询学期
     * 
     * @param termId 学期ID
     * @return 学期
     */
    public CqieTerm selectCqieTermById(Integer termId);

    /**
     * 查询学期列表
     * 
     * @param cqieTerm 学期
     * @return 学期集合
     */
    public List<CqieTerm> selectCqieTermList(CqieTerm cqieTerm);

    /**
     * 新增学期
     * 
     * @param cqieTerm 学期
     * @return 结果
     */
    public int insertCqieTerm(CqieTerm cqieTerm);

    /**
     * 修改学期
     * 
     * @param cqieTerm 学期
     * @return 结果
     */
    public int updateCqieTerm(CqieTerm cqieTerm);

    /**
     * 批量删除学期
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieTermByIds(String ids);

    /**
     * 删除学期信息
     * 
     * @param termId 学期ID
     * @return 结果
     */
    public int deleteCqieTermById(Integer termId);
}
