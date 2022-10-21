class Solution {
public boolean isPalindrome(ListNode head) {
if(head == null || head.next == null){
return true;

   }
    
    // find the mid 
    ListNode fast = head;
    ListNode slow = head;
    while(fast.next != null && fast.next.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }
    ListNode temp = slow.next;
    slow.next = null;
    // reverse  the second half 
    ListNode c1 = temp;
    ListNode c2 = c1.next;
    while(c1 != null && c2 != null){
        ListNode dummy = c2.next;
        c2.next = c1;
        c1 = c2;
        c2 = dummy;
        
    }
    temp.next = null;
    ListNode i = (c2 == null ? c1 :c2);
    ListNode j = head;
    while(i != null ){
        if(i.val != j.val){
            return false;
            
        }
        i = i.next;
        j = j.next;
    }
    return true;
}
}
