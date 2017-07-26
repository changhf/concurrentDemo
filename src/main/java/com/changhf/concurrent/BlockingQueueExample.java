package com.changhf.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue是在生产/消费者模式下经常会用到的数据结构，通常常用的主要会是ArrayBlockingQueue、
 * LinkedBlockingQueue
 * 
 * @author changhf
 *
 */
public class BlockingQueueExample {

	public static void main(String[] args) throws Exception {

		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}