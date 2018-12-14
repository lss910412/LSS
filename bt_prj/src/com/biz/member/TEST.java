package com.biz.member;

import java.util.ArrayList;

public class TEST {

	public static void main(String[] args) {
		// equal to 0.0 and less than 1.0.
		// 0.0 <= rnum < 1.0  (0.0~0.9) 
		//!@_ _ _ _ 
		
		int rnum1 = (int)(Math.random() *10);
		System.out.println(rnum1);
		int rnum2 = (int)(Math.random() *10);
		System.out.println(rnum2);
		int rnum3 = (int)(Math.random() *10);
		System.out.println(rnum3);
		int rnum4 = (int)(Math.random() *10);
		System.out.println(rnum4);
		
		String newPw = "!@"+rnum1+rnum2+rnum3+rnum4;
		System.out.println(newPw);
	}

}
