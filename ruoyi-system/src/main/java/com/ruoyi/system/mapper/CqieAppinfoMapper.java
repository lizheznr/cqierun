package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CqieAppinfo;

/**
 * appinfoMapper接口
 * 
 * @author sunly
 * @date 2020-09-28
 */
public interface CqieAppinfoMapper 
{
    /**
     * 查询appinfo
     * 
     * @param appiId appinfoID
     * @return appinfo
     */
    public CqieAppinfo selectCqieAppinfoById(Integer appiId);

    /**
     * 查询appinfo列表
     * 
     * @param cqieAppinfo appinfo
     * @return appinfo集合
     */
    public List<CqieAppinfo> selectCqieAppinfoList(CqieAppinfo cqieAppinfo);

    /**
     * 新增appinfo
     * 
     * @param cqieAppinfo appinfo
     * @return 结果
     */
    public int insertCqieAppinfo(CqieAppinfo cqieAppinfo);

    /**
     * 修改appinfo
     * 
     * @param cqieAppinfo appinfo
     * @return 结果
     */
    public int updateCqieAppinfo(CqieAppinfo cqieAppinfo);

    /**
     * 删除appinfo
     * 
     * @param appiId appinfoID
     * @return 结果
     */
    public int deleteCqieAppinfoById(Integer appiId);

    /**
     * 批量删除appinfo
     * 
     * @param appiIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieAppinfoByIds(String[] appiIds);
}
