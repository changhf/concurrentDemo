package com.changhf.concurrent2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 使用ConcurrentQueue提高并发性,与synchronized对比，效率大大提高
 * 
 * @author changhf
 *
 */
public class TicketSeller2 {
	private static Queue tickets = new ConcurrentLinkedQueue<Integer>();
	static {
		for (int i = 0; i < 1000; i++) {
			tickets.add(i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				while (true) {
					Integer poll = (Integer) tickets.poll();
					if (poll == null) {
						break;
					} else {
						System.out.println(poll);
					}
				}
			}).start();
		}
	}
}
