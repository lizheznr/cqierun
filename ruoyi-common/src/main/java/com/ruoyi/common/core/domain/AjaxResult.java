package com.ruoyi.common.core.domain;

import java.util.HashMap;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * 操作消息提醒
 * 
 * @author ruoyi
 */
@ApiModel(value = "返回说明")
public class AjaxResult extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 状态码2 */
    @ApiModelProperty(value = "成功标识；1：成功；0:失败")
    public static final String CODE_TAG2 = "status";

    /** 返回内容2 */
    @ApiModelProperty(value = "描述信息")
    public static final String MSG_TAG2 = "message";

    /** 数据对象 */
    @ApiModelProperty(value = "返回数据")
    public static final String DATA_TAG = "data";

    /**
     * 状态类型
     */
    public enum Type
    {
        /** 成功 */
        SUCCESS(0),
        /** 成功2 */
        SUCCESS2(1),
        /** 失败 */
        FAIL(0),
        /** 警告 */
        WARN(301),
        /** 错误 */
        ERROR(500);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult()
    {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     * 
     * @param type 状态类型
     * @param msg 返回内容
     */
    public AjaxResult(Type type, String msg)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     * 
     * @param type 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public AjaxResult(Type type, String msg, Object data)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data))
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 初始化一个新创建的符合陈永政版本的 AjaxResult 对象
     *
     * @param type 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public AjaxResult(Type type, String msg, Object data, int flag)
    {
        super.put(CODE_TAG2, type.value);
        super.put(MSG_TAG2, msg);
        if (StringUtils.isNotNull(data))
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 初始化一个新创建的符合陈永政版本的 AjaxResult 对象
     *
     * @param type 状态类型
     * @param msg 返回内容
     * @param flag 标识
     */
    public AjaxResult(Type type, String msg, int flag)
    {
        super.put(CODE_TAG2, type.value);
        super.put(MSG_TAG2, msg);
    }

    /**
     * 返回成功消息
     * 
     * @return 成功消息
     */
    public static AjaxResult success()
    {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功数据
     * 
     * @return 成功消息
     */
    public static AjaxResult success(Object data)
    {
        return AjaxResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     * 
     * @param msg 返回内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg)
    {
        return AjaxResult.success(msg, null);
    }

    /**
     * 返回成功消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static AjaxResult success(String msg, Object data)
    {
        return new AjaxResult(Type.SUCCESS, msg, data);
    }

    /**
     * 返回警告消息
     * 
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult warn(String msg)
    {
        return AjaxResult.warn(msg, null);
    }

    /**
     * 返回警告消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static AjaxResult warn(String msg, Object data)
    {
        return new AjaxResult(Type.WARN, msg, data);
    }

    /**
     * 返回错误消息
     * 
     * @return
     */
    public static AjaxResult error()
    {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     * 
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(String msg)
    {
        return AjaxResult.error(msg, null);
    }

    /**
     * 返回错误消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static AjaxResult error(String msg, Object data)
    {
        return new AjaxResult(Type.ERROR, msg, data);
    }

    //sunly 2020-10-10
    /**
     * 返回消息
     *
     * @param type 类型，成功为1SUCCESS，失败为0FAIL
     * @param msg 返回内容
     * @param data 数据对象
     * @return 消息
     */
    public static AjaxResult  returnJSON(Type type, String msg, Object data)
    {
        return new AjaxResult(type, msg, data,1);
    }

    //sunly 2020-10-27
    /**
     * 返回消息2
     *
     * @param type 类型，成功为1SUCCESS，失败为0FAIL
     * @param msg 返回内容
     * @return 消息
     */
    public static AjaxResult  returnJSON(Type type, String msg)
    {
        return new AjaxResult(type, msg,1);
    }
}
