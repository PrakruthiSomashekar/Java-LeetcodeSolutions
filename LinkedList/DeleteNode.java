package LinkedList;

public class DeleteNode {

    public static void main(String[] args) {
        ListNode node3 = new ListNode(9);
        ListNode node2 = new ListNode(1,node3);
        ListNode node1 = new ListNode(5,node2);
        ListNode node = new ListNode(4,node1);
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.print(node);
        System.out.println();
        deleteNode.deleteNode(node1);
        deleteNode.print(node);
    }

    private void print(ListNode node) {
        while (node!=null){
            System.out.print(node.val+"->");
            node = node.next;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
