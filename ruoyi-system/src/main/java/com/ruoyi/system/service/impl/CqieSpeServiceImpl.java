package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CqieSpeMapper;
import com.ruoyi.system.domain.CqieSpe;
import com.ruoyi.system.service.ICqieSpeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 免跑申请Service业务层处理
 *
 * @author xhd
 * @date 2020-09-28
 */
@Service
public class CqieSpeServiceImpl implements ICqieSpeService
{
    @Autowired
    private CqieSpeMapper cqieSpeMapper;

    /**
     * 查询免跑申请
     *
     * @param speId 免跑申请ID
     * @return 免跑申请
     */
    @Override
    public CqieSpe selectCqieSpeById(Long speId)
    {
        return cqieSpeMapper.selectCqieSpeById(speId);
    }

    /**
     * 查询免跑申请列表
     *
     * @param cqieSpe 免跑申请
     * @return 免跑申请
     */
    @Override
    public List<CqieSpe> selectCqieSpeList(CqieSpe cqieSpe)
    {
        return cqieSpeMapper.selectCqieSpeList(cqieSpe);
    }

    /**
     * 新增免跑申请
     *
     * @param cqieSpe 免跑申请
     * @return 结果
     */
    @Override
    public int insertCqieSpe(CqieSpe cqieSpe)
    {
        return cqieSpeMapper.insertCqieSpe(cqieSpe);
    }

    /**
     * 修改免跑申请
     *
     * @param cqieSpe 免跑申请
     * @return 结果
     */
    @Override
    public int updateCqieSpe(CqieSpe cqieSpe)
    {
        return cqieSpeMapper.updateCqieSpe(cqieSpe);
    }

    /**
     * 删除免跑申请对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCqieSpeByIds(String ids)
    {
        return cqieSpeMapper.deleteCqieSpeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除免跑申请信息
     *
     * @param speId 免跑申请ID
     * @return 结果
     */
    @Override
    public int deleteCqieSpeById(Long speId)
    {
        return cqieSpeMapper.deleteCqieSpeById(speId);
    }



    /**
     * 批准状态修改
     *xhd
     * @param cqieSpe 用户信息
     * @return 结果
     */
    @Override
    public int changeStatus(CqieSpe cqieSpe)
    {
        return cqieSpeMapper.updateSpeIsAgree(cqieSpe);
    }
}