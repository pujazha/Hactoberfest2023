#include<iostream>
using namespace std;
#include "created_linked_list.cpp"

Node * insertion(){
    Node * head=NULL;
    Node * tail=NULL;
    int a;
    cin>>a;
    while(a!=-1){
        Node *newnode= new Node(a);
        if(head==NULL){
            head=newnode;
            tail=head;
        }
        else{
            tail->next=newnode;
            tail=tail->next;
        }
        cin>>a;
    }
    return head;
}

void display(Node * head){
    while(head!=NULL){
        cout<<head->data<<endl;
        head=head->next;
    }
}

Node * mid(Node * head){
    Node * slow = head;
    Node * fast = head->next;
    while(fast!=NULL ||fast->next!=NULL){
        slow=slow->next;
        fast=fast->next->next;
    }
    return slow;
}

Node * merge_two_sorted_LL(Node *head1,Node * head2){
    Node * real =NULL;
    Node * final_tail=NULL;
    if(head1->data<head2->data){
        real=head1;
        head1=head1->next;
        final_tail=real;
    }
    else{
        real=head2;
        head2=head2->next;
        final_tail=real;

    }
    while(head1!= NULL&& head2!=NULL){
        if(head1->data<head2->data){
            final_tail->next=head1;
            final_tail=final_tail->next;
            head1=head1->next;
        }
        else{
            final_tail->next=head2;
            final_tail=final_tail->next;
            head2=head2->next;
        }
    }

    if(head1!=NULL){
        final_tail->next=head1;
    }
    else{
        final_tail->next=head2;
    }
    return real;
}

Node * merge(Node * head){
    if(head->next==NULL||head==NULL){
        return head;
    }

    Node * mmiddle=mid(head);
    Node * second=mmiddle->next;
    mmiddle->next=NULL;
    Node * first=head;

    Node * h1=merge(first);
    Node * h2=merge(second);

    Node * ans=merge_two_sorted_LL(h1,h2);
    return ans;

}

int main(){
   /* Node * head=insertion();
    cout<<"the linked list before the mergesort operation is:-"<<endl;
    display(head);

    head=merge(head);
    cout<<"the linked list after performing the merge sort operation is:-"<<endl;

    display(head);

    */

   Node * head1=insertion();
   Node * h2=insertion();
   Node * ans=merge_two_sorted_LL(head1,h2);
   display(ans);
}
