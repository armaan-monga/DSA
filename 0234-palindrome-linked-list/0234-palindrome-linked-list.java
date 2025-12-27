class Solution {
    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null)return false;
        if(head.next==null)return true;
        if(head.next.next==null){
            if(head.val==head.next.val)return true;
            else return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode a=reverse(slow);
        ListNode temp=head;
        while(temp!=null && a!=null){
            if(temp.val==a.val){
                temp=temp.next;
                a=a.next;
            }
            else{
                return false;
            }
        }
        return true;
    }
}