package vy.construct;

/*
 * 适配器模式
 * 
 * 将一个类的接口转换成客户希望的另外一个接口
 * Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作
 */
public class AdapterPattern {

	class Adaptee {
		public void go() {
			System.out.println("被适配器具有 功能..");
		}
	}
	interface Target {
		void request();
	}
	class ConcreteTarget implements Target {
		@Override
		public void request() {
			System.out.println("普通类 具有 普通功能..");
		}
	}
	class Adatpter extends Adaptee implements Target {
		@Override
		public void request() {
			super.go();
		}
	}
	public static void main(String[] args) {
		AdapterPattern pattern = new AdapterPattern();
		//普通请求
		Target target = pattern.new ConcreteTarget();
		target.request();
		//特殊请求
		target = pattern.new Adatpter();
		target.request();
	}
}
