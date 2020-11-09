package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CqieCla;
import com.ruoyi.system.domain.CqieStudent;

/**
 * claMapper接口
 * 
 * @author sunly
 * @date 2020-09-28
 */
public interface CqieClaMapper 
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
     * 删除cla
     * 
     * @param claId claID
     * @return 结果
     */
    public int deleteCqieClaById(Integer claId);

    /**
     * 批量删除cla
     * 
     * @param claIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieClaByIds(String[] claIds);

    /**
     * 根据教师ID查询班级
     * 李哲
     * @param userId
     * @return
     */
    public List<CqieCla> selectCqieclabyteaId(Long userId);
}
