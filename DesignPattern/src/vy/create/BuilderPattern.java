package vy.create;

/*
 * ������ģʽ
 * 
 * ��һ�����ӵĶ���Ĺ��������ı�ʾ���룬ʹ��ͬ���Ĺ������̿��Դ�����ͬ�ı�ʾ
 */
public class BuilderPattern {

	interface ToyBuilder {
		void doHeight();
		void doWeight();
		Toy getResult();
	}
	
	class Builder implements ToyBuilder {

		Toy toy;

		public Builder() {
			this.toy = new Toy();
		}

		@Override
		public void doHeight() {
			toy.setHeight(15);
			System.out.println("height ok!");
		}

		@Override
		public void doWeight() {
			toy.setWeight(10);
			System.out.println("weight ok!");
		}

		@Override
		public Toy getResult() {
			System.out.println("get Toy!");
			return toy;
		}
	}
	
	class Director {
		public Toy constructToy(Builder b) {
			b.doHeight();
			b.doWeight();
			return b.getResult();
		}
	}
	
	public static void main(String[] args) {
		BuilderPattern builderPattern = new BuilderPattern();
		builderPattern.new Director().constructToy(builderPattern.new Builder());
	}
}

class Toy {
	
	private int height;
	private int weight;

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}