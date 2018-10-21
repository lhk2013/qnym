package com.qnym.business;

import lombok.Data;

@Data
public class SignInfo {

    private String actionUrl;

    private String apiKey;//api_key
    private String apiSecret;//api_secret
    private String returnUrl;//return_url
    private String documentNo;//document_no
    private String picture;
    private String sealStrategyId;//seal_strategy_id
    private String pdf;
    private String pdfFile;
    private String guid;
    private String position;
    private String time;
    private String apiSign;//api_sign
}
