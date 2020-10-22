package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CqieSpe;
import com.ruoyi.system.domain.SysUser;

/**
 * 免跑申请Service接口
 *
 * @author xhd
 * @date 2020-09-29
 */
public interface ICqieSpeService
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
     * 批量删除免跑申请
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieSpeByIds(String ids);

    /**
     * 删除免跑申请信息
     *
     * @param speId 免跑申请ID
     * @return 结果
     */
    public int deleteCqieSpeById(Long speId);

    /**
     * xhd
     * 修改spe用户批准状态
     * @param cqieSpe 用户信息
     * */
    public int changeStatus(CqieSpe cqieSpe);



}