package vy.behave;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * ������ģʽ
 * 
 * ��װĳЩ������ĳ�����ݽṹ�и�Ԫ�صĲ������������ڲ��ı����ݽṹ��ǰ���¶�����������ЩԪ�ص��µĲ��� * 
 */
public class VisitPattern {

	abstract class Element {
		public abstract void accept(IVisitor vistor);
		public abstract void doing();
	}
	class ConcreteElment1 extends Element {
		@Override
		public void accept(IVisitor vistor) {
			vistor.visit(this);
		}

		@Override
		public void doing() {
			System.out.println(this.getClass().getSimpleName()+" - doing");
		}
	}
	class ConcreteElment2 extends Element {
		@Override
		public void accept(IVisitor vistor) {
			vistor.visit(this);
		}
		
		@Override
		public void doing() {
			System.out.println(this.getClass().getSimpleName()+" - doing");
		}
	}	
	interface IVisitor {
		public void visit(ConcreteElment1 ele1);
		public void visit(ConcreteElment2 ele2);
	}
	class Visitor implements IVisitor {

		@Override
		public void visit(ConcreteElment1 ele1) {
			ele1.doing();
		}

		@Override
		public void visit(ConcreteElment2 ele2) {
			ele2.doing();
		}
	}
	class ObjectStruture {    
	    public List<Element> getList(){    
	        List<Element> list = new ArrayList<Element>();    
	        Random ran = new Random();    
	        for(int i=0; i<10; i++){    
	            int a = ran.nextInt(100);    
	            if(a>50){    
	                list.add(new ConcreteElment1());    
	            }else{    
	                list.add(new ConcreteElment2());    
	            }    
	        }    
	        return list;    
	    }    
	} 
	public static void main(String[] args) {
		VisitPattern pattern = new VisitPattern();
		List<Element> list = pattern.new ObjectStruture().getList();
		for (Element e : list) {
			e.accept(pattern.new Visitor());
		}
	}
}
