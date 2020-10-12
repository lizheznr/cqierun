package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CqieSpe;
import com.ruoyi.system.domain.SysUser;

/**
 * 免跑申请Mapper接口
 *
 * @author xhd
 * @date 2020-09-29
 */
public interface CqieSpeMapper
{
    /**
     * 查询免跑申请
     *
     * @param speId 免跑申请ID
     * @return 免跑申请
     */
    public CqieSpe selectCqieSpeById(Long speId);

    /**
     * 查询免跑申请列表
     *
     * @param cqieSpe 免跑申请
     * @return 免跑申请集合
     */
    public List<CqieSpe> selectCqieSpeList(CqieSpe cqieSpe);

    /**
     * 新增免跑申请
     *
     * @param cqieSpe 免跑申请
     * @return 结果
     */
    public int insertCqieSpe(CqieSpe cqieSpe);

    /**
     * 修改免跑申请
     *
     * @param cqieSpe 免跑申请
     * @return 结果
     */
    public int updateCqieSpe(CqieSpe cqieSpe);

    /**
     * 删除免跑申请
     *
     * @param speId 免跑申请ID
     * @return 结果
     */
    public int deleteCqieSpeById(Long speId);

    /**
     * 批量删除免跑申请
     *
     * @param speIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieSpeByIds(String[] speIds);

    /**
     *批准状态修改
     *xhd
     * @param cqieSpe 用户信息
     * @return 结果
     */
    public int updateSpeIsAgree(CqieSpe cqieSpe);

}