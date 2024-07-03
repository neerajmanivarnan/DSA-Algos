/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode nxt ;
        

        while(current!=null){
            nxt = current.next;
            current.next = previous;
            previous = current;
            current = nxt;
            // nxt = nxt.next;
        
        }

        return previous;


    }
}
