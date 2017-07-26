/**
 * 同步和非同步方法是否可以同时调用？
 */

package com.changhf.concurrent3.c_007;

public class T {
	public synchronized void m1() { 
		System.out.println(Thread.currentThread().getName() + " m1 start...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " m1 end");
	}
	public void m2() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " m2 ");
	}
	public static void main(String[] args) {
		T t = new T();
		new Thread(t::m1, "t1").start();
		new Thread(t::m2, "t2").start();
	}
}
