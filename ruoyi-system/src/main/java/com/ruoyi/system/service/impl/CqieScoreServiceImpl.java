package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CqieScoreMapper;
import com.ruoyi.system.service.ICqieScoreService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学期成绩Service业务层处理
 *
 * @author xhd
 * @date 2020-10-09
 */
@Service
public class CqieScoreServiceImpl implements ICqieScoreService
{
    @Autowired
    private CqieScoreMapper cqieScoreMapper;

    /**
     * 查询学期成绩
     *
     * @param scoreId 学期成绩ID
     * @return 学期成绩
     */
    @Override
    public CqieScore selectCqieScoreById(Long scoreId)
    {
        return cqieScoreMapper.selectCqieScoreById(scoreId);
    }

    /**
     * 查询全部学期成绩列表
     *xhd
     * @param cqieScore 学期成绩
     * @return 全部学期成绩
     */
    @Override
    public List<CqieScore> selectCqieScoreListAll(CqieScore cqieScore)
    {
        return cqieScoreMapper.selectCqieScoreListAll(cqieScore);
    }

    /**
     * 查询学期成绩列表通过userId
     *xhd
     * @param cqieScore 学期成绩
     * @return 学期成绩
     */
    @Override
    public List<CqieScore> selectCqieScoreListById(CqieScore cqieScore)
    {
        return cqieScoreMapper.selectCqieScoreListById(cqieScore);
    }

    /**
     * 新增学期成绩
     *
     * @param cqieScore 学期成绩
     * @return 结果
     */
    @Override
    public int insertCqieScore(CqieScore cqieScore)
    {
        return cqieScoreMapper.insertCqieScore(cqieScore);
    }

    /**
     * 修改学期成绩
     *
     * @param cqieScore 学期成绩
     * @return 结果
     */
    @Override
    public int updateCqieScore(CqieScore cqieScore)
    {
        return cqieScoreMapper.updateCqieScore(cqieScore);
    }

    /**
     * 删除学期成绩对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCqieScoreByIds(String ids)
    {
        return cqieScoreMapper.deleteCqieScoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学期成绩信息
     *
     * @param scoreId 学期成绩ID
     * @return 结果
     */
    @Override
    public int deleteCqieScoreById(Long scoreId)
    {
        return cqieScoreMapper.deleteCqieScoreById(scoreId);
    }



    /**
     * xhd
     * 学期成绩存档
     * @return 结果
     */
    @Override
    public int saveAllStudentScore()
    {
        int rowsave=0;
        List<CqieCla> claList=cqieScoreMapper.selectAllCla();
        for(CqieCla cla:claList){
                List<CqieStudent> studentList=cqieScoreMapper.selectStudentByClaId(cla.getClaId());
           for(CqieStudent student:studentList){
               System.out.println(student.getStuId());
               CqieScore cqieScoreOne = cqieScoreMapper.selectRuninfoByStuId(student.getStuId());
               CqieSpe cqieSpeone = cqieScoreMapper.selectSpeStudentByStuId(student.getStuId());
               CqieTerm cqieTerm = cqieScoreMapper.selectLatestTerm();

                   CqieScore cqieScore = new CqieScore();

                   Long termId = (long)cqieTerm.getTermId();
                   cqieScore.setScoreTermId(termId);
                   cqieScore.setScoreStudentId(student.getStuId());
                   cqieScore.setScoreCounts(cqieScoreOne.getScoreCounts());
                   cqieScore.setScoreResult(scoreResultByCounts(cqieScoreOne.getScoreCounts()));
                   if(cqieSpeone !=null){
                       cqieScore.setScoreRemark("免跑");
                   }
                   rowsave=cqieScoreMapper.insertCqieScoreByRunInfo(cqieScore);
                  System.out.println("rowsave-----------------------------"+rowsave);
           }
        }
            return rowsave;
    }

    /**
     * xhd
     * 成绩判断
     * */
    public String scoreResultByCounts(Long count){
        if(0<=count&&count<20){
            return "不及格";
        }
        if(20<=count&&count<30){
            return "及格";
        }
        if(30<=count&&count<40){
            return "中";
        }
        if(40<=count&&count<45){
            return "良";
        }
        if(count>=45){
            return "优";
        }
        return "成绩判定无效";
    }

}
