package week6;

import java.util.HashMap;

public class HashChaining<Key,Value> {
  int M;
  Node[] chain;
  private class Node<Key,Value>{
    Key key;
    Value value;
    Node next;
    public Node(Key k, Value v)
    {
      this.key = k;
      this.value = v;
    }
  }

  public HashChaining(int m) {
    this.M= m;
    chain = new Node[this.M];
  }
  public void put(Key k, Value v)
  {
    Node node = new Node(k,v);
    int index = k.hashCode()%this.M;
    Node pos = chain[index];
    if(pos==null)
    {chain[index]=node;
    return;}
    
    while(pos.next!=null)
      pos = pos.next;
    pos.next = node;
  }
  public Value get(Key k)
  {
    int index = k.hashCode()%this.M;
    Node node = chain[index];
    while(node!=null)
      {
        if(node.key==k) 
          return (Value) node.value;
        node = node.next;
      }
   return null;
  }
  public static void main(String[] args)
  {
    HashChaining<Integer,String> hc = new HashChaining<Integer,String>(7);
    //HashMap<Integer,String> hc = new HashMap<Integer,String>();
    hc.put(1, "prajesh");
    hc.put(2, "ashwin");
    hc.put(3, "kill");
    hc.put(7, null);
    System.out.println(hc.get(3));
  }

}
