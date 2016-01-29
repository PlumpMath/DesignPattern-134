package vy.create;

/*
 * 抽象工厂模式
 * 
 * 多个抽象产品类，每个抽象产品类可以派生出多个具体产品类   
 * 一个抽象工厂类，可以派生出多个具体工厂类
 * 每个具体工厂类可以创建多个具体产品类的实例
 */
public class AbsFactroyPattern {

	interface EngineOne {
	}
	class OneOne implements EngineOne {
		public OneOne() {
			System.out.println("one A");
		}
	}
	class OneTwo implements EngineOne {
		public OneTwo() {
			System.out.println("two A");
		}
	}
	interface EngineTwo {
	}
	class TwoOne implements EngineTwo {
		public TwoOne() {
			System.out.println("two A");
		}
	}
	class TwoTwo implements EngineTwo {
		public TwoTwo() {
			System.out.println("two B");
		}
	}
	interface AbsFactory {
		public EngineOne createEngineOne();
		public EngineTwo createEngineTwo();
	}
	class OneFactory implements AbsFactory {

		@Override
		public EngineOne createEngineOne() {
			return new OneOne();
		}

		@Override
		public EngineTwo createEngineTwo() {
			return new TwoOne();
		}
	}
	class TwoFactory implements AbsFactory {

		@Override
		public EngineOne createEngineOne() {
			return new OneTwo();
		}

		@Override
		public EngineTwo createEngineTwo() {
			return new TwoTwo();
		}
	}
	public static void main(String[] args) {
		AbsFactroyPattern factroyPattern = new AbsFactroyPattern();
		AbsFactory absFactory = factroyPattern.new OneFactory();
		absFactory.createEngineOne();
		absFactory.createEngineTwo();
	}
}
