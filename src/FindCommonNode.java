import java.math.BigDecimal;

public class FindCommonNode {
	
	public static void main(String args[]) {
		
		LinkedList<Integer>firstList=new LinkedList();
		firstList.add(1);
		firstList.add(2);
		firstList.add(3);
		firstList.add(4);
		firstList.add(5);
		firstList.print();
		LinkedList<Integer>secondList=new LinkedList();
		firstList.add(3);
		firstList.add(4);
		firstList.add(5);
		firstList.print();	
	}
	
	static class Node<T>{
		public Node() {
			
		}
		public Node(T data) {
			this.data=data;
			this.next=null;
		}
		T data;
		Node<T> next;
	}
	static class LinkedList<T>{
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
			}else if(temp.data==data){
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


}

