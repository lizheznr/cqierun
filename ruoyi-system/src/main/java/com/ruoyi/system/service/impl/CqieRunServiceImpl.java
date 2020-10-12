package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CqieRunMapper;
import com.ruoyi.system.domain.CqieRun;
import com.ruoyi.system.service.ICqieRunService;
import com.ruoyi.common.core.text.Convert;

/**
 * 跑步信息Service业务层处理
 *
 * @author xhd
 * @date 2020-09-28
 */
@Service
public class CqieRunServiceImpl implements ICqieRunService
{
    @Autowired
    private CqieRunMapper cqieRunMapper;

    /**
     * 查询跑步信息
     *
     * @param runId 跑步信息ID
     * @return 跑步信息
     */
    @Override
    public CqieRun selectCqieRunById(Long runId)
    {
        return cqieRunMapper.selectCqieRunById(runId);
    }

    /**
     * 查询跑步信息列表
     *
     * @param cqieRun 跑步信息
     * @return 跑步信息
     */
    @Override
    public List<CqieRun> selectCqieRunList(CqieRun cqieRun)
    {
        return cqieRunMapper.selectCqieRunList(cqieRun);
    }

    /**
     * 新增跑步信息
     *
     * @param cqieRun 跑步信息
     * @return 结果
     */
    @Override
    public int insertCqieRun(CqieRun cqieRun)
    {
        return cqieRunMapper.insertCqieRun(cqieRun);
    }

    /**
     * 修改跑步信息
     *
     * @param cqieRun 跑步信息
     * @return 结果
     */
    @Override
    public int updateCqieRun(CqieRun cqieRun)
    {
        return cqieRunMapper.updateCqieRun(cqieRun);
    }

    /**
     * 删除跑步信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCqieRunByIds(String ids)
    {
        return cqieRunMapper.deleteCqieRunByIds(Convert.toStrArray(ids));
    }

    /**
     * xhd
     *  期末存档
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int saveAllByIds(String ids)
    {
        return cqieRunMapper.saveAllByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除跑步信息信息
     *
     * @param runId 跑步信息ID
     * @return 结果
     */
    @Override
    public int deleteCqieRunById(Long runId)
    {
        return cqieRunMapper.deleteCqieRunById(runId);
    }

}