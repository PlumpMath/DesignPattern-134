package vy.construct;

/*
 * 桥接模式
 * 
 * 将抽象部分与实现部分分离，使它们都可以独立的变化。
 */
public class BridgePattern {

	abstract class Road {
		Car car;
		abstract void run();
	}
	abstract class Car {
		abstract void run();
	}
	class Street extends Road {
		@Override
		void run() {
			System.out.println("Street Road >>");
			car.run();
		}
	}
	class City extends Road {
		@Override
		void run() {
			System.out.println("City Road >>");
			car.run();
		}
	}
	class SmallCar extends Car {
		@Override
		void run() {
			System.out.println("small car run...");
		}
	}
	class BigCar extends Car {
		@Override
		void run() {
			System.out.println("big car run...");
		}
	}
	public static void main(String[] args) {
		BridgePattern pattern = new BridgePattern();
		Road road = pattern.new Street();
		road.car = pattern.new SmallCar();
		road.run();
	}
}
