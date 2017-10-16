package com.qnym.common.domain;

/**
 * Created by liuhaikuo on 2017/10/14.
 * @author liuhaikuo
 */
public class LoginStatus {
    public final static HttpStatusNode SUCCESS = new HttpStatusNode(200, "ok");
    public final static HttpStatusNode ACCOUNT_EMPTY = new HttpStatusNode(40401, "account empty.");
    public final static HttpStatusNode ACCOUNT_NOT_EXIST = new HttpStatusNode(40402, "pwd empty.");
    public final static HttpStatusNode PWD_EMPTY = new HttpStatusNode(40403, "pwd empty.");
    public final static HttpStatusNode ACCOUNT_PWD_NOT_MATCH = new HttpStatusNode(40404, "account pwd not match.");
    public final static HttpStatusNode LOGIN_FAILD = new HttpStatusNode(40499, "account pwd not match.");
}
