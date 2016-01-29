package vy.behave;

/*
 * �н���ģʽ
 * 
 * ��װһϵ�еĶ��󽻻����н���ʹ��������Ҫ��ʾ���໥���ã��Ӷ�ʹ�����ɢ�����ҿ��Զ����ظı�����֮��Ľ���
 */
public class MediatorPattern {

	/*abstract class AbstractColleague {
		protected int number;

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}
		public abstract void setNumber(int number, AbstractColleague coll);
	}
	class CollA extends AbstractColleague {

		@Override
		public void setNumber(int number, AbstractColleague coll) {
			this.number = number;
			coll.setNumber(number * 100);
		}
	}
	class CollB extends AbstractColleague {
		
		@Override
		public void setNumber(int number, AbstractColleague coll) {
			this.number = number;
			coll.setNumber(number/100);
		}
	}*/
	abstract class AbstractColleague {
		protected int number;

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}
		public abstract void setNumber(int number, AbsMediator mediator);
	}
	class CollA extends AbstractColleague {

		@Override
		public void setNumber(int number, AbsMediator mediator) {
			this.number = number;
			mediator.AaffectB();
		}
	}
	class CollB extends AbstractColleague {

		@Override
		public void setNumber(int number, AbsMediator mediator) {
			this.number = number;
			mediator.BaffectA();
		}
	}
	
	abstract class AbsMediator {
		protected AbstractColleague A;
		protected AbstractColleague B;
		
		public AbsMediator(AbstractColleague a, AbstractColleague b) {
			A = a;
			B = b;
		}
		
		protected abstract void AaffectB();
		protected abstract void BaffectA();
	}
	class Mediator extends AbsMediator {

		public Mediator(AbstractColleague a, AbstractColleague b) {
			super(a, b);
		}

		@Override
		protected void AaffectB() {
			int number = A.getNumber();
			B.setNumber(number * 100);
		}

		@Override
		protected void BaffectA() {
			int number = B.getNumber();
			A.setNumber(number/100);
		}
	}

	public static void main(String[] args) {
		MediatorPattern pattern = new MediatorPattern();
		AbstractColleague collA = pattern.new CollA();    
        AbstractColleague collB = pattern.new CollB();    
            
        AbsMediator am = pattern.new Mediator(collA, collB);    
            
        System.out.println("==========ͨ������AӰ��B==========");    
        collA.setNumber(1000, am);    
        System.out.println("collA��numberֵΪ��"+collA.getNumber());    
        System.out.println("collB��numberֵΪA��10����"+collB.getNumber());    
    
        System.out.println("==========ͨ������BӰ��A==========");    
        collB.setNumber(1000, am);    
        System.out.println("collB��numberֵΪ��"+collB.getNumber());    
        System.out.println("collA��numberֵΪB��0.01����"+collA.getNumber());   
	}
	
}
