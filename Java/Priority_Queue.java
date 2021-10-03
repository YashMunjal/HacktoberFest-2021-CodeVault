import java.util.*;
class Node{
    int data;
    int priority;
    Node next;
    Node(int d,int p){
        data = d;
        priority = p;
    }
}
class PriorityQueue{
    Node head;
    public void enque(int d,int p){
        
        Node newNode = new Node(d,p);
         if(head == null){
            head = newNode;
        }
        else if(head.priority > p){
            newNode.next = head.next;
            head = newNode;
        }
        else{
            Node prev = null;
            Node curr = head;
            while(curr != null && curr.priority <= p ){
                prev = curr;
                curr = curr.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
        
    }
    public int deque(){
        if(head == null){
            return -1;
        }
        else{
            int res = head.data;
            head = head.next;
            return res;
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		PriorityQueue p = new PriorityQueue();
		p.enque(20,1);
		p.enque(30,1);
		p.enque(40,1);
		System.out.println(p.deque());
	}
}
