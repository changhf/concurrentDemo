/**
 * ������ִ�й����У���������쳣��Ĭ��������ᱻ�ͷ�
 * ���ԣ��ڲ�������Ĺ����У����쳣Ҫ���С�ģ���Ȼ���ܻᷢ����һ�µ������
 * ���磬��һ��web app��������У����servlet�̹߳�ͬ����ͬһ����Դ����ʱ����쳣�������ʣ�
 * �ڵ�һ���߳����׳��쳣�������߳̾ͻ����ͬ�����������п��ܻ���ʵ��쳣����ʱ�����ݡ�
 * ���Ҫ�ǳ�С�ĵĴ���ͬ��ҵ���߼��е��쳣
 */
package com.changhf.concurrent3.c_011;

import java.util.concurrent.TimeUnit;

public class T {
	int count = 0;
	synchronized void m() {
		System.out.println(Thread.currentThread().getName() + " start");
		while(true) {
			count ++;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
			try {
				TimeUnit.SECONDS.sleep(1);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(count == 5) {
				int i = 1/0; //�˴��׳��쳣���������ͷţ�Ҫ�벻���ͷţ��������������catch��Ȼ����ѭ������
			}
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		new Thread(t::m, "t1").start();
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(t::m, "t2").start();
	}
	
}


