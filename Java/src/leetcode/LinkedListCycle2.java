package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {

        Map<ListNode, Boolean> map = new HashMap<>();

        public ListNode detectCycle(ListNode head) {

            if (head == null) {
                return null;
            }

            map.put(head, true);

            while (head.next != null && !map.containsKey(head.next)) {
                head = head.next;
                map.put(head, true);
            }

            return head.next;
        }
    }

}
