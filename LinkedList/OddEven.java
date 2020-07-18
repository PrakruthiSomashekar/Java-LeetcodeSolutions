package LinkedList;
// Given a singly linked list, group all odd nodes together followed by the even nodes.
// Please note here we are talking about the node number and not the value in the nodes.

public class OddEven {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        OddEven oddEven = new OddEven();
        oddEven.initializeList(head);
        oddEven.printList(head);
        System.out.println();
        oddEven.printList(oddEven.oddEvenList(null));
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        else if(head.next == null || head.next.next == null)
            return head;
        ListNode temp = head.next;
        ListNode temp1 = head.next;
        ListNode prev = head;
        ListNode curr = head.next.next;

        while (temp1.next!=null || curr!=null){
            prev.next = temp1.next;
            temp1.next = curr.next;
            curr.next = temp;
            if(temp1.next == null)
                break;
            curr = temp1.next.next;
            prev = prev.next;
            temp1 = temp1.next;
        }
       return head;

    }

    private void initializeList(ListNode head) {
        int i=2;
        ListNode temp = head;
        while (i<=7){
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = node;
            i++;
        }
    }

    private void printList(ListNode head){
        while (head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
    public ListNode(int val, ListNode node){
        this.val = val;
        this.next = node;
    }
}
