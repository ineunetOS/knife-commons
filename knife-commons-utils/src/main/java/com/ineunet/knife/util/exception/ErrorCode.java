/*
 * Copyright 2013-2016 iNeunet OpenSource and the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ineunet.knife.util.exception;

/**
 * 异常编码及提示常量类，用在一些标准化程度较高的场所，异常代码返回至客户端，如需扩展可继承。<br>
 * 暂不支持国际化。如需国际化，可增加一个子类继承该类，自行新增方法以支持国际化。
 * @author Hilbert Wang
 * @since 1.0.3
 */
public abstract class ErrorCode {
	
	/** 系统错误 */
	public static final String H1020 = "H1020";
	public static final String H1020_MSG = "系统错误: " + H1020;
	/** @return 系统错误: H1020 */
	public static String getSysErrorMsg() {
		return H1020_MSG;
	}
	
	/** 该版本不支持 */
	public static final String H1021 = "H1021";
	public static final String H1021_MSG = "该版本不支持: " + H1021;
	/** @return 该版本不支持: H1021 */
	public static String getUnsupportedVersionMsg() {
		return H1021_MSG;
	}
	
	/** 不支持该操作 */
	public static final String H1022 = "H1022";
	public static final String H1022_MSG = "不支持该操作: " + H1022;
	/** @return 不支持该操作: H1022 */
	public static String getUnsupportedMsg() {
		return H1022_MSG;
	}
	
	/** 服务端配置错误 */
	public static final String H1023 = "H1023";
	public static final String H1023_MSG = "服务端配置错误: " + H1023;
	/** @return 服务端配置错误: H1023 */
	public static String getServerConfigErrorMsg() {
		return H1023_MSG;
	}
	
	/** 无网络信号，请检查网络连接 */
	public static final String H1024 = "H1024";
	public static final String H1024_MSG = "无网络信号，请检查网络连接: " + H1024;
	/** @return 服务端配置错误: H1023 */
	public static String getNoNetworkMsg() {
		return H1024_MSG;
	}
	
	/** 您没有权限 */
	public static final String H2021 = "H2021";
	public static final String H2021_MSG = "您没有权限: " + H2021;
	/** @return 您没有权限: H2021 */
	public static String getNoPermissionMsg() {
		return H2021_MSG;
	}
	
	/** 查询出错 */
	public static final String H2022 = "H2022";
	public static final String H2022_MSG = "查询出错: " + H2022;
	/** @return 查询出错: H2022 */
	public static String getQueryErrorMsg() {
		return H2022_MSG;
	}
	
	/** 保存出错 */
	public static final String H2023 = "H2023";
	public static final String H2023_MSG = "保存出错: " + H2023;
	/** @return 保存出错: H2023 */
	public static String getSaveErrorMsg() {
		return H2023_MSG;
	}
	
	/** 更新出错 */
	public static final String H2024 = "H2024";
	public static final String H2024_MSG = "更新出错: " + H2024;
	/** @return 更新出错: H2024 */
	public static String getUpdateErrorMsg() {
		return H2024_MSG;
	}
	
	/** 删除出错 */
	public static final String H2025 = "H2025";
	public static final String H2025_MSG = "删除出错: " + H2025;
	/** @return 更新出错: H2025 */
	public static String getDeleteErrorMsg() {
		return H2025_MSG;
	}
	

}
