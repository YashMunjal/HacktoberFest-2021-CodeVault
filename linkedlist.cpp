 #include <iostream>
 #include <stdio.h>

 using namespace std;

 class node {
    public:
    int data;
    node* next;
 };

 void printlist(node* tempptr){
    while (tempptr){
        cout<<tempptr->data<<" ";
        tempptr=tempptr->next;
 } cout<<endl; }

 void InsertAtFirst(node** headref, int new_data){
     node* new_head=NULL;
     new_head=new node();
     new_head->data=new_data;
     new_head->next=*headref;
     *headref= new_head;

 }

 void InsertAfter(node* prevnode, int new_data){
     if (prevnode==NULL){cout<<"Previous node cannot be null"<<endl; return;}

     node* newnode= new node();

     newnode->data=new_data;
     newnode->next=prevnode->next;
     prevnode->next=newnode;

 }

 void InsertAfter(int pos,node* head, int new_data){

     node* tempptr=head;
     int counter=1;

     while (tempptr!=NULL && counter!=pos){
         tempptr=tempptr->next;
         counter+=1;
     }
     node* newnode= new node();

     newnode->data=new_data;
     newnode->next=tempptr->next;
     tempptr->next=newnode;

 }

 void InsertAtEnd(node** headref,int new_data){
     node* new_node=new node();
     node *last=*headref;
     new_node->data=new_data;
     new_node->next=NULL;

     if (*headref==NULL){*headref=new_node; return;}

     while (last->next!=NULL){
         last=last->next;
     }

     last->next=new_node;
     return;
 }

 int main (){

    node* head=NULL;
    // node* second=NULL;
    // node* third=NULL;

    //head= new node();
    // second=new node();
    // third=new node();

    // head->data=10;
    // head->next=second;

    // second->data=20;
    // second->next=third;

    // third->data=30;
    // third->next=NULL;

    InsertAtFirst(&head,5);

    InsertAtEnd(&head, 20);
    
    printlist(head);

    InsertAfter(2,head,10);

    printlist(head);

    }



 