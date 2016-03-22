package week4;

public class BinarySearchTrees {
	Node root;
	private class Node{
		int value;
		Node left,right;
		public Node(int value)
		{
			this.value= value;
		}
	}
	public void insert(int val)
	{
		root = insert(root,val);
	}
	
	public void insert(int[] val)
	{
		for(int i=0;i<val.length;i++)
			insert(val[i]);
	}
	private Node insert(Node root,int val)
	{
		
		if(root==null)
			{
				Node node = new Node(val);
				return node;			
			}
		if(root.value>val)
			root.left = insert(root.left,val);
		else
			root.right = insert(root.right,val);
		return root;
			
	}
	public void traverse()
	{
		traverse(root);
	}
	private void traverse(Node node)
	{
		if(node.left!=null)
			traverse(node.left);
		System.out.print(node.value +" ");
		if(node.right!=null)
			traverse(node.right);
	}
	public int search(int val)
	{
		return search(root,val);
	}
	private int search(Node node,int val)
	{
		if(node==null)
			return -1;
		if(node.value==val)
			return val;
		if(node.value>val)
			return search(node.left,val);
		else
			return search(node.right,val);
			
	}
	public int inOrdersucessor(int val)  //very bad implementation check the floor implementation
	{
		return inOrder(findNode(root,val));
		
	}
	private Node findNode(Node node,int value)
	{
		while(node.value!=value)
		{
			if(node.value>value)
				node = node.left;
			else
				node = node.right;
		}
		if(node.value==value)
		{
			System.out.println("found node = "+node.value);
			return node;
		}
		else return null;
	}
	private int inOrder(Node node)
	{
		if(node==null)
			return -2;
		if(node.right!=null)
			return minValue(node.right);
		
		// start from root
		Node n = root;
		Node succ = null;
		while(node!=null)
		{
			if(n.value==node.value)  // if i am left child of my parent then my parent is my successor else go to my parent and repeat
				break;
			if(n.value>node.value)
				{
					n = n.left;
					succ = n;
				}
			else
				n = n.right;
			
		}
		if(succ==null)
			return -1;
		else
			return succ.value;
		
		
	}
	private int minValue(Node node)
	{
		while(node.left!=null)
			node = node.left;
		return node.value;
	}
	
	private int floor(int val) //largest int smaller or equal than val
	{
		Node node = root;
		Node pred  = null;
		while(node!=null)  //remeber to check if ==null
		{
			if(val<node.value)
				node = node.left;
			else if(val > node.value)
			{
				pred = node;
				node = node.right;				
			}
			else return node.value;
		}
		if(pred==null) return -1;
		return pred.value;
	}
	
	private int inOrderPred(int val) //largest int smaller or equal than val
	{
		Node node = root;
		Node pred  = null;
		while(node!=null)  //remeber to check if ==null
		{
			 if(val > node.value)
			{
				pred = node;
				node = node.right;				
			}
			else 	node = node.left;
			
		}
		if(pred==null) return -1;
		return pred.value;
	}
	public static void main(String[] args) {
		BinarySearchTrees bst = new BinarySearchTrees();
		int[] a = {2,4,6,3,6,8,2,9,1,7,23,45,76,21,32,98,1,9};
		int[] b = {7,5};
		bst.insert(a);
		bst.traverse();
		System.out.println(" ");
		System.out.println("search"+bst.search(85));
		//System.out.println(bst.inOrdersucessor(97));
		System.out.println("floor"+bst.floor(76));
		System.out.println("InorderPred"+bst.inOrderPred(77 ));

	}

}
