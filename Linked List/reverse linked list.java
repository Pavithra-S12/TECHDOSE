class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null,cur=head,nxt;
        
        while(cur!=null){
            nxt=cur.next;//to store next Node which is being DeLinked
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
		
        head=pre;
        return head;
    }
}
