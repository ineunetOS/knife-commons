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
package com.ineunet.knife.qlmap.criteria;

/**
 * @see SimpleRestrictor
 * @author Hilbert Wang
 * 
 * @since 1.2.0
 * 
 */
class ExpressionRestrictor implements Restrictor {

	private String property;
	private String expression;
	private String restriction;

	public ExpressionRestrictor(String property, String expression, RestrictType restriction) {
		this.property = property;
		this.expression = expression;
		this.restriction = Restrictors.getRestriction(restriction);
	}

	public String getProperty() {
		return property;
	}

	public String getExpression() {
		return expression;
	}

	@Override
	public String getRestriction() {
		return restriction;
	}

}
