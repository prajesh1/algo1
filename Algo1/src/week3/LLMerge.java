package week3;

public class LLMerge {
	Node root;
	
	private class Node{
		public Node(int i) {
			this.value =i;
		}
		private Node next;
		private int value;
	}
	public void createLL(int[] a)
	{
		Node temp = root;
		if(temp==null)
			root=temp = new Node(a[0]);
		else
			{
				temp.next = new Node(a[0]);
				temp = temp.next;
			}
		for(int i=1;i<a.length;i++)
		{
			temp.next = new Node(a[i]);
			temp = temp.next;
		}
	}
	public void traverse(Node start)
	{	
		Node temp =root;
		if(start==null)
			temp = this.root;
		else 
			temp = start;
		while(temp!=null)
		{
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
	}
	public void alternateMerge(LLMerge a, LLMerge b)
	{
		Node start = new Node(0); //using a dummy node.. this is correct soln
		Node c = start;
		Node na = a.root;
		Node nb = b.root;
		while(true)
		{
			if(na==null)
				{
					c.next = nb; break;
				}
			if(nb==null)
				{
					c.next=na; break;
				}
			if(na.value<nb.value)
			{
				c.next = na; c= c.next; na = na.next;
			}
			else
			{
				c.next= nb; c= c.next; nb = nb.next;	
				
			}
		}
		traverse(start.next);
	}
	
	public void reverse()
	{
		if(root==null||root.next==null)
			return ;
		Node current=root.next,next,previous=root;
		root.next= null;//this is important 
		while(current!=null)
		{
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		this.root = previous;
	}
	
	public void recursiveReverse()
	{
		recursiveReverse(root);
	}
	public void recursiveReverse(Node node)
	{
		if(node==null)
			return ;
		
		Node first = node;
		Node rest = node.next;
		
		if(rest==null)
			return;
		root = rest;  //fix root
		recursiveReverse(rest);
		first.next.next = first;
		first.next = null; //avoid circles
		
		
	}
	public static void main(String[] args) {
		/*LLMerge h = new LLMerge();
		int[] a = {2,4,10};
		h.createLL(a);
		h.traverse(null);
		System.out.println(" ");
		int[] b = {1,3,5,7,9};
		LLMerge k = new LLMerge();
		k.createLL(b);
		k.traverse(null);
		System.out.println(" ");
		LLMerge tt = new LLMerge();
		tt.alternateMerge(k, h);*/
		
		/*System.out.println("start ");
		int[] z = {1,3,5,7,9,15,16,17,18};
		LLMerge m = new LLMerge();
		m.createLL(z);
		System.out.println("reverse ");
		m.reverse();
		m.traverse(null);*/
		
		System.out.println("start ");
		int[] z = {1,3,5,7,9,15,16,17,18};
		LLMerge m = new LLMerge();
		m.createLL(z);
		m.traverse(null);
		System.out.println("reverse ");
		m.recursiveReverse();
		m.traverse(null);

	}

}
