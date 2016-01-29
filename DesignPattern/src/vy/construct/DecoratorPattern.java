package vy.construct;

/*
 * װ����ģʽ
 * 
 * װ�����뱻װ����ӵ�й�ͬ�ĳ��࣬�̳е�Ŀ���Ǽ̳����ͣ���������Ϊ 
 */
public class DecoratorPattern {

	interface Human {
		void buyBook();
		void readBook();
	}
	
	abstract class DrctHuman implements Human {
		private Human human;

		public DrctHuman(Human human) {
			this.human = human;
		}
		
		public void buyBook() {
			human.buyBook();
		}
		
		public void readBook() {
			human.readBook();
		}
	}
	
	class DrctFirst extends DrctHuman {

		public DrctFirst(Human human) {
			//����������ʵ��
			super(human);
		}
		
		private void firstOne() {
			System.out.println("first method one phase");
		}
		
		private void firstTwo() {
			System.out.println("first metho two phase");
		}
		
		@Override
		public void buyBook() {
			firstOne();
			super.buyBook();
		}
		
		@Override
		public void readBook() {
			firstTwo();
			super.readBook();
		}
	}
	
	class DrctSecond extends DrctHuman {

		public DrctSecond(Human human) {
			//����������ʵ��
			super(human);
		}
		
		private void secondOne() {
			System.out.println("second method one phase");
		}
		
		private void sencondTwo() {
			System.out.println("second metho two phase");
		}
		
		@Override
		public void buyBook() {
			secondOne();
			super.buyBook();
		}
		
		@Override
		public void readBook() {
			sencondTwo();
			super.readBook();
		}
	}
	
	class Person implements Human {

		@Override
		public void buyBook() {
			System.out.println("base human method - buyBook");
		}

		@Override
		public void readBook() {
			System.out.println("base human method - readBook");
		}
		
	}
	public static void main(String[] args) {
		DecoratorPattern dPattern = new DecoratorPattern();
		Human human = dPattern.new Person();
		DrctHuman drct = dPattern.new DrctSecond(dPattern.new DrctFirst(human));
		drct.buyBook();
		drct.readBook();
	}
}
