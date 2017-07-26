package com.changhf.concurrent3.c_004_important;

public class Deadlock {
	/**
	 * @author windows ����ʵ����
	 */
	static class Friend {
		// ��������
		private final String name;

		// ����ʵ�����͵Ĺ��췽��
		public Friend(String name) {
			this.name = name;
		}

		// ��ȡ����
		public String getName() {
			return this.name;
		}

		// �������ҾϹ���������ͬ���ģ�
		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
			bower.bowBack(this);
		}

		// �һؾ��Ϲ���������ͬ���ģ�
		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
		}
	}

	public static void main(String[] args) {
		// ����ģ�������Կ�ʼ
		// ������������alphonse��Gaston
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		// ������λ���˾Ϲ����̡߳�
		new Thread(() -> alphonse.bow(gaston)).start();
		new Thread(() -> gaston.bow(alphonse)).start();
	}
}