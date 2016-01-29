package vy.behave;

import java.util.HashMap;
import java.util.Map;

/*
 * 解释器模式
 * 
 * 定义了语言的文法，并且建立一个解释器来解释该语言中的句子
 */
public class Interpreterpattern {

	class Context {
		private final Map<String, Integer> valueMap = new HashMap<String, Integer>();

		public void addValue(final String key, final int value) {
			valueMap.put(key, Integer.valueOf(value));
		}

		public int getValue(final String key) {
			return valueMap.get(key).intValue();
		}
	}

	public abstract class AbstractExpression {
		public abstract int interpreter(Context context);
	}

	public class AddNonterminalExpression extends AbstractExpression {
		private final AbstractExpression left;
		private final AbstractExpression right;

		public AddNonterminalExpression(final AbstractExpression left, final AbstractExpression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int interpreter(final Context context) {
			return this.left.interpreter(context) + this.right.interpreter(context);
		}
	}

	public class DivisionNonterminalExpression extends AbstractExpression {
		private final AbstractExpression left;
		private final AbstractExpression right;

		public DivisionNonterminalExpression(final AbstractExpression left, final AbstractExpression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int interpreter(final Context context) {
			final int value = this.right.interpreter(context);
			if (value != 0) {
				return this.left.interpreter(context) / value;
			}
			return -1;
		}

	}

	public class MultiplyNonterminalExpression extends AbstractExpression {
		private final AbstractExpression left;
		private final AbstractExpression right;

		public MultiplyNonterminalExpression(final AbstractExpression left, final AbstractExpression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int interpreter(final Context context) {
			return this.left.interpreter(context) * this.right.interpreter(context);
		}

	}

	public class SubtractNonterminalExpression extends AbstractExpression {
		private final AbstractExpression left;
		private final AbstractExpression right;

		public SubtractNonterminalExpression(final AbstractExpression left, final AbstractExpression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int interpreter(final Context context) {
			return this.left.interpreter(context) - this.right.interpreter(context);
		}
	}

	public class TerminalExpression extends AbstractExpression {
		private final int i;

		public TerminalExpression(final int i) {
			this.i = i;
		}

		@Override
		public int interpreter(final Context context) {
			return this.i;
		}

	}

	public static void main(String[] args) {
		Interpreterpattern pattern = new Interpreterpattern();
		// (a/b)*(a+b-c)
		final Context context = pattern.new Context();
		context.addValue("a", 8);
		context.addValue("b", 4);
		context.addValue("c", 2);
		final DivisionNonterminalExpression division = pattern.new DivisionNonterminalExpression(
				pattern.new TerminalExpression(context.valueMap.get("a")),
				pattern.new TerminalExpression(context.valueMap.get("b")));
		final AddNonterminalExpression add = pattern.new AddNonterminalExpression(
				pattern.new TerminalExpression(context.valueMap.get("a")),
				pattern.new TerminalExpression(context.valueMap.get("b")));
		final SubtractNonterminalExpression subtract = pattern.new SubtractNonterminalExpression(add,
				pattern.new TerminalExpression(context.valueMap.get("c")));
		final MultiplyNonterminalExpression result = pattern.new MultiplyNonterminalExpression(division, subtract);
		System.out.println("(a/b)*(a+b-c) is: " + result.interpreter(context));
	}
}
