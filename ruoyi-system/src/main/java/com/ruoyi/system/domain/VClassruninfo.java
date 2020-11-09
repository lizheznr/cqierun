package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 班级成绩对象 v_classruninfo
 * 
 * @author xhd
 * @date 2020-10-09
 */
public class VClassruninfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学期 */
    @Excel(name = "学期")
    private String termName;

    /** 班级名称 */
    @Excel(name = "班级")
    private String claName;

    /** 学号 */
    @Excel(name = "学号")
    private String stuNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String stuName;

    /** 性别 */
    @Excel(name = "性别")
    private String stuSex;

    /**跑步次数 */
    @Excel(name = "跑步次数")
    private Long runcount;

    /**备注*/
    @Excel(name = "备注")
    private String remark;

    private SysUser sysUser;


    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setStuNo(String stuNo)
    {
        this.stuNo = stuNo;
    }

    public String getStuNo() 
    {
        return stuNo;
    }
    public void setStuName(String stuName) 
    {
        this.stuName = stuName;
    }

    public String getStuName() 
    {
        return stuName;
    }
    public void setStuSex(String stuSex) 
    {
        this.stuSex = stuSex;
    }

    public String getStuSex() 
    {
        return stuSex;
    }
    public void setClaName(String claName) 
    {
        this.claName = claName;
    }

    public String getClaName() 
    {
        return claName;
    }
    public void setTermName(String termName) 
    {
        this.termName = termName;
    }

    public String getTermName() 
    {
        return termName;
    }
    public void setRuncount(Long runcount) 
    {
        this.runcount = runcount;
    }

    public Long getRuncount() 
    {
        return runcount;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuNo", getStuNo())
            .append("stuName", getStuName())
            .append("stuSex", getStuSex())
            .append("claName", getClaName())
            .append("termName", getTermName())
            .append("runcount", getRuncount())
            .append("remark",getRemark())
            .append("sysUser",getSysUser())
            .toString();
    }
}
