import java.util.Stack;

class Link1 {
    public long dData;
    public Link1 next;

    public Link1(long dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}

class LinkList1 {
    private Link1 first;

    public LinkList1() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(long dd) {
        Link1 newLink = new Link1(dd);
        newLink.next = first;
        first = newLink;
    }

    public long deleteFirst() {
        Link1 temp = first;
        first = first.next;
        return temp.dData;
    }

    public void displayList() {
        Link1 current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public void reverse() {
        Stack<Link1> stack = new Stack<>();

        Link1 current = first;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        first = stack.pop();
        current = first;

        while (!stack.isEmpty()) {
            Link1 nextLink = stack.pop();
            current.next = nextLink;
            current = nextLink;
        }

        current.next = null;
    }
}

class LinkStack {
    private LinkList1 theList;

    public LinkStack() {
        theList = new LinkList1();
    }

    public void push(long j) {
        theList.insertFirst(j);
    }

    public long pop() {
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }

    public void reverseList() {
        theList.reverse();
    }
}

class LinkStackApp {
    public static void main(String[] args) {
        LinkStack theStack = new LinkStack();

        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        System.out.print("Original list: ");
        theStack.displayStack();

        System.out.print("Reversed list: ");
        theStack.reverseList();
        theStack.displayStack();
    }
}