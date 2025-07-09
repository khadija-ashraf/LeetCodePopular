package stack.binary;


public class LowestCommonAncestorBST {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	// intuition1: if p,q any of them matches to the root then the root itself is our LCA,
	// because the definition is 'a node to be a descendant of itself', to the 
	// other node must be on either its left subtree or in the right subtree, that 
	// doesn't matter anymore
	
	// intuition2: if both p,q are smaller than the root in the BST then they 
	// reside on the left subtree of the BST, so their LCA will also be  
	// somewhere in the left subtree
	
	// intuition3: if both p,q are grater than the root in the BST then they 
	// reside on the right subtree of the BST, so their LCA will also be  
	// somewhere in the right subtree
	
	// intuition4: so far we checked 
//					whether any of the p,q are equal to the root
//					whether both p,q are smaller than the root
//					whether both p,q are grater than the root
//	that means 
//			either 	p > root and q < root,
//			or, 	p < root and q > root,
//	In this case the root is the LCA.
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root.val == p.val) return root;
		
		if(root.val == q.val) return root;
		
		if(p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else 
			return root;
    }
	
	public void printList(TreeNode root) {
		if(root == null) {
			return;
		}
		
		System.out.println(root.val);

		printList(root.left);
		printList(root.right);

	}
	
	public static void main(String ar[]) {
		LowestCommonAncestorBST ob = new LowestCommonAncestorBST();
		
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(7);
		TreeNode g = new TreeNode(9);
		TreeNode h = new TreeNode(2);

		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		d.right = h;
		
		
//		TreeNode lca = ob.lowestCommonAncestor(a, b, c);
//		System.out.println(lca.val);
		
		TreeNode lca = ob.lowestCommonAncestor(a, b, e);
		System.out.println(lca.val);
		
	}
}
