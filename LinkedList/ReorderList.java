// 143. Reorder List
// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
// You may not modify the values in the list's nodes, only nodes itself may be changed.

package LinkedList;

public class ReorderList {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        reorderList(node1);
    }

    public static ListNode reverse(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head.next;
        p1.next = null;
        while(p2 != null){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        return p1;
    }
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        ListNode slowPtr = head, fastPtr = head;
        ListNode prev = head;
        // splitting list
        while(fastPtr != null && fastPtr.next != null){
            prev = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        prev.next = null;
        // reverse
        ListNode rev = reverse(slowPtr);
        ListNode ptr = head;
        // arrange alternatively
        while(ptr != null){
            ListNode t1 = ptr.next;
            ListNode t2 = rev.next;
            ptr.next = rev;
            if(t1 != null)
                rev.next = t1;
            ptr = t1;
            rev = t2;
        }
        while (head!=null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
