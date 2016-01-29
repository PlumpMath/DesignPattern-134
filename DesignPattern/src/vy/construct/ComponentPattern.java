package vy.construct;

import java.util.ArrayList;
import java.util.List;

/*
 * 组合模式
 * 
 * 将对象组合成树形结构以表示‘部分-整体’的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性
 */
public class ComponentPattern {

	abstract class Tree {
		String name;
		abstract void add(Tree t);
		abstract void remove(Tree t);
		abstract void cutDown();
	}
	class TreeBranch extends Tree {

		List<Tree> tree = new ArrayList<>();
		
		public TreeBranch(String name) {
			this.name = name;
		}
		
		@Override
		void add(Tree t) {
			tree.add(t);
		}

		@Override
		void remove(Tree t) {
			tree.remove(t);
		}

		@Override
		void cutDown() {
			System.out.println(name + " go");
			for (Tree t : tree) {
				t.cutDown();
			}
		}
	}
	
	class TreeLeaf extends Tree {

		@Override
		void add(Tree t) {
		}

		@Override
		void remove(Tree t) {
		}

		@Override
		void cutDown() {
			System.out.println(name + " cut down..");
		}
	}
	
	public static void main(String[] args) {
		ComponentPattern component = new ComponentPattern();
		Tree left_branch = component.new TreeBranch("LEFT");
		Tree right_branch = component.new TreeBranch("RIGHT");
		Tree left_leaf = component.new TreeLeaf();
		left_leaf.name = "left leaf";
		Tree right_leaf = component.new TreeLeaf();
		right_leaf.name = "right leaf";
		left_branch.add(left_leaf);
		left_branch.add(right_leaf);
		right_branch.add(left_leaf);
		right_branch.add(right_leaf);
		left_branch.cutDown();
		right_branch.cutDown();
	}
}
