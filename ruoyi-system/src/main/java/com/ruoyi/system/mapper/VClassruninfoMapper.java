package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.VClassruninfo;

/**
 * 班级成绩Mapper接口
 * 
 * @author xhd
 * @date 2020-10-09
 */
public interface VClassruninfoMapper 
{
    /**
     * 查询班级成绩
     * 
     * @param stuNo 班级成绩ID
     * @return 班级成绩
     */
    public VClassruninfo selectVClassruninfoById(String stuNo);

    /**
     * 查询全部班级成绩列表
     * xhd
     * @param vClassruninfo 班级成绩
     * @return 全部班级成绩集合
     */
    public List<VClassruninfo> selectVClassruninfoListAll(VClassruninfo vClassruninfo);

    /**
     * 全部班级成绩列表
     *xhd
     * @param vClassruninfo 班级成绩
     * @return 班级成绩集合
     */
    public List<VClassruninfo> selectVClassruninfoListById(VClassruninfo vClassruninfo);

    /**
     * 新增班级成绩
     * 
     * @param vClassruninfo 班级成绩
     * @return 结果
     */
    public int insertVClassruninfo(VClassruninfo vClassruninfo);

    /**
     * 修改班级成绩
     * 
     * @param vClassruninfo 班级成绩
     * @return 结果
     */
    public int updateVClassruninfo(VClassruninfo vClassruninfo);

    /**
     * 删除班级成绩
     * 
     * @param stuNo 班级成绩ID
     * @return 结果
     */
    public int deleteVClassruninfoById(String stuNo);

    /**
     * 批量删除班级成绩
     * 
     * @param stuNos 需要删除的数据ID
     * @return 结果
     */
    public int deleteVClassruninfoByIds(String[] stuNos);
}
