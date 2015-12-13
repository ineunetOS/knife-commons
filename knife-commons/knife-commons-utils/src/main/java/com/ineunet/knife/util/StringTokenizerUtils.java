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
package com.ineunet.knife.util;

import java.util.StringTokenizer;

/**
 * @author Hilbert Wang
 * @since 1.0.0
 * Created on 2015-4-3
 */
public final class StringTokenizerUtils {
	
	public static String[] tokenizeToArray(String str, String delim, boolean returntokens) {
		StringTokenizer st = new StringTokenizer(str, delim, returntokens);
		String[] strings = new String[st.countTokens()];
		for (int i = 0; st.hasMoreTokens(); ++i)
			strings[i] = st.nextToken();
		return strings;
	}

	public static String[] tokenizeToArray(String str, String delim) {
		return tokenizeToArray(str, delim, false);
	}

	public static String[] tokenizeToArray(String str) {
		return tokenizeToArray(str, " \t\r\n");
	}
}
