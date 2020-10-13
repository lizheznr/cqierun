package com.ruoyi.system.domain;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息对象 cqie_student
 * 
 * @author 李哲
 * @date 2020-09-29
 */
public class CqieStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long stuId;

    /** 学号 */
    @Excel(name = "学号")
    private String stuNo;

    /**
     * 盐加密
     */
    private String stuSalt;
    /**
     * 班级ID
     */
    private Integer claId;

    /** 登录密码 */
    private String stuPassword;

    /** 姓名 */
    @Excel(name = "姓名")
    private String stuName;

    /** 性别 */
    @Excel(name = "性别")
    private String stuSex;

    /** 生日 */
    private Date stuBirthday;

    /** Email */
    private String stuEmail;

    /** 手机号 */
    @Excel(name = "手机号")
    private String stuMobile;

    /** QQ号 */
    private String stuQq;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date stuAddtime;

    /** 备注 */
    @Excel(name = "备注")
    private String stuRemark;

    /** 学生照片 */
    private String stuImg;

    private List<CqieCla> clas;

    public String getStuImg() {
        return stuImg;
    }

    public void setStuImg(String stuImg) {
        this.stuImg = stuImg;
    }

    public String getStuSalt() {
        return stuSalt;
    }

    public void setStuSalt(String stuSalt) {
        this.stuSalt = stuSalt;
    }

    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId() 
    {
        return stuId;
    }
    public void setStuNo(String stuNo) 
    {
        this.stuNo = stuNo;
    }

    public String getStuNo() 
    {
        return stuNo;
    }
    public void setStuPassword(String stuPassword) 
    {
        this.stuPassword = stuPassword;
    }

    public String getStuPassword() 
    {
        return stuPassword;
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
    public void setStuBirthday(Date stuBirthday) 
    {
        this.stuBirthday = stuBirthday;
    }

    public Date getStuBirthday() 
    {
        return stuBirthday;
    }
    public void setStuEmail(String stuEmail) 
    {
        this.stuEmail = stuEmail;
    }

    public String getStuEmail() 
    {
        return stuEmail;
    }
    public void setStuMobile(String stuMobile) 
    {
        this.stuMobile = stuMobile;
    }

    public String getStuMobile() 
    {
        return stuMobile;
    }
    public void setStuQq(String stuQq) 
    {
        this.stuQq = stuQq;
    }

    public String getStuQq() 
    {
        return stuQq;
    }
    public void setStuAddtime(Date stuAddtime) 
    {
        this.stuAddtime = stuAddtime;
    }

    public Date getStuAddtime() 
    {
        return stuAddtime;
    }
    public void setStuRemark(String stuRemark) 
    {
        this.stuRemark = stuRemark;
    }

    public String getStuRemark() 
    {
        return stuRemark;
    }

    public Integer getClaId() {
        return claId;
    }

    public void setClaId(Integer claId) {
        this.claId = claId;
    }

    public List<CqieCla> getClas() {
        return clas;
    }

    public void setClas(List<CqieCla> clas) {
        this.clas = clas;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuId", getStuId())
            .append("stuNo", getStuNo())
            .append("claId",getClaId())
            .append("stuPassword", getStuPassword())
            .append("stuSalt",getStuSalt())
            .append("stuName", getStuName())
            .append("stuSex", getStuSex())
            .append("stuBirthday", getStuBirthday())
            .append("stuEmail", getStuEmail())
            .append("stuMobile", getStuMobile())
            .append("stuQq", getStuQq())
            .append("stuAddtime", getStuAddtime())
            .append("stuRemark", getStuRemark())
            .append("stuImg", getStuImg())
            .append("clas", getClas())
            .toString();
    }
}
