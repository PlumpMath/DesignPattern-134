package vy.behave;

/*
 * ģ��ģʽ
 * 
 * �����ࣨAbstractClass����ʵ����ģ�巽�����������㷨�ĹǼ�
 * �����ࣨConcreteClass)��ʵ�ֳ������еĳ��󷽷���������������㷨
 */
public class TemplatePattern {

	abstract class Person {
		public void run(){
			read();
			write();
		}
		protected abstract void read();
		protected abstract void write();
	}
	
	class Student extends Person {

		@Override
		protected void read() {
			System.out.println("student read book");
		}

		@Override
		protected void write() {
			System.out.println("student write book");
		}
	}
	
	class Teacher extends Person {

		@Override
		protected void read() {
			System.out.println("teacher read book");
		}

		@Override
		protected void write() {
			System.out.println("teacher write book");
		}
	}
	
	public static void main(String[] args) {
		TemplatePattern pattern = new TemplatePattern();
		Person person = pattern.new Student();
		person.run();
	}
}
