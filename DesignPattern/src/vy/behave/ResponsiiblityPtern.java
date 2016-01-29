package vy.behave;

/*
 * ������ģʽ
 * 
 * ʹ��������л��ᴦ�����󣬴Ӷ���������ķ����ߺͽ�����֮�����Ϲ�ϵ
 * �������������һ���������������������ݸ�����ֱ����һ����������Ϊֹ
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