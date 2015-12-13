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

import java.math.BigDecimal;

/**
 * 
 * @author Hilbert Wang
 * @since 1.0.0
 * Created on 2015-4-8
 */
public class DecimalUtils {
	
	public static final BigDecimal _100 = new BigDecimal(100);
	
	private DecimalUtils() {}
	
	/**
	 * Cut invalid scale.
	 * @param val e.g. 0.350, its scale is 3
	 * @return 0.35, its scale is 2.
	 */
	public static BigDecimal cutInvalidSacle(BigDecimal val) {
		if (val == null) return null;
		double d = val.doubleValue();
		int i = val.intValue();
		if (d == i)
			return new BigDecimal(i);
		return new BigDecimal(Double.toString(d));
	}
	
	/**
	 * e.g. 0.30 equals 0.3 && 0.30 equals 0.30 && 0.30 equals 0.300.
	 */
	public static boolean isValueEquals(BigDecimal decimal1, BigDecimal decimal2) {
		if (decimal1 == null && decimal2 == null) return true;
		if (decimal1 == null && decimal2 != null) return false;
		if (decimal1 != null && decimal2 == null) return false;
		return cutInvalidSacle(decimal1).equals(cutInvalidSacle(decimal2));
	}

}
