package com.changhf.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

//生产者消费者模式： ArrayBlockingQueue有界队列
public class BlockingQueueExample {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(() -> producer.m()).start();
		new Thread(() -> consumer.m()).start();

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Producer {
	protected BlockingQueue<String> queue = null;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void m() {
		try {
			boolean b1 = queue.offer("1");
			// Thread.sleep(1000);
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

class Consumer {
	protected BlockingQueue<?> queue = null;

	public Consumer(BlockingQueue<?> queue) {
		this.queue = queue;
	}

	public void m() {
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