
public class MyBST {
	 class Node{		
	 Node(int data) {
      this.data=data;
          }
		int data;
		Node left;
		Node right;
		
	}
	 public class BST{
		Node root;
		public void add(int data) {
			root=add(data,root);
		}
		private Node add(int data, Node root) {
			if(root==null) {
				 root=new Node(data);
				 return root;
				 
			}
			else if(data<root.data) {
				root.left=add(data,root.left);
			}else {
				root.right= add(data,root.right);

			}
			return root;
		}
		
		public void preorderTraversal() {
			
			preorder(root);
		}

		private void preorder(Node root) {
			if(root==null) {
				return;
			}
            preorder(root.left);
            System.out.println(root.data);
            preorder(root.right);

		}
	}
	
	
	public static void main(String args[]) {
		MyBST outer=new MyBST();
		MyBST.BST bst =outer.new BST();
		bst.add(5);
		bst.add(1);
		bst.add(3);
		bst.add(9);
		bst.add(10);
		bst.add(2);
		bst.add(7);
bst.preorderTraversal();
		
	}

}
