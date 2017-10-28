package com.qnym.common.domain;

import lombok.Data;

/**
 * Created by liuhaikuo on 2017/10/28.
 */
@Data
public class WebResponse<T> extends CommonResponse{

    private long tsrp;

    private T body;

    public WebResponse() {
    }

    public WebResponse(T body) {
        super(200, (String)null);
        this.tsrp = System.currentTimeMillis();
        this.body = body;
    }

}
