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
     public ListNode reverse(ListNode head) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
     }
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=reverse(slow.next);
        slow.next=temp;
        ListNode p1=head;
        ListNode p2=slow.next;
        while(p2!=null){
            if(p1.val!=p2.val)return false;
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }
}