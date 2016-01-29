package vy.create;

/*
 * ��������ģʽ
 * 
 * һ�������Ʒ�࣬����������������Ʒ��
 * һ�����󹤳��࣬��������������幤����
 * ÿ�����幤��ֻ������һ�������Ʒ���ʵ��
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
