package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CqieRunMapper;
import com.ruoyi.system.service.ICqieRunService;
import com.ruoyi.common.core.text.Convert;


/**
 * 跑步信息Service业务层处理
 *
 * @author xhd
 * @date 2020-09-28
 */
@Service
public class CqieRunServiceImpl implements ICqieRunService
{
    @Autowired
    private CqieRunMapper cqieRunMapper;

    /**
     * 查询跑步信息
     *
     * @param runId 跑步信息ID
     * @return 跑步信息
     */
    @Override
    public CqieRun selectCqieRunById(Long runId)
    {
        return cqieRunMapper.selectCqieRunById(runId);
    }

    /**
     * 查询跑步信息列表通过userId
     *xhd
     * @param cqieRun 跑步信息
     * @return 跑步信息
     */
    @Override
    public List<CqieRun> selectCqieRunListById(CqieRun cqieRun)
    {
        return cqieRunMapper.selectCqieRunListById(cqieRun);
    }


    /**
     * 查询全部跑步信息列表
     *xhd
     * @param cqieRun 跑步信息
     * @return 跑步信息
     */
    @Override
    public List<CqieRun> selectCqieRunListAll(CqieRun cqieRun)
    {
        return cqieRunMapper.selectCqieRunListAll(cqieRun);
    }


    /**
     * 新增跑步信息
     *
     * @param cqieRun 跑步信息
     * @return 结果
     */
    @Override
    public int insertCqieRun(CqieRun cqieRun)
    {
        return cqieRunMapper.insertCqieRun(cqieRun);
    }

    /**
     * 修改跑步信息
     *
     * @param cqieRun 跑步信息
     * @return 结果
     */
    @Override
    public int updateCqieRun(CqieRun cqieRun)
    {
        return cqieRunMapper.updateCqieRun(cqieRun);
    }

    /**
     * 删除跑步信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCqieRunByIds(String ids)
    {
        return cqieRunMapper.deleteCqieRunByIds(Convert.toStrArray(ids));
    }



    /**
     * 删除跑步信息信息
     *
     * @param runId 跑步信息ID
     * @return 结果
     */
    @Override
    public int deleteCqieRunById(Long runId)
    {
        return cqieRunMapper.deleteCqieRunById(runId);
    }

    /**
     * 运动开始
     * 王康
     * @param cqieRun 运动信息对象
     * @return 结果
     */
    @Override
    public int startSport(CqieRun cqieRun) {
        return cqieRunMapper.insertCqieRun(cqieRun);
    }

    /**
     * 运动结束
     * 王康
     * @param cqieRun 运动信息对象
     * @return 结果
     */
    @Override
    public int endSport(CqieRun cqieRun) {
        return cqieRunMapper.updateCqieRun(cqieRun);
    }

    /**
     * 运动日历
     * 王康
     * @param stuNo 学号
     * @param month 月份
     * @return 结果
     */
    @Override
    public List<String> getSportCalendar(String stuNo, String month) {
        return cqieRunMapper.getSportCalendar(stuNo, month);
    }

    /**
     * 运动记录查询
     * 王康
     *
     * @param stuNo  账号
     * @param startdate 开始日期
     * @param enddate   结束日期
     * @return 结果
     */
    @Override
    public List<CqieSportCalendar> getSportRecord(String stuNo, String startdate, String enddate) {
        List<CqieSportCalendar> list = null;
        try {
            list = cqieRunMapper.getSportRecord(stuNo, startdate, enddate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 运动信息统计
     * @param stuId  学生信息ID
     * @return  结果
     */
    @Override
    public CqieTotalRunInfo getTotalRunInfo(Long stuId) {
        return cqieRunMapper.getTotalRunInfo(stuId);
    }


    /**
     * 通过userId查询出老师所有的班级
     * xhd
     * */
    @Override
    public List<CqieCla> selectAllClassByUserId(Long userId){
        return cqieRunMapper.selectAllClassByUserId(userId);
    }


}