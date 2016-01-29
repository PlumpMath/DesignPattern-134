package vy.create;

import java.util.HashMap;
import java.util.Map;

/*
 * 单例模式
 * 
 * 单例类只能有一个实例
 * 单例类必须自己创建自己的唯一实例
 * 单例类必须给所有其他对象提供这一实例
 */
public class SinglePattern {

	public static void main(String[] args) {
		
	}
}

//lazy style
class SingleOne {
	private static SingleOne sOne = null;

	private SingleOne() {
	}
	
	public synchronized static SingleOne getInstance() {
		if (sOne == null) {
			sOne = new SingleOne();
		}
		return sOne;
	}
	
	//double check
	public static SingleOne getInstance2() {
		if (sOne == null) {
			synchronized (SingleOne.class) {
				if (sOne == null) {
					sOne = new SingleOne();
				}
			}
		}
		return sOne;
	}
	
	//static inner class
	private static class Holder {
		private static final SingleOne statieOne = new SingleOne();
	}
	public static final SingleOne getInstance3() {
		return Holder.statieOne;
	}
}

//full style
class SingleTwo {
	private SingleTwo() {
	}
	private static final SingleTwo stwo = new SingleTwo();
	
	public static SingleTwo getInstance() {
		return stwo;
	}
}

//record style
class SingleThree {

	private static Map<String, SingleThree> map = new HashMap<String,SingleThree>();
	static {
		SingleThree three = new SingleThree();
		map.put(three.getClass().getName(), three);
	}
	public static SingleThree getInstance(String name) {
		if (name == null) {
			name = SingleThree.class.getName();
			System.out.println("name == null ...>>> " + name);
		}
		if (null == map.get(name)) {
			try {
				map.put(name, (SingleThree)Class.forName(name).newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return map.get(name);
	}
}