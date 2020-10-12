package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 为班级选择学生对象 cqie_class_student
 * 
 * @author 李哲
 * @date 2020-10-09
 */
public class CqieClassStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long clastuId;

    /** 班级ID */
    @Excel(name = "班级ID")
    private Integer claId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long clastuStuId;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date clastuAddtime;

    /** 备注 */
    @Excel(name = "备注")
    private String clastuRemark;

    public Long getClastuId() {
        return clastuId;
    }

    public void setClastuId(Long clastuId) {
        this.clastuId = clastuId;
    }

    public Integer getClaId() {
        return claId;
    }

    public void setClaId(Integer claId) {
        this.claId = claId;
    }

    public Long getClastuStuId() {
        return clastuStuId;
    }

    public void setClastuStuId(Long clastuStuId) {
        this.clastuStuId = clastuStuId;
    }

    public Date getClastuAddtime() {
        return clastuAddtime;
    }

    public void setClastuAddtime(Date clastuAddtime) {
        this.clastuAddtime = clastuAddtime;
    }

    public String getClastuRemark() {
        return clastuRemark;
    }

    public void setClastuRemark(String clastuRemark) {
        this.clastuRemark = clastuRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clastuId", getClastuId())
            .append("claId", getClaId())
            .append("clastuStuId", getClastuStuId())
            .append("clastuAddtime", getClastuAddtime())
            .append("clastuRemark", getClastuRemark())
            .toString();
    }
}
