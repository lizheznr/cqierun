package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CqieAppinfoMapper;
import com.ruoyi.system.domain.CqieAppinfo;
import com.ruoyi.system.service.ICqieAppinfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * appinfoService业务层处理
 * 
 * @author sunly
 * @date 2020-09-28
 */
@Service
public class CqieAppinfoServiceImpl implements ICqieAppinfoService 
{
    @Autowired
    private CqieAppinfoMapper cqieAppinfoMapper;

    /**
     * 查询appinfo
     * 
     * @param appiId appinfoID
     * @return appinfo
     */
    @Override
    public CqieAppinfo selectCqieAppinfoById(Integer appiId)
    {
        return cqieAppinfoMapper.selectCqieAppinfoById(appiId);
    }

    /**
     * 查询appinfo列表
     * 
     * @param cqieAppinfo appinfo
     * @return appinfo
     */
    @Override
    public List<CqieAppinfo> selectCqieAppinfoList(CqieAppinfo cqieAppinfo)
    {
        return cqieAppinfoMapper.selectCqieAppinfoList(cqieAppinfo);
    }

    /**
     * 新增appinfo
     * 
     * @param cqieAppinfo appinfo
     * @return 结果
     */
    @Override
    public int insertCqieAppinfo(CqieAppinfo cqieAppinfo)
    {
        return cqieAppinfoMapper.insertCqieAppinfo(cqieAppinfo);
    }

    /**
     * 修改appinfo
     * 
     * @param cqieAppinfo appinfo
     * @return 结果
     */
    @Override
    public int updateCqieAppinfo(CqieAppinfo cqieAppinfo)
    {
        return cqieAppinfoMapper.updateCqieAppinfo(cqieAppinfo);
    }

    /**
     * 删除appinfo对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCqieAppinfoByIds(String ids)
    {
        return cqieAppinfoMapper.deleteCqieAppinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除appinfo信息
     * 
     * @param appiId appinfoID
     * @return 结果
     */
    @Override
    public int deleteCqieAppinfoById(Integer appiId)
    {
        return cqieAppinfoMapper.deleteCqieAppinfoById(appiId);
    }

    //sunly
    /**
     * 查询最新发布的appinfo
     *
     * @return appinfo
     */
    @Override
    public CqieAppinfo selectCqieAppinfoLatest()
    {
        return cqieAppinfoMapper.selectCqieAppinfoLatest();
    }
}
