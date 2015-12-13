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
import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * @author Hilbert
 * 
 * @since 1.0.0
 * 
 */
public abstract class CollectionUtils {

	public static <E> ArrayList<E> newArrayList(Iterable<? extends E> elements) {
		if (elements instanceof Collection) {
			Collection<? extends E> collection = (Collection<? extends E>) elements;
			return new ArrayList<E>(collection);
		} else {
			return newArrayList(elements.iterator());
		}
	}

	public static <E> ArrayList<E> newArrayList(Iterator<? extends E> elements) {
		ArrayList<E> list = new ArrayList<E>();
		while (elements.hasNext()) {
			list.add(elements.next());
		}
		return list;
	}
	
}
