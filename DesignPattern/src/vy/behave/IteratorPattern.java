package vy.behave;

/*
 * 迭代子模式 or 游标模式(CursorPattern)
 * 
 * 可以顺序地访问一个聚集中的元素而不必暴漏聚集的内部表象
 */
public class IteratorPattern {

	abstract class Aggregate {
		abstract Iterator createIterator();
	}
	
	class ConcreteAggregate extends Aggregate {

		private Object[] objArray = null;
		
		public ConcreteAggregate(Object[] objArray) {
			this.objArray = objArray;
		}

		@Override
		Iterator createIterator() {
			return new ConcreteIterator(this);
		}
		
		public Object getElement(int index) {
			if (index < objArray.length) {
				return objArray[index];
			} else {
				return null;
			}
		}
		
		public int getSize() {
			return objArray.length;
		}
	}
	interface Iterator {
		public void first();
		public void next();
		public boolean isDone();
		public Object currentItem();
	}
	class ConcreteIterator implements Iterator {

		private ConcreteAggregate agg;
		private int index = 0;
		private int size = 0;
		
		public ConcreteIterator(ConcreteAggregate agg) {
			this.agg = agg;
			this.size = agg.getSize();
			this.index = 0;
		}

		@Override
		public void first() {
			index = 0;
		}

		@Override
		public void next() {
			if (index < size) {
				index ++;
			}
		}

		@Override
		public boolean isDone() {
			return (index >= size);
		}

		@Override
		public Object currentItem() {
			return agg.getElement(index);
		}
	}
	
	class Client {
		public void operate() {
			Object[] objArray = {"One","Two","Three","Four","Five","Six"};
			Aggregate agg = new ConcreteAggregate(objArray);
			Iterator it = agg.createIterator();
			while(!it.isDone()){  
	            System.out.println(it.currentItem());  
	            it.next();  
	        } 
		}
	}
	
	public static void main(String[] args) {
		IteratorPattern pattern = new IteratorPattern();
		pattern.new Client().operate();
	}
}
