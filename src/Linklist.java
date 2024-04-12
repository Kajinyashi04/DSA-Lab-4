class Link {
    public int iData;              // data item (key)
    public double dData;           // data item
    public Link next;              // next link in list

    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public Link(long dd) {
    }

    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}

class LinkList {
    private Link first;
    private Link last;

    public LinkList() {
        first = null;
        last = null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        if (isEmpty()) {
            last = newLink; // if the list is empty, the new link will be both the first and the last link
        }
        newLink.next = first; // it points to the old first link
        first = newLink; // now first points to this
    }

    public Link getFirst() {
        return first;
    }

    public Link getLast() {
        return last;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public Link find(int key) {
        Link current = first;
        while (current != null) {
            if (current.iData == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current != null) {
            if (current.iData == key) {
                if (current == first) {
                    first = first.next;
                    if (first == null) {
                        last = null; // if the deleted link was the only link in the list
                    }
                } else {
                    previous.next = current.next;
                    if (current == last) {
                        last = previous; // if the deleted link was the last link in the list
                    }
                }
                return current;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Link current = first;
        while (current != null) {
            sb.append(current.toString()).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}

class LinkList2App {
    public static void main(String[] args) {
        LinkList theList = new LinkList();  // make list

        theList.insertFirst(22, 2.99);      // insert 4 items
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();              // display list

        Link f = theList.find(44);          // find item
        if (f != null)
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can't find link");

        Link d = theList.delete(66);        // delete item
        if (d != null)
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can't delete link");

        theList.displayList();              // display list
    }  // end main()
}
