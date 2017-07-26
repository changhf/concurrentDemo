package com.changhf.concurrent;

import java.util.concurrent.BlockingQueue;

/**
 * put方法，若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素。
 * offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false。
 *
 */
public class Producer implements Runnable {
	protected BlockingQueue<String> queue = null;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			boolean b1 = queue.offer("1");
			boolean b2 = queue.offer("11");
			Thread.sleep(1000);
			boolean b3 = queue.offer("2");
			Thread.sleep(1000);
			boolean b4 = queue.offer("3");
			System.out.println(b1 + " " + b2 + " " + b3 + " " + b4 + " ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}