package vy.behave;

import java.util.ArrayList;
import java.util.List;

/*
 * 观察者模式
 * 
 * 一个被观察者管理所有相依于它的观察者物件，并且在本身的状态改变时主动发出通知
 * 此种模式通常被用来实现事件处理系统
 * 推模式/拉模式
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
