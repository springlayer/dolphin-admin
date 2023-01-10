package com.orange.mo.common.api;

import java.io.Serializable;

/**
 * 业务代码接口
 *
 * @Author houzhi@zkzx.com
 * @Date 2022/3/14 15:08
 * @description 业务代码接口
 **/
public interface IResultCode extends Serializable {

	/**
	 * 消息
	 *
	 * @return String
	 */
	String getMessage();

	/**
	 * 状态码
	 *
	 * @return int
	 */
	int getCode();

}
