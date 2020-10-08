package com.ruoyi.system.domain;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.annotation.Excels;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * cla对象 cqie_cla
 *
 * @author sunly
 * @date 2020-09-28
 */
public class CqieCla extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 班级ID
     */
    private Integer claId;

    /**
     * 院系编号
     */
    @Excel(name = "院系编号")
    private Integer claDeptId;

    /**
     * 班级名称
     */
    @Excel(name = "班级名称")
    private String claName;

    /**
     * 添加时间
     */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date claAddtime;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String claRemark;

    /**
     * 部门对象
     */
    @Excels({
            @Excel(name = "部门名称", targetAttr = "deptName", type = Excel.Type.EXPORT),
            @Excel(name = "部门负责人", targetAttr = "leader", type = Excel.Type.EXPORT)
    })

    private SysDept dept;

    public void setClaId(Integer claId) {
        this.claId = claId;
    }

    public Integer getClaId() {
        return claId;
    }

    public void setClaDeptId(Integer claDeptId) {
        this.claDeptId = claDeptId;
    }

    public Integer getClaDeptId() {
        return claDeptId;
    }

    public void setClaName(String claName) {
        this.claName = claName;
    }

    public String getClaName() {
        return claName;
    }

    public void setClaAddtime(Date claAddtime) {
        this.claAddtime = claAddtime;
    }

    public Date getClaAddtime() {
        return claAddtime;
    }

    public void setClaRemark(String claRemark) {
        this.claRemark = claRemark;
    }

    public String getClaRemark() {
        return claRemark;
    }

    public SysDept getDept() {
        if (dept == null) {
            dept = new SysDept();
        }
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("claId", getClaId())
                .append("claDeptId", getClaDeptId())
                .append("claName", getClaName())
                .append("claAddtime", getClaAddtime())
                .append("claRemark", getClaRemark())
                .append("dept", getDept())
                .toString();
    }
}
