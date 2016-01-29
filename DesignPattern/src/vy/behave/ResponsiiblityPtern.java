package vy.behave;

/*
 * 责任链模式
 * 
 * 使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系
 * 将这个对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理他为止
 */
public class ResponsiiblityPtern {

//	protected AtomicInteger count = new AtomicInteger(0);
	
	abstract class Handler {
		protected Handler handler;
		abstract void handleRequest();
		public Handler getNextHandler() {
			return handler;
		}
		public void setNextHandler(Handler handler) {
			this.handler = handler;
		}
	}
	
	class ConcreteHandler extends Handler {

		@Override
		void handleRequest() {
			if (null != getNextHandler()) {
				NumberCount.countIncrement();
				System.out.println("next go!");
				getNextHandler().handleRequest();
			} else {
				System.out.println("[handler] " + NumberCount.getCount() + " do request");
			}
		}
	}
	public static void main(String[] args) {
		ResponsiiblityPtern pattern = new ResponsiiblityPtern();
		Handler hand1 = pattern.new ConcreteHandler(); 
		Handler hand2 = pattern.new ConcreteHandler(); 
		hand1.setNextHandler(hand2);
		hand1.handleRequest();
	}
}

class NumberCount {
	private static int count = 1;
	public static void countIncrement() {
		count ++;
	}
	public static int getCount() {
		return count;
	}
}