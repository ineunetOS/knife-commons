package com.ineunet.knife.util.validation;

/**
 * 
 * @author Hilbert Wang
 * @since 1.0.0
 * Created on 2015年3月19日 
 */
public class WebValidatorTests {
	
	public static void main(String[] args) {
		WebValidator valid = new WebValidator();
		
		valid.matchAccount("【账号】", "#");
		valid.matchPassword("【密码】", "#");
		
		System.out.println(valid.getMsg());
	}

}
