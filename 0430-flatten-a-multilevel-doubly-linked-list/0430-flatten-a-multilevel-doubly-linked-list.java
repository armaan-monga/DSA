class Solution {
    public Node flatten(Node head) {
        Node temp=head;
        while(temp!=null){
            if(temp.child!=null){
                Node childhead=temp.child;
                Node nextnode=temp.next;
                temp.next=childhead;
                childhead.prev=temp;
                temp.child=null;
                Node tail=childhead;
                while(tail.next!=null){
                    tail=tail.next;
                }
                if(nextnode!=null){
                    tail.next=nextnode;
                    nextnode.prev=tail;
                }
                
            }

            temp=temp.next;
        }
return head;
    }
}