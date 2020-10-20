package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CqieRun;
import org.apache.ibatis.annotations.Param;

/**
 * 跑步信息Mapper接口
 *
 * @author xhd
 * @date 2020-09-28
 */
public interface CqieRunMapper
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
     * 删除跑步信息
     *
     * @param runId 跑步信息ID
     * @return 结果
     */
    public int deleteCqieRunById(Long runId);

    /**
     * 批量删除跑步信息
     *
     * @param runIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCqieRunByIds(String[] runIds);

    /**
     * xhd
     *  期末存档
     * @param runIds 需要存入的数据ID
     * @return 结果
     */
    public int saveAllByIds(String[] runIds);

    /**
     * 运动日历
     * 王康
     * @param stuNo
     * @param month
     * @return 结果
     */
    public List<String> getSportCalendar(@Param("stuNo") String stuNo, @Param("month") String month);

    /**
     * 运动记录查询
     * 王康
     * @param stuNo
     * @param date
     * @return 结果
     */
    public CqieRun getSportRecord(@Param("stuNo") String stuNo,@Param("date") String date);
}