import java.util.Random;

class Link2 {
    public long dData;                // data item
    public Link2 next;                 // next link in list

    public Link2(long d)               // constructor
    {
        dData = d;
    }

    public void displayLink()         // display this link
    {
        System.out.print(dData + " ");
    }
}

class FirstLastList {
    public Link2 first;               // ref to first item
    private Link2 last;                // ref to last item

    public FirstLastList()            // constructor
    {
        first = null;                  // no items on list yet
        last = null;
    }

    public boolean isEmpty()          // true if no links
    {
        return first == null;
    }

    public void insertLast(long dd) // insert at end of list
    {
        Link2 newLink = new Link2(dd);   // make new link
        if (isEmpty())                // if empty list,
            first = newLink;            // first --> newLink
        else
            last.next = newLink;        // old last --> newLink
        last = newLink;                // newLink <-- last
    }

    public long deleteFirst()         // delete first link
    {                              // (assumes non-empty list)
        long temp = first.dData;
        if (first.next == null)         // if only one item
            last = null;                // null <-- last
        first = first.next;            // first --> old next
        return temp;
    }

    public void displayList() {
        Link2 current = first;          // start at beginning
        while (current != null)         // until end of list,
        {
            current.displayLink();      // print data
            current = current.next;     // move to next link
        }
        System.out.println();
    }
}

class LinkQueue {
    private FirstLastList theList;

    public LinkQueue()                // constructor
    {
        theList = new FirstLastList();  // make a 2-ended list
    }

    public boolean isEmpty()          // true if queue is empty
    {
        return theList.isEmpty();
    }

    public void insert(long j)        // insert, rear of queue
    {
        theList.insertLast(j);
    }

    public long remove()              // remove, front of queue
    {
        return theList.deleteFirst();
    }

    public int size()                 // number of elements in the queue
    {
        int count = 0;
        Link2 current = theList.first;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
}

class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        Random random = new Random();

        theQueue.insert(20);                 // insert items
        theQueue.insert(40);

        theQueue.displayQueue();             // display queue

        theQueue.insert(60);                 // insert items
        theQueue.insert(80);

        theQueue.displayQueue();             // display queue

        theQueue.remove();                   // remove items
        theQueue.remove();

        theQueue.displayQueue();             // display queue

        theQueue.insert(100);                // insert additional items
        theQueue.insert(120);

        theQueue.displayQueue();             // display queue

        // Simulate serving customers
        int numCustomers = theQueue.size();
        int servingTime = 1000; // Time taken to serve a customer in milliseconds

        for (int i = 1; i <= numCustomers; i++) {
            long customer = theQueue.remove();
            System.out.println("Serving customer " + customer);
            try {
                Thread.sleep(servingTime); // Simulate serving time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        theQueue.displayQueue();             // display queue
    }
}