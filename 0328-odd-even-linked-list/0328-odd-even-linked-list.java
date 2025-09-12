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
    public ListNode oddEvenList(ListNode head) {
       // public static boolean isodd(i
        ListNode temp=head;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(-1);
        ListNode tempo=odd;
        ListNode tempe=even;
        int index=1;
        while(temp!=null){
            if(index%2==1){
                tempo.next=temp;
                tempo=tempo.next;
            }else{
                tempe.next=temp;
                tempe=tempe.next;
            }
            temp=temp.next;
            index++;
        }
        tempe.next=null;
        tempo.next=even.next;
        return odd.next;
    }
}