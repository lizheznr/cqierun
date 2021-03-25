package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CqieStudentMapper;
import com.ruoyi.system.domain.CqieStudent;
import com.ruoyi.system.service.ICqieStudentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生信息Service业务层处理
 * 
 * @author 李哲
 * @date 2020-09-29
 */
@Service
public class CqieStudentServiceImpl implements ICqieStudentService {
    @Autowired
    private CqieStudentMapper cqieStudentMapper;

    /**
     * 查询学生信息
     *
     * @param stuId 学生信息ID
     * @return 学生信息
     */
    @Override
    public CqieStudent selectCqieStudentById(Long stuId) {
        return cqieStudentMapper.selectCqieStudentById(stuId);
    }

    /**
     * 查询学生信息列表
     *
     * @param cqieStudent 学生信息
     * @return 学生信息
     */
    @Override
    public List<CqieStudent> selectCqieStudentList(CqieStudent cqieStudent) {
        return cqieStudentMapper.selectCqieStudentList(cqieStudent);
    }

    /**
     * 新增学生信息
     *
     * @param cqieStudent 学生信息
     * @return 结果
     */
    @Override
    public int insertCqieStudent(CqieStudent cqieStudent) {

        return cqieStudentMapper.insertCqieStudent(cqieStudent);
    }

    /**
     * 修改学生信息
     *
     * @param cqieStudent 学生信息
     * @return 结果
     */
    @Override
    public int updateCqieStudent(CqieStudent cqieStudent) {
        return cqieStudentMapper.updateCqieStudent(cqieStudent);
    }

    /**
     * 删除学生信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCqieStudentByIds(String ids) {
        return cqieStudentMapper.deleteCqieStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生信息信息
     *
     * @param stuId 学生信息ID
     * @return 结果
     */
    @Override
    public int deleteCqieStudentById(Long stuId) {
        return cqieStudentMapper.deleteCqieStudentById(stuId);
    }

    @Override
    public String importStudent(List<CqieStudent> studentList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(studentList) || studentList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CqieStudent student : studentList) {
            try {
                //验证是否存在该学生
                CqieStudent cqieStudent = cqieStudentMapper.selectCqieStudentByNo(student.getStuNo());
                System.out.println(cqieStudent);
                if (StringUtils.isNull(cqieStudent)){
                    this.insertCqieStudent(student);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、学生 " + student.getStuName() + " 导入成功");
                }
                else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、学号 " + student.getStuNo() + " 已存在");
                }
            }
            catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、学号 " + student.getStuNo() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        System.out.println("撒大大"+failureNum);
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确");
            return failureMsg.toString();
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
            return successMsg.toString();
        }

    }

    /**
     * 根据条件分页查询已配班级的学生列表
     * @param student 学生信息
     * @return 结果
     */
    @Override
    public List<CqieStudent> selectClassAllocatedList1(CqieStudent student)
    {
        return cqieStudentMapper.selectClassAllocatedList1(student);
    }

    /**
     * 重置密码
     * @param student 学生信息对象
     * @return 结果
     */
    @Override
    public int rePassword(CqieStudent student)
    {
        return cqieStudentMapper.rePassword(student);
    }

    /**
     * app登录
     * 王康
     * @param stuNo  学号
     * @param stuPassword  密码
     * @return data
     */
    @Override
    public CqieStudent login(String stuNo, String stuPassword) {
        return cqieStudentMapper.selectCqieStudentByNameAndPass(stuNo, stuPassword);
    }

    /**
     * 查询学生信息
     *  王康
     * @param stuNo 学生信息ID
     * @return 学生信息
     */
    @Override
    public CqieStudent selectCqieStudentByNo(String stuNo) {
        return cqieStudentMapper.selectCqieStudentByNo(stuNo);
    }

    /**
     * 修改学生密码
     * 王康
     * @param stuNo     学号（账号）
     * @param oldPass   旧密码
     * @param newPass   新密码
     * @return 结果
     */
    @Override
    public int updateCqieStudentPass(String stuNo, String oldPass, String newPass) {
        return cqieStudentMapper.updateCqieStudentPass(stuNo, oldPass, newPass);
    }

    /**
     * 修改头像
     * 王康
     * @param stuNo     学号（账号）
     * @param headImg   头像地址
     * @return 结果
     */
    @Override
    public int updateHeadImg(String stuNo, String headImg) {
        return cqieStudentMapper.updateHeadImg(stuNo,headImg);
    }

    /**
     * 获得班级名称
     * 王康
     * @param stuNo     学号（账号）
     * @return 结果
     */
    @Override
    public List<String> getClaName(String stuNo) {
        return cqieStudentMapper.selectClassName(stuNo);
    }

    @Override
    public List<CqieStudent> selectCqiestudentbyteaId(Long userId) {
        return cqieStudentMapper.selectCqiestudentbyteaId(userId);
    }

}