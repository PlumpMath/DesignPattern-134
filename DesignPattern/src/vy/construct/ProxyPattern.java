package vy.construct;

/*
 * 代理模式
 * 
 * 对一些对象提供代理，以限制那些对象去访问其他对象
 */
public class ProxyPattern {

	interface Buy {
		void buy();
	}
	
	class Person implements Buy {

		private double cash;
		private String name;
		@Override
		public void buy() {
			System.out.println(name + " want to buy a car.");
		}
		public double getCash() {
			return cash;
		}
		public void setCash(double cash) {
			this.cash = cash;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	class ProxyBuy implements Buy {

		private Person per;
		public ProxyBuy(Person per) {
			this.per = per;
		}
		@Override
		public void buy() {
			if (per.getCash() > 50000) {
				per.buy();
				System.out.println("OK!");
				return;
			} else {
				System.out.println("sorry! money is not enough.");
			}
		}
	}
	
	public static void main(String[] args) {
		ProxyPattern pattern = new ProxyPattern();
		Person per = pattern.new Person();
		per.setName("AAA");
		per.setCash(50000.5);
		pattern.new ProxyBuy(per).buy();
	}
}
