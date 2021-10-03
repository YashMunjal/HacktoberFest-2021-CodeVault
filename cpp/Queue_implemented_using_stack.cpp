#include<iostream>
#include<stack>
using namespace std;

// Implemented queue using one stack only as i used recursion

class queue1{
    private:
        int front1;
        stack<int>s1;
    public:
        void push(int data){    // O(1)
            if(s1.size() == 0)
                front1 = data;
            s1.push(data);
        }
        int pop(){              // O(n)
            if(s1.size() == 2)
                front1 = s1.top();
            int data = s1.top();
            s1.pop();
            if(s1.size() == 0){
                return data;
            }else{
                int data2 = pop();
                s1.push(data);
                return data2;
            }
        }
        int front(){            // O(1)
            return front1;
        }
        int back(){             // O(1)
            return s1.top();
        }
        int size(){             // O(1)
            return s1.size();
        }
        void flush_printer(){   // For testing only
            for(int i = s1.size();i>0;i--){
                cout << pop() << " ";
            }
            cout << endl;
        }
};


int main(){
    queue1 q1;
    q1.push(11);
    q1.push(22);
    cout << q1.front() << endl;
    cout << q1.back() << endl;
    q1.push(33);
    q1.push(44);
    cout << q1.front() << endl;
    cout << q1.back() << endl;
    q1.push(55);
    cout << q1.size() << endl;
    cout << q1.pop() << endl;
    cout << q1.front() << endl;
    cout << q1.back() << endl;
    cout << q1.size() << endl;
    cout << q1.pop() << endl;
    cout << q1.front() << endl;
    cout << q1.back() << endl;
    cout << q1.size() << endl;

    q1.flush_printer();

    return 0;
}