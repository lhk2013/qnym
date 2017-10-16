package com.qnym.common.domain;

import lombok.Data;

/**
 * Created by liuhaikuo on 2017/10/13.
 * @author liuhaikuo
 */
@Data
public class CommonResponse {
    /**
     * 返回码
     */
    private int rpco;

    /**
     * 错误信息
     */
    private String msg;

    private String data;

    public CommonResponse() {
    }
    /**
     * @param rpco
     * @param msg
     */
    public CommonResponse(int rpco, String msg) {
        super();
        this.rpco = rpco;
        this.msg = msg;
    }
}
