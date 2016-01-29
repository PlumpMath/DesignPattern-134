package vy.construct;

/*
 * ����ģʽ
 * 
 * һ����ϵͳһ�����棬��ģʽΪ��ϵͳ�ṩһ�����л��ͼ򻯵Ĺ�ͨ�ܵ���������ϣ�
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
