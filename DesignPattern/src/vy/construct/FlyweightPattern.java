package vy.construct;

import java.util.Hashtable;

/*
 * 享元模式
 * 
 * 以共享的方式高效地支持大量的细粒度对象，降低系统创建对象实例的性能消耗
 */
public class FlyweightPattern {

	abstract class BaseType {
		abstract void operate();
	}
	class ConcreteBaseType extends BaseType {

		public String str;
		public ConcreteBaseType(String str) {
			this.str = str;
		}
		@Override
		void operate() {
			System.out.println(str + " style");
		}
	}
	class BaseTypeFactory {
		private Hashtable flyweight = new Hashtable();
		public BaseType getType(Object obj) {
			BaseType base = (BaseType) flyweight.get(obj);
			if (base == null) {
				base = new ConcreteBaseType((String)obj);
				flyweight.put(obj, base);
			}
			return base;
		}
		public int getNumber() {
			return flyweight.size();
		}
	}
}
