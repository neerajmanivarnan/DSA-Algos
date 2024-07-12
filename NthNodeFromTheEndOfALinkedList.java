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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int size = 0;
        
        while(current!=null){
            
            size+=1;
            current = current.next;
        }

        int target = size-n;
        int i = 0;

        current = head;
        ListNode prev=current;


        while(current!=null){
            if(i == target){
                if(target == 0){
                    head = head.next;
                    break;
                }
                prev.next = current.next;
                break;
            }
            prev = current;
            current = current.next;
            i+=1;
            
        }

        return head;

    }
}
