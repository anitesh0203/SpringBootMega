package bind75.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        ListNode head1 = null;
        ListNode node = null;
        for (int i = list.size()-1 ; i>=0; i--) {
            if(head1==null) {
                node = new ListNode(list.get(i));
                head = node;
            } else {
                ListNode temp = new ListNode(list.get(i));
                node.next =  temp;
                node = temp;
            }
        }
        return head1;
    }
}
