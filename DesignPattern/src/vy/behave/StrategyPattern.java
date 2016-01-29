package vy.behave;

/*
 * 策略模式
 * 
 * 当一个应用程序需要实现一种特定的服务或者功能，而且该程序有多种实现方式时使用
 */
public class StrategyPattern {

	interface Strategy {
		void run();
	}
	class StgOne implements Strategy {
		@Override
		public void run() {
			System.out.println("run [1]");
		}
	}
	class StgTwo implements Strategy {
		@Override
		public void run() {
			System.out.println("run [2]");
		}
	}
	class Context {
		private Strategy strategy;
		public Context(Strategy strategy) {
			this.strategy = strategy;
		}
		public void run() {
			strategy.run();
		}
	}
	public static void main(String[] args) {
		StrategyPattern pattern = new StrategyPattern();
		Context context = pattern.new Context(pattern.new StgOne());
		context.run();
	}
}
