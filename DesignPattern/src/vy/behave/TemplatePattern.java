package vy.behave;

/*
 * 模板模式
 * 
 * 抽象类（AbstractClass）：实现了模板方法，定义了算法的骨架
 * 具体类（ConcreteClass)：实现抽象类中的抽象方法，已完成完整的算法
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
