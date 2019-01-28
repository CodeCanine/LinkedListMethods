public class LinkedList {

    private Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private static void listAll(LinkedList list) {
        Node current = list.head;
        System.out.println("Linked list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("\n");
    }

    private void deleteNode(int key) {
        Node temp = head;
        Node prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;
        prev.next = temp.next;
    }

    private static LinkedList add(LinkedList list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    private boolean search(Node head, int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x)
                return true;
            current = current.next;
        }
        return false;    //data not found
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list = add(list, 45);
        list = add(list, 33);
        list = add(list, 22);
        list = add(list, 1);

        listAll(list);

        int key = 55;
        list.deleteNode(key);

        listAll(list);

        int x = 22;
        if (list.search(list.head, x)) {
            System.out.println("Found " + x);
        } else {
            System.out.println("Did not find it");
        }
    }
}
