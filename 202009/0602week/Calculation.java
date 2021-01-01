package com.peng.test;

public class Calculation {

	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		/*a = a << 30 ;
		b =( a << 1 ) - 1;*/
		for (int i = 2; i <= 31; i++) {//i表示第几天
			a *= 2;
			b += a;
		}
		System.out.println("假如当月31天:");
		System.out.println("最后一日应付:" + a/100/10000 + "万元");
		System.out.println("总计应付:" + b/100/10000 + "万元");

	}

}
