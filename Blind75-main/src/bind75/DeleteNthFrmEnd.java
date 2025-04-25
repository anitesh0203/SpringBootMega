package bind75;

public class DeleteNthFrmEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode ptr = head;
            int size = 0;
            while (ptr != null) {
                size++;
                ptr = ptr.next;
            }
            int target = size - n;

            int pos = 1;

            ptr = head;
            if (1 == (target + 1) && size == 1) {
                return null;
            }
            if (target == 0) {
                head = head.next;
                return head;
            }
            while (ptr != null) {
                if (pos == target) {
                    if (ptr.next.next != null) {
                        ListNode post = ptr.next.next;
                        // swap
                        ptr.next = post;
                        ptr = ptr.next;
                        pos++;
                    } else {
                        ptr.next =null;
                        return head;
                    }

                } else {
                    ptr = ptr.next;
                    pos++;
                }
            }
            return  head;
        }
    }
}
