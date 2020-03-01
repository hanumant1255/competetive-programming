import java.math.BigDecimal;

public class MyLinkedList {
	
	public static void main(String[] args){
		LinkedList<Object> list=new LinkedList<>();
		list.add("1");
		list.add(2);
		list.add(3);
		list.add(4.5);
		System.out.println("Size of List");
		list.print();
		
		list.remove("1");
		list.remove(4.5);
		System.out.println("After removing-Size of List");
		list.print();

	}

}
class Node<T>{
	public Node() {
		
	}
	public Node(T data) {
		this.data=data;
		this.next=null;
	}
	T data;
	Node<T> next;
}
class LinkedList<T>{
	Node<T> head;
	int size;
public void add(T data) {
	if(head==null) {
		head=new Node<T>(data);
	}else {
		Node<T> temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=new Node<T>(data);
	}
}

public void remove(T data) {
	Node<T> temp=head;
	Node<T>prev=null;

	while(temp!=null) {
		
		if(temp.data instanceof String  &&  temp.data==data) {
			remove(temp, prev);
			return;
		}else 	if(temp.data instanceof Double  &&  new BigDecimal(""+temp.data+"").compareTo(new BigDecimal(""+data+""))==0) {
			remove(temp, prev);
			return;
		}
		prev=temp;
		temp=temp.next;

	}
}

private void remove(Node<T> temp, Node<T> prev) {
	if(prev==null) {
		head=temp.next;
		return;
	}
	prev.next=temp.next;
	return;
}

public void print() {
	Node<T> temp=head;
	while(temp!=null) {
		System.out.println(temp.data);
		temp=temp.next;
	}
}
	
}
