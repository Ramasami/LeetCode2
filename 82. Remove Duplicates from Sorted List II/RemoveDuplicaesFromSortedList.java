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

public class RemoveDuplicaesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode(-1000, head);
        head = first;
        while (head.next != null) {
            ListNode curr = head;
            ListNode next = curr.next;
            if (next.next != null && next.val == next.next.val) {
                ListNode n = next.next;
                while (n != null && n.val == next.val) {
                    n = n.next;
                }
                curr.next = n;
                continue;
            } else {
                head = head.next;
                continue;
            }
        }
        return first.next;
    }
}