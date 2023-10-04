/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        int size = length(head);
        int x = 0;
        if(n == size) head = head.next;
        ListNode temp = head;
        ListNode prev = head;
        while(x != size - n ){
            x++;
            prev = temp;
            temp = temp.next;
        }
        if(temp != null){
            prev.next = temp.next;
        }
        return head;
    }
    int length(ListNode head){
        int n = 0;
        while(head != null){
            n++;
            head = head.next;
        }
        return n;
    }
}
