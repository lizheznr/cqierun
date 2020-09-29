package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * appinfo对象 cqie_appinfo
 * 
 * @author sunly
 * @date 2020-09-28
 */
public class CqieAppinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer appiId;

    /** 版本号 */
    @Excel(name = "版本号")
    private Double appiVersion;

    /** 地址 */
    @Excel(name = "地址")
    private String appiAddress;

    /** 是否发布 */
    @Excel(name = "是否发布")
    private Integer appiIspublish;

    /** 上传时间 */
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date appiAddtime;

    /** 备注 */
    @Excel(name = "备注")
    private String appiRemark;

    public void setAppiId(Integer appiId) 
    {
        this.appiId = appiId;
    }

    public Integer getAppiId() 
    {
        return appiId;
    }
    public void setAppiVersion(Double appiVersion) 
    {
        this.appiVersion = appiVersion;
    }

    public Double getAppiVersion() 
    {
        return appiVersion;
    }
    public void setAppiAddress(String appiAddress) 
    {
        this.appiAddress = appiAddress;
    }

    public String getAppiAddress() 
    {
        return appiAddress;
    }
    public void setAppiIspublish(Integer appiIspublish) 
    {
        this.appiIspublish = appiIspublish;
    }

    public Integer getAppiIspublish() 
    {
        return appiIspublish;
    }
    public void setAppiAddtime(Date appiAddtime) 
    {
        this.appiAddtime = appiAddtime;
    }

    public Date getAppiAddtime() 
    {
        return appiAddtime;
    }
    public void setAppiRemark(String appiRemark) 
    {
        this.appiRemark = appiRemark;
    }

    public String getAppiRemark() 
    {
        return appiRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("appiId", getAppiId())
            .append("appiVersion", getAppiVersion())
            .append("appiAddress", getAppiAddress())
            .append("appiIspublish", getAppiIspublish())
            .append("appiAddtime", getAppiAddtime())
            .append("appiRemark", getAppiRemark())
            .toString();
    }
}
