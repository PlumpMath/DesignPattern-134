package vy.construct;

/*
 * ������ģʽ
 * 
 * ��һ����Ľӿ�ת���ɿͻ�ϣ��������һ���ӿ�
 * Adapterģʽʹ��ԭ�����ڽӿڲ����ݶ�����һ��������Щ�������һ����
 */
public class AdapterPattern {

	class Adaptee {
		public void go() {
			System.out.println("������������ ����..");
		}
	}
	interface Target {
		void request();
	}
	class ConcreteTarget implements Target {
		@Override
		public void request() {
			System.out.println("��ͨ�� ���� ��ͨ����..");
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
		//��ͨ����
		Target target = pattern.new ConcreteTarget();
		target.request();
		//��������
		target = pattern.new Adatpter();
		target.request();
	}
}
