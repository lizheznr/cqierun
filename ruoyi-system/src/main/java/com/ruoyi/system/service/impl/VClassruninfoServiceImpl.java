package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VClassruninfoMapper;
import com.ruoyi.system.domain.VClassruninfo;
import com.ruoyi.system.service.IVClassruninfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 班级成绩Service业务层处理
 * 
 * @author xhd
 * @date 2020-10-09
 */
@Service
public class VClassruninfoServiceImpl implements IVClassruninfoService 
{
    @Autowired
    private VClassruninfoMapper vClassruninfoMapper;

    /**
     * 查询班级成绩
     * 
     * @param stuNo 班级成绩ID
     * @return 班级成绩
     */
    @Override
    public VClassruninfo selectVClassruninfoById(String stuNo)
    {
        return vClassruninfoMapper.selectVClassruninfoById(stuNo);
    }

    /**
     * 查询班级成绩列表
     * 
     * @param vClassruninfo 班级成绩
     * @return 班级成绩
     */
    @Override
    public List<VClassruninfo> selectVClassruninfoList(VClassruninfo vClassruninfo)
    {
        return vClassruninfoMapper.selectVClassruninfoList(vClassruninfo);
    }

    /**
     * 新增班级成绩
     * 
     * @param vClassruninfo 班级成绩
     * @return 结果
     */
    @Override
    public int insertVClassruninfo(VClassruninfo vClassruninfo)
    {
        return vClassruninfoMapper.insertVClassruninfo(vClassruninfo);
    }

    /**
     * 修改班级成绩
     * 
     * @param vClassruninfo 班级成绩
     * @return 结果
     */
    @Override
    public int updateVClassruninfo(VClassruninfo vClassruninfo)
    {
        return vClassruninfoMapper.updateVClassruninfo(vClassruninfo);
    }

    /**
     * 删除班级成绩对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVClassruninfoByIds(String ids)
    {
        return vClassruninfoMapper.deleteVClassruninfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除班级成绩信息
     * 
     * @param stuNo 班级成绩ID
     * @return 结果
     */
    @Override
    public int deleteVClassruninfoById(String stuNo)
    {
        return vClassruninfoMapper.deleteVClassruninfoById(stuNo);
    }
}
