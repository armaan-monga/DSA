class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int cnt=0;
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            cnt++;
        }
        if(cnt<k)return head;
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(head!=null){
            head.next=curr;
        } 
        if(curr!=null){
            head.next=reverseKGroup(curr,k);
        }
        return prev;
           }
}