/**
 * 分析一下这个程序的输出
 */

package com.changhf.concurrent3.c_005;

public class T{
	private int count = 10;
	public synchronized void m() { 
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	public static void main(String[] args) {
		T t = new T();
		for(int i=0; i<5; i++) {
			new Thread(t::m, "THREAD" + i).start();
		}
	}
}
