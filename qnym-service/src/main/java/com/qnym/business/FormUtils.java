package com.qnym.business;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormUtils {

    public static final List<NameValuePair> ParseFormForMap(Map<String, String> paramsMap) {

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        paramsMap.forEach((k, v) -> {
            nvps.add(new BasicNameValuePair(k, v));

        });
        return nvps;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","legn");
        map.put("2","jack");
        ParseFormForMap(map);
    }
}
