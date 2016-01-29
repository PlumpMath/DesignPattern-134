package vy.behave;

/*
 * 命令模式
 * 
 * 将来自客户端的请求传入一个对象，从而使你可用不同的请求对客户进行参数化
 * 用于“行为请求者”与“行为实现者”解耦，可实现二者之间的松耦合
 */
public class CommandPattern {

	interface Command {
		void execute();
	}
	class TV {
		public int currentCount = 0;
		public void turnOn() {
			System.out.println("turn on ..");
		}
		public void turnOff() {
			System.out.println("turn off ..");
		}
	}
	class ONComd implements Command {

		private TV myTv;
		
		public ONComd(TV tv) {
			this.myTv = tv;
		}
		
		@Override
		public void execute() {
			myTv.turnOn();
		}
	}
	 class OFFComd implements Command {
		 private TV myTv;
			
		 public OFFComd(TV tv) {
			this.myTv = tv;
	   	 }
			
	  	 @Override
		 public void execute() {
			myTv.turnOff();
		 }
	 }
	 class Controller {
		private Command oncmd, offcmd;

		public Controller(Command oncmd, Command offcmd) {
			this.oncmd = oncmd;
			this.offcmd = offcmd;
		}
		
		public void turnOn() {
			oncmd.execute();
		}
		public void turnOff() {
			offcmd.execute();
		}
	 }
	 public static void main(String[] args) {
		CommandPattern pattern = new CommandPattern();
		TV tv = pattern.new TV();
		ONComd oncmd = pattern.new ONComd(tv);
		OFFComd offcmd = pattern.new OFFComd(tv);
		Controller controller = pattern.new Controller(oncmd, offcmd);
		controller.turnOn();
		controller.turnOff();
		
	}
}
