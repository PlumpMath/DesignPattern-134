package vy.behave;

import java.util.ArrayList;
import java.util.List;

/*
 * �۲���ģʽ
 * 
 * һ�����۲��߹����������������Ĺ۲�������������ڱ����״̬�ı�ʱ��������֪ͨ
 * ����ģʽͨ��������ʵ���¼�����ϵͳ
 * ��ģʽ/��ģʽ
 */
public class ObserverPattern {

	interface Watcher {
		public void udpdate();
	}
	interface Watched {
		void addWatcher(Watcher watcher);
		void removeWatcher(Watcher watcher);
		void notifyWatchers();
	}
	class W1 implements Watcher {
		@Override
		public void udpdate() {
			System.out.println("W1 go..");
		}
	}
	class W2 implements Watcher {
		@Override
		public void udpdate() {
			System.out.println("W2 go..");
		}
	}
	class W3 implements Watcher {
		@Override
		public void udpdate() {
			System.out.println("W3 go..");
		}
	}
	class WatchedThing implements Watched {
		private List<Watcher> list = new ArrayList<Watcher>();
		
		@Override
		public void addWatcher(Watcher watcher) {
			list.add(watcher);
		}

		@Override
		public void removeWatcher(Watcher watcher) {
			list.remove(watcher);
		}

		@Override
		public void notifyWatchers() {
			for (Watcher w : list) {
				w.udpdate();
			}
		}
	}
	
	public static void main(String[] args) {
		ObserverPattern pattern = new ObserverPattern();
		WatchedThing thing = pattern.new WatchedThing();
		thing.addWatcher(pattern.new W1());
		thing.addWatcher(pattern.new W2());
		thing.addWatcher(pattern.new W3());
		thing.notifyWatchers();
	}
}
