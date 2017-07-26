/**
 * ThreadLocal�ֲ߳̾�����
 *
 * ThreadLocal��ʹ�ÿռ任ʱ�䣬synchronized��ʹ��ʱ�任�ռ�
 * ������hibernate��session�ʹ�����ThreadLocal�У�����synchronized��ʹ��
 *
 * ��������ĳ������ThreadLocal
 * 
 * @author ��ʿ��
 */
package com.changhf.concurrent3.c_022;

import java.util.concurrent.TimeUnit;

public class ThreadLocal2 {
	static ThreadLocal<Person> tl = new ThreadLocal<>();
	public static void main(String[] args) {
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" "+tl.get());
		}).start();
		
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tl.set(new Person());
			System.out.println(Thread.currentThread().getName()+" "+tl.get());
		}).start(); 
	}
	static class Person {
		String name = "zhangsan";
	}
}


