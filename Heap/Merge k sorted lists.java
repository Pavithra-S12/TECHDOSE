class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
     PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode l1 ,ListNode l2)->l1.val-l2.val);
        
        for(ListNode list : lists){
            if(list!=null){
                pq.add(list);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            temp.next=pq.poll();
            temp=temp.next;
            
            if(temp.next!=null){
                pq.add(temp.next);
            }
        }
        
        return dummy.next;
    }
}
