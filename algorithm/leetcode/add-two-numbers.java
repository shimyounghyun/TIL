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
import java.util.*;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode t = result;
        while (l1 != null || l2 != null || t != null){ 
            if (l1 != null){
                t.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                t.val += l2.val;
                l2 = l2.next;
            }
            int extra = 0;
            extra = t.val/10;
            t.val = t.val%10;
            if (extra > 0 || l1 != null || l2 != null)
                t.next = new ListNode(extra);
            t = t.next;
        }
        return result;
    }
}
