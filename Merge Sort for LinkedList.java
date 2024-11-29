class Node {
    int data;
    Node next;
}

public class MergeSortLinkedList {
    Node sortedMerge(Node a, Node b) {
        Node result = null;

        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }

    void frontBackSplit(Node source, Node frontRef, Node backRef) {
        Node fast;
        Node slow;
        slow = source;
        fast = source.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        frontRef.data = source.data;
        backRef.data = slow.next.data;
        slow.next = null;
    }

    void mergeSort(Node headRef) {
        Node head = headRef;
        Node a;
        Node b;

        if (head == null || head.next == null) {
            return;
        }

        Node[] frontRef = new Node[1];
        Node[] backRef = new Node[1];

        frontBackSplit(head, frontRef[0], backRef[0]);

        a = frontRef[0];
        b = backRef[0];

        mergeSort(a);
        mergeSort(b);

        headRef.data = sortedMerge(a, b).data;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    Node push(Node headRef, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = headRef;
        headRef = new_node;
        return headRef;
    }

    public static void main(String[] args) {
        Node res = null;
        Node a = null;
        MergeSortLinkedList mergeSortLinkedList = new MergeSortLinkedList();

        a = mergeSortLinkedList.push(a, 15);
        a = mergeSortLinkedList.push(a, 10);
        a = mergeSortLinkedList.push(a, 5);
        a = mergeSortLinkedList.push(a, 20);
        a = mergeSortLinkedList.push(a, 3);
        a = mergeSortLinkedList.push(a, 2);

        mergeSortLinkedList.mergeSort(a);

        System.out.println("Sorted Linked List is:");
        mergeSortLinkedList.printList(a);
    }
}
