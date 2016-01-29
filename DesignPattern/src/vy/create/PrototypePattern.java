package vy.create;

/*
 * 原型模式
 * 
 * 用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象
 */
public class PrototypePattern {

	class BaseType implements Cloneable {
		@Override
		protected BaseType clone() {
			BaseType baseType = null;
			try {
				baseType = (BaseType) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return baseType;
		}
	}
	class ConcreteBaeType extends BaseType {
		public void show() {
			System.out.println("OK！");
		}
	}
	public static void main(String[] args) {
		PrototypePattern pattern = new PrototypePattern();
		int i = 0;
		ConcreteBaeType base = pattern.new ConcreteBaeType();
		while (i++ < 5) {
			ConcreteBaeType type = (ConcreteBaeType)base.clone();
			type.show();
		}
	}
	
}
