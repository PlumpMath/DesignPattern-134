package vy.behave;

/*
 * ����ģʽ
 * 
 * ��һ��Ӧ�ó�����Ҫʵ��һ���ض��ķ�����߹��ܣ����Ҹó����ж���ʵ�ַ�ʽʱʹ��
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
