package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.VClassruninfo;

/**
 * 班级成绩Service接口
 * 
 * @author xhd
 * @date 2020-10-09
 */
public interface IVClassruninfoService 
{
    /**
     * 查询班级成绩
     * 
     * @param stuNo 班级成绩ID
     * @return 班级成绩
     */
    public VClassruninfo selectVClassruninfoById(String stuNo);

    /**
     * 查询班级成绩列表
     * 
     * @param vClassruninfo 班级成绩
     * @return 班级成绩集合
     */
    public List<VClassruninfo> selectVClassruninfoList(VClassruninfo vClassruninfo);

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
     * 批量删除班级成绩
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVClassruninfoByIds(String ids);

    /**
     * 删除班级成绩信息
     * 
     * @param stuNo 班级成绩ID
     * @return 结果
     */
    public int deleteVClassruninfoById(String stuNo);
}
