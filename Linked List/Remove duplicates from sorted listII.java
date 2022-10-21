class Solution {
public ListNode deleteDuplicates(ListNode head) {

    ListNode start = new ListNode(0, head);
    ListNode prev = start, curr = head; 
    
    while( curr != null && curr.next != null ){
        
        if( curr.val == curr.next.val ){
            
            while( curr != null && curr.next != null&& curr.val == curr.next.val ){
                 
                curr.next = curr.next.next; 
                
            }
            
            prev.next = curr.next ;
             curr = prev.next; 
        }else{
            
            prev = curr; 
            curr = curr.next; 
        }
        
    }
     
    return start.next;
     
}
}
