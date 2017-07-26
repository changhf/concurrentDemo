package com.changhf.concurrent3.c_026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 单个线程池
 * @author changhf
 *
 */
public class T09_SingleThreadPool {
	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		for(int i=0; i<5; i++) {
			final int j = i;
			service.execute(()->{
				
				System.out.println(j + " " + Thread.currentThread().getName());
			});
		}
			
	}
}
