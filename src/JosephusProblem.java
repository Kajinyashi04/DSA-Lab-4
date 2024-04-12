import java.util.Scanner;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    void deleteNode(Node node) {
        if (head == null)
            return;

        if (head == node) {
            head = node.next;
        }

        Node current = head;
        while (current.next != node) {
            current = current.next;
        }
        current.next = node.next;
    }

    void solveJosephusProblem(int numOfPeople, int countOff) {
        for (int i = 1; i <= numOfPeople; i++) {
            insert(i);
        }

        Node current = head;
        while (numOfPeople > 1) {
            for (int count = 1; count < countOff; count++) {
                current = current.next;
            }

            Node nextNode = current.next;
            deleteNode(current);
            current = nextNode;
            numOfPeople--;
        }

        System.out.println("The order of elimination is:");
        System.out.println(head.value);
    }
}

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people in the circle: ");
        int numOfPeople = scanner.nextInt();

        System.out.print("Enter the counting-off number: ");
        int countOff = scanner.nextInt();

        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.solveJosephusProblem(numOfPeople, countOff);

        scanner.close();
    }
}