package com.zsj.vo;

import lombok.Data;

/**
 * @author zsj
 * @date 2019.9.30
 */
@Data
public class ResultVo<T> {

    /**
     * 结果
     */
    private boolean success;

    /**
     * 错误码
     */
    private Integer errorCode;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T body;
}
