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

import java.util.ArrayList;
import java.util.List;

import com.ineunet.knife.util.sql.SqlStrUtils;

/**
 * 
 * @author Hilbert Wang
 * @since 1.0.0
 * Created on 2015-4-11
 */
public abstract class ExpressionStrUtils {

	public static String escapeRegex$(String s) {
		return s.replaceAll("\\x24", "\\\\x24");
	}
	
	/**
	 * @see SqlStrUtils#getNamedParameters(String)
	 * @param str e.g. abc$ww
	 * @param delim e.g. $
	 * @return e.g. [ww]
	 */
	public static List<String> getNamedParameters(String str, String delim) {
		List<String> params = new ArrayList<String>();
		String[] tokens = StringTokenizerUtils.tokenizeToArray(str, delim, true);
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i].trim();
			if (token.equals(delim)) {
				String varDraft = tokens[i + 1].trim();
				String param = varDraft.split("(\\)|\\}| |,|;|\\?|>|<|=|\\+|-|\\*|\\/)")[0].trim();
				params.add(param);
				++i;
			}
		}
		return params;
	}
	
}
