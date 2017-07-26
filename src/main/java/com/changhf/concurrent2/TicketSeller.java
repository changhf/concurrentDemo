package com.changhf.concurrent2;

import java.util.ArrayList;
import java.util.List;

public class TicketSeller {
	private static List<Integer> tickets = new ArrayList<Integer>();

	static {
		for (int i = 0; i < 1000; i++) {
			tickets.add(i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				while (true) {
					synchronized (tickets) {// 对票加锁，使对之操作具有原子性
						if (tickets.size() <= 0)
							break;
						else
							System.out.println("销售了" + tickets.remove(0));
					}
				}
			}).start();
		}
	}
}
