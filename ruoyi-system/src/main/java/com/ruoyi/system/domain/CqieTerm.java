package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学期对象 cqie_term
 * 
 * @author sunly
 * @date 2020-09-29
 */
public class CqieTerm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Integer termId;

    /** 学期 */
    @Excel(name = "学期")
    private String termName;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date termAddtime;

    /** 备注 */
    @Excel(name = "备注")
    private String termRemark;

    public void setTermId(Integer termId) 
    {
        this.termId = termId;
    }

    public Integer getTermId() 
    {
        return termId;
    }
    public void setTermName(String termName) 
    {
        this.termName = termName;
    }

    public String getTermName() 
    {
        return termName;
    }
    public void setTermAddtime(Date termAddtime) 
    {
        this.termAddtime = termAddtime;
    }

    public Date getTermAddtime() 
    {
        return termAddtime;
    }
    public void setTermRemark(String termRemark) 
    {
        this.termRemark = termRemark;
    }

    public String getTermRemark() 
    {
        return termRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("termId", getTermId())
            .append("termName", getTermName())
            .append("termAddtime", getTermAddtime())
            .append("termRemark", getTermRemark())
            .toString();
    }
}
