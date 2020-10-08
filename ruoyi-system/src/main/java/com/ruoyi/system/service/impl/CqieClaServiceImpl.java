package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.system.domain.CqieClassTeacher;
import com.ruoyi.system.mapper.CqieClassTeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CqieClaMapper;
import com.ruoyi.system.domain.CqieCla;
import com.ruoyi.system.service.ICqieClaService;
import com.ruoyi.common.core.text.Convert;

/**
 * claService业务层处理
 * 
 * @author sunly
 * @date 2020-09-28
 */
@Service
public class CqieClaServiceImpl implements ICqieClaService 
{
    @Autowired
    private CqieClaMapper cqieClaMapper;

    @Autowired
    private CqieClassTeacherMapper classTeacherMapper;

    /**
     * 查询cla
     * 
     * @param claId claID
     * @return cla
     */
    @Override
    public CqieCla selectCqieClaById(Integer claId)
    {
        return cqieClaMapper.selectCqieClaById(claId);
    }

    /**
     * 查询cla列表
     * 
     * @param cqieCla cla
     * @return cla
     */
    @Override
    public List<CqieCla> selectCqieClaList(CqieCla cqieCla)
    {
        return cqieClaMapper.selectCqieClaList(cqieCla);
    }

    /**
     * 新增cla
     * 
     * @param cqieCla cla
     * @return 结果
     */
    @Override
    public int insertCqieCla(CqieCla cqieCla)
    {
        return cqieClaMapper.insertCqieCla(cqieCla);
    }

    /**
     * 修改cla
     * 
     * @param cqieCla cla
     * @return 结果
     */
    @Override
    public int updateCqieCla(CqieCla cqieCla)
    {
        return cqieClaMapper.updateCqieCla(cqieCla);
    }

    /**
     * 删除cla对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCqieClaByIds(String ids)
    {
        return cqieClaMapper.deleteCqieClaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除cla信息
     * 
     * @param claId claID
     * @return 结果
     */
    @Override
    public int deleteCqieClaById(Integer claId)
    {
        return cqieClaMapper.deleteCqieClaById(claId);
    }

    //new code
    /**
     * 批量保存班级教师关系
     *
     * @param claId 班级ID
     * @param userIds 教师ID集合
     * @return 结果
     */
    @Override
    public int insertAuthTeachers(Integer claId, String userIds)
    {
        Long[] users = Convert.toLongArray(userIds);
        // 新增用户与角色管理
        List<CqieClassTeacher> list = new ArrayList<CqieClassTeacher>();
        for (Long userId : users)
        {
            CqieClassTeacher ct = new CqieClassTeacher();
            ct.setTeacherId(userId);
            ct.setClaId(claId);
            list.add(ct);
        }
        return classTeacherMapper.batchClassTeacher(list);
    }

    /**
     * 撤销班级教师关系
     *
     * @param claTeacher 班级教师关系信息
     * @return 结果
     */
    @Override
    public int deleteAuthTeacher(CqieClassTeacher claTeacher)
    {
        return classTeacherMapper.deleteClassTeacherInfo(claTeacher);
    }
}
