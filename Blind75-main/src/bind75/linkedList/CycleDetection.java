package bind75.linkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleDetection {
    public boolean hasCycle(ListNode head) {
        List<Integer> set = new ArrayList<>();
        while(head != null) {
            if(head.val==100001){
                return true;
            } else {
                head.val = 100001;
            }
            head = head.next;
        }
        return false;
    }
}
