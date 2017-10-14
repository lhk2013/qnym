package com.qnym.common.domain;

import java.io.Serializable;

/**
 * @author liuhaikuo
 * 2017年10月14日 11:13:37
 */
public final class HttpStatusNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1794895351808269370L;

	/**
	 * 错误码
	 */
	private int code;

	/**
	 * 错误说明
	 */
	private String msg;

	/**
	 * @param code
	 * @param msg
	 */
	public HttpStatusNode(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	/**
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

}
