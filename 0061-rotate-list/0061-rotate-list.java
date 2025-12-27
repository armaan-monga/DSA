class Solution {
    public ListNode rotateRight(ListNode head, int k) {
       if(head==null || head.next==null)return head;
       ListNode temp=head;
       int size=1;
       while(temp.next!=null){
        temp=temp.next;
        size++;
       } 
       temp.next=head;
       k=k%size;
       int n=size-k;
       while(n>0){
        temp=temp.next;
        n--;
       }
       ListNode returnhead=temp.next;
       temp.next=null;
       return returnhead;
    }
}