public class Solution {
    public ListNode getIntersectionNode(ListNode heada, ListNode headb) {
        if(heada==null && headb==null)return null;
        if(heada==null || headb==null)return null;
        ListNode tempa=heada;
        ListNode tempb=headb;
        int sizea=0;
        int sizeb=0;
        while(tempa!=null){
            sizea++;
            tempa=tempa.next;
        }
        while(tempb!=null){
            sizeb++;
            tempb=tempb.next;
        }
        tempa=heada;
        tempb=headb;
        if(sizea>sizeb){
            while(sizea-sizeb>0){
                tempa=tempa.next;
                sizea--;
            }
        }
        else{
            while(sizeb-sizea>0){
                tempb=tempb.next;
                sizeb--;
            }
        }
        while(tempa!=null && tempb!=null){
            if(tempa==tempb)return tempb;
            tempa=tempa.next;
            tempb=tempb.next;
        }
        return null;
    }
}