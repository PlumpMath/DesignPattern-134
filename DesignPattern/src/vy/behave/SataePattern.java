package vy.behave;

/*
 * ×´Ì¬Ä£Ê½
 * 
 * Àý£º À¶-ºì-ÂÌ-À¶ £¨Ñ­»··´¸´ÇÐ»»£©
 */
public class SataePattern {

	abstract class State {
		public abstract void handlePush(Context c);
		public abstract void handlePull(Context c);
		public abstract void get();
	}
	
	class Context {
		private State state = null;

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}
		public void pull() {
			state.handlePull(this);
			state.get();
		}
		public void push() {
			state.handlePush(this);
			state.get();
		}
	}
	class BlueState extends State {

		@Override
		public void handlePush(Context c) {
			System.out.println("change to [GREEN]");
			c.setState(new GreenState());
		}

		@Override
		public void handlePull(Context c) {
			System.out.println("change to [RED]");
			c.setState(new RedState());
		}

		@Override
		public void get() {
			System.out.println("Now is [BLUE] status.");
		}
	}
	class RedState extends State {
		
		@Override
		public void handlePush(Context c) {
			System.out.println("change to [BLUE]");
			c.setState(new BlueState());
		}
		
		@Override
		public void handlePull(Context c) {
			System.out.println("change to [GREEN]");
			c.setState(new GreenState());
		}
		
		@Override
		public void get() {
			System.out.println("Now is [RED] status.");
		}
	}
	class GreenState extends State {
		
		@Override
		public void handlePush(Context c) {
			System.out.println("change to [RED]");
			c.setState(new RedState());
		}
		
		@Override
		public void handlePull(Context c) {
			System.out.println("change to [BLUE]");
			c.setState(new BlueState());
		}
		
		@Override
		public void get() {
			System.out.println("Now is [GREEN] status.");
		}
	}
	public static void main(String[] args) {
		SataePattern pattern = new SataePattern();
		Context context = pattern.new Context();
		State state = pattern.new GreenState();
		context.setState(state);
		context.pull();
	}
}
