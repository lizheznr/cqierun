package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CqieRun;
import com.ruoyi.system.domain.CqieTotalRunInfo;

/**
 * 跑步信息Service接口
 *
 * @author xhd
 * @date 2020-09-28
 */
public interface ICqieRunService
{
    /**
     * 查询跑步信息
     *
     * @param runId 跑步信息ID
     * @return 跑步信息
     */
    public CqieRun selectCqieRunById(Long runId);

    /**
     * 查询跑步信息列表
     *
     * @param cqieRun 跑步信息
     * @return 跑步信息集合
     */
    public List<CqieRun> selectCqieRunList(CqieRun cqieRun);

    /**
     * 新增跑步信息
     *
     * @param cqieRun 跑步信息
     * @return 结果
     */
    public int insertCqieRun(CqieRun cqieRun);

    /**
     * 修改跑步信息
     *
     * @param cqieRun 跑步信息
     * @return 结果
     */
    public int updateCqieRun(CqieRun cqieRun);

    /**
     * 批量删除跑步信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieRunByIds(String ids);

    /**
     * xhd
     *  期末存档
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int saveAllByIds(String ids);


    /**
     * 删除跑步信息信息
     *
     * @param runId 跑步信息ID
     * @return 结果
     */
    public int deleteCqieRunById(Long runId);

    /**
     * 运动开始
     * 王康
     * @param cqieRun
     * @return 结果
     */
    public int startSport(CqieRun cqieRun);

    /**
     * 运动结束
     * 王康
     * @param cqieRun
     * @return 结果
     */
    public int endSport(CqieRun cqieRun);

    /**
     * 运动日历
     * 王康
     * @param stuNo
     * @param month
     * @return 结果
     */
    public List<String> getSportCalendar(String stuNo, String month);

    /**
     * 运动记录查询
     * 王康
     * @param stuNo
     * @param date
     * @return 结果
     */
    public CqieRun getSportRecord(String stuNo,String date);

    /**
     * 运动信息统计
     * @param stuId  学生信息ID
     * @return  结果
     */
    public CqieTotalRunInfo getTotalRunInfo(Long stuId);
}