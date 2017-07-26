package com.changhf.concurrent;

import java.util.concurrent.BlockingQueue;

/**
 * poll: 若队列为空，返回null。 remove:若队列为空，抛出NoSuchElementException异常。
 * take:若队列为空，发生阻塞，等待有元素。
 */
public class Consumer implements Runnable {
	protected BlockingQueue<?> queue = null;

	public Consumer(BlockingQueue<?> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println(queue.take() + "--1");
			System.out.println(queue.take() + "--2");
			System.out.println(queue.take() + "--3");
			System.out.println(queue.take() + "--4");// 若队列中没有数据了，会阻塞
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}