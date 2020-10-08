package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 班级教师关系对象 cqie_class_teacher
 * 
 * @author sunly
 * @date 2020-10-08
 */
public class CqieClassTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long clateaId;

    /** 班级ID */
    @Excel(name = "班级ID")
    private Integer claId;

    /** 教师ID */
    @Excel(name = "教师ID")
    private Long teacherId;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date clateaAddtime;

    /** 备注 */
    @Excel(name = "备注")
    private String clateaRemark;

    public void setClateaId(Long clateaId) 
    {
        this.clateaId = clateaId;
    }

    public Long getClateaId() 
    {
        return clateaId;
    }
    public void setClaId(Integer claId) 
    {
        this.claId = claId;
    }

    public Integer getClaId() 
    {
        return claId;
    }
    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
    }
    public void setClateaAddtime(Date clateaAddtime) 
    {
        this.clateaAddtime = clateaAddtime;
    }

    public Date getClateaAddtime() 
    {
        return clateaAddtime;
    }
    public void setClateaRemark(String clateaRemark) 
    {
        this.clateaRemark = clateaRemark;
    }

    public String getClateaRemark() 
    {
        return clateaRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clateaId", getClateaId())
            .append("claId", getClaId())
            .append("teacherId", getTeacherId())
            .append("clateaAddtime", getClateaAddtime())
            .append("clateaRemark", getClateaRemark())
            .toString();
    }
}
