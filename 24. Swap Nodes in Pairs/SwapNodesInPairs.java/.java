class ListNode {
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

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode top = new ListNode(1, head);
        ListNode curr = top;
        while (true) {
            if (curr.next == null || curr.next.next == null)
                break;
            ListNode n = curr.next;
            ListNode nn = curr.next.next;
            n.next = nn.next;
            nn.next = n;
            curr.next = nn;
            curr = n;
        }
        return top.next;
    }
}