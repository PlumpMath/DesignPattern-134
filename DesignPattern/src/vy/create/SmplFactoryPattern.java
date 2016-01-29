package vy.create;

/*
 * 工厂方法模式
 * 
 * 一个抽象产品类，可派生出多个具体产品类
 * 一个抽象工厂类，可派生出多个具体工厂类
 * 每个具体工厂只能生产一个具体产品类的实例
 */
public class SmplFactoryPattern {

	abstract class Mantou {
		public Mantou() {
		}
	}
	class RedMantou extends Mantou {
		public RedMantou() {
			System.out.println("red mantou");
		}
	}
	class GreenMantou extends Mantou {

		public GreenMantou() {
			System.out.println("green mantou");
		}
	}
	/*class MantouFactory {
		public Mantou createMantou (String type) { 
			if ("red".equals(type)) {
				return new RedMantou();
			}
			if ("green".equals(type)) {
				return new GreenMantou();
			}
			return null;
		}
	}*/
	interface Factory {
		Mantou createMantou();
	}
	class RedFactory implements Factory {
		@Override
		public Mantou createMantou() {
			return new RedMantou();
		}
	}
	class GreenFactory implements Factory {

		@Override
		public Mantou createMantou() {
			return new GreenMantou();
		}
		
	}
	public static void main(String[] args) {
		SmplFactoryPattern factoryPattern = new SmplFactoryPattern();
		Factory factory = factoryPattern.new RedFactory();
		factory.createMantou();
	}
}
