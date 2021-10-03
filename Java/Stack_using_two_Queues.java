//https://practice.geeksforgeeks.org/problems/stack-using-two-queues/1

// O(n) - push and O(1) - pop

// M1

class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    

    int pop()
    {
        if(q1.isEmpty()) {
            return -1;
        }
        else {
            return q1.poll();
        }
    }
	

    void push(int a)
    {
	    while(!q1.isEmpty()) {
	        q2.add(q1.poll());
	    }
	    
	    q1.add(a);
	    
	    while(!q2.isEmpty()) {
	        q1.add(q2.poll());    
	    }
    }
}

// M2

// O(n) - pop and O(1) - push

class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    

    int pop()
    {
        if(q1.isEmpty()) {
            return -1;
        }
        else {
            while(q1.size() != 1) {
                q2.add(q1.poll());
            }
            int popped = q1.poll();
            while(!q2.isEmpty()) {
                q1.add(q2.poll());
            }
            return popped;
        }
    }
    

    void push(int a)
    {
        q1.add(a);
    }
}



