class Solution {
    public static int len(ListNode head){
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int n=len(head);
        int groups=n/k;
        ListNode currhead=head;
        ListNode prevhead=null;
        ListNode ansnode=null;
        for(int i=0;i<groups;i++){
            ListNode prev=null;
            ListNode curr=currhead;
            ListNode next=null;
            for(int j=0;j<k;j++){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            if(prevhead==null){
                ansnode=prev;
            }
            else{
                prevhead.next=prev;
            }
            prevhead=currhead;
            currhead=curr;
        }
        prevhead.next=currhead;
        return ansnode;
    }
}