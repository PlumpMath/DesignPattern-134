package vy.behave;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*
 * 备忘录模式
 * 
 * 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。在需要时可以将该对象恢复到原先保存的状态
 */
public class MemoPattern {

	class Originator {
		private String state1 = "";
		private String state2 = "";
		private String state3 = "";

		public String getState1() {
			return state1;
		}

		public void setState1(String state1) {
			this.state1 = state1;
		}

		public String getState2() {
			return state2;
		}

		public void setState2(String state2) {
			this.state2 = state2;
		}

		public String getState3() {
			return state3;
		}

		public void setState3(String state3) {
			this.state3 = state3;
		}

		public Memento createMemento() {
			return new Memento(new BeanUtils().backupProp(this));
		}

		public void restoreMemento(Memento memento) {
			new BeanUtils().restoreProp(this, memento.getStateMap());
		}

		public String toString() {
			return "state1=" + state1 + "state2=" + state2 + "state3=" + state3;
		}
	}

	class BeanUtils {
		public Map<String, Object> backupProp(Object bean) {
			Map<String, Object> result = new HashMap<String, Object>();
			try {
				BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
				PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
				for (PropertyDescriptor des : descriptors) {
					String fieldName = des.getName();
					Method getter = des.getReadMethod();
					Object fieldValue = getter.invoke(bean, new Object[] {});
					if (!fieldName.equalsIgnoreCase("class")) {
						result.put(fieldName, fieldValue);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

		public void restoreProp(Object bean, Map<String, Object> propMap) {
			try {
				BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
				PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
				for (PropertyDescriptor des : descriptors) {
					String fieldName = des.getName();
					if (propMap.containsKey(fieldName)) {
						Method setter = des.getWriteMethod();
						setter.invoke(bean, new Object[] { propMap.get(fieldName) });
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class Memento {
		private Map<String, Object> stateMap;

		public Memento(Map<String, Object> map) {
			this.stateMap = map;
		}

		public Map<String, Object> getStateMap() {
			return stateMap;
		}

		public void setStateMap(Map<String, Object> stateMap) {
			this.stateMap = stateMap;
		}
	}

	class Caretaker {
		private Map<String, Memento> memMap = new HashMap<String, Memento>();

		public Memento getMemento(String index) {
			return memMap.get(index);
		}

		public void setMemento(String index, Memento memento) {
			this.memMap.put(index, memento);
		}
	}

	public static void main(String[] args) {
		MemoPattern pattern = new MemoPattern();
		Originator ori = pattern.new Originator();
		Caretaker caretaker = pattern.new Caretaker();
		ori.setState1("求知");
		ori.setState2("求学");
		ori.setState3("求胜");
		System.out.println("===初始化状态===\n" + ori);

		caretaker.setMemento("001", ori.createMemento());
		ori.setState1("睡觉");
		ori.setState2("吃饭");
		ori.setState3("游戏");
		System.out.println("===修改后状态===\n" + ori);

		ori.restoreMemento(caretaker.getMemento("001"));
		System.out.println("===恢复后状态===\n" + ori);
	}
}
