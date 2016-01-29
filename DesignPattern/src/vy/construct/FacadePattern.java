package vy.construct;

/*
 * 门面模式
 * 
 * 一个子系统一个门面，该模式为子系统提供一个集中化和简化的沟通管道（降低耦合）
 */
public class FacadePattern {

	class ModuleA {
		public void test1() {
			System.out.println("method A");
		}
	}
	class ModuleB {
		public void test2() {
			System.out.println("method B");
		}
	}
	
	class Facade {
		public void test() {
			ModuleA a = new ModuleA();
			a.test1();
			ModuleB b = new ModuleB();
			b.test2();
		}
	}
	class Client {
		public void go() {
			Facade facade = new Facade();
			facade.test();
		}
	}
	
	public static void main(String[] args) {
		new FacadePattern().new Client().go();
	}
}
