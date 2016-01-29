package vy.behave;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*
 * ����¼ģʽ
 * 
 * �ڲ��ƻ���װ�Ե�ǰ���£�����һ��������ڲ�״̬�����ڸö���֮�Ᵽ�����״̬������Ҫʱ���Խ��ö���ָ���ԭ�ȱ����״̬
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
		ori.setState1("��֪");
		ori.setState2("��ѧ");
		ori.setState3("��ʤ");
		System.out.println("===��ʼ��״̬===\n" + ori);

		caretaker.setMemento("001", ori.createMemento());
		ori.setState1("˯��");
		ori.setState2("�Է�");
		ori.setState3("��Ϸ");
		System.out.println("===�޸ĺ�״̬===\n" + ori);

		ori.restoreMemento(caretaker.getMemento("001"));
		System.out.println("===�ָ���״̬===\n" + ori);
	}
}
