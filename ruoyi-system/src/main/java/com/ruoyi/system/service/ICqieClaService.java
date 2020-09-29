package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CqieCla;

/**
 * claService接口
 * 
 * @author sunly
 * @date 2020-09-28
 */
public interface ICqieClaService 
{
    /**
     * 查询cla
     * 
     * @param claId claID
     * @return cla
     */
    public CqieCla selectCqieClaById(Integer claId);

    /**
     * 查询cla列表
     * 
     * @param cqieCla cla
     * @return cla集合
     */
    public List<CqieCla> selectCqieClaList(CqieCla cqieCla);

    /**
     * 新增cla
     * 
     * @param cqieCla cla
     * @return 结果
     */
    public int insertCqieCla(CqieCla cqieCla);

    /**
     * 修改cla
     * 
     * @param cqieCla cla
     * @return 结果
     */
    public int updateCqieCla(CqieCla cqieCla);

    /**
     * 批量删除cla
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieClaByIds(String ids);

    /**
     * 删除cla信息
     * 
     * @param claId claID
     * @return 结果
     */
    public int deleteCqieClaById(Integer claId);
}
