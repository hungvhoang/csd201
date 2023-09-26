/*
 * Name: Hoang Viet Hung
 * Student Code: SE183800
 * Purpose: Problem 1: Circular Linked list.
 *  - Make a class for a singly linked circular list using only one pointer.
 */


class CircularLinkedApp{
    public static void main(String[] args) {
        CircularLinkedList theList = new CircularLinkedList();
        theList.insertAfter(5);
        theList.insertAfter(8);
        theList.insertAfter(3);
        theList.insertAfter(7);
        theList.insertAfter(2); 
        theList.displayList();


        System.out.println("Search for 8:"+((theList.search(8) == null) ? "not found" : "found"));
        System.out.println("Search for 10:"+((theList.search(10) == null) ? "not found" : "found"));
        
        System.out.println("After delete 3");
        theList.delete(3);
        theList.displayList();
    }
}

class Link{
    int iData;
    Link next;

    Link(int iData){
        this.iData = iData;
    }

    void displayLink(){
        System.out.print(this.iData+" ");
    }
}

/**
 * A circular linked list which only use one pointer call "current".
 */
class CircularLinkedList{
    Link current = null; //the list is empty.

    /**
     * moves the current to the next link and return the previous link
     */
    Link step(){
        if(current == null)//- Check if the list is empty
            return null;
        else{
            Link previous = current;
            current = current.next;
            return previous;
        }
    }

    /**
     * insert a new link after "current" and "current" is now the new link.
     * @param data
     */
    void insertAfter(int data){
        Link newLink = new Link(data);
        if(current == null){ 
            current = newLink;
            current.next = newLink;
        }
        else{
            newLink.next = current.next;
            current.next = newLink;
            current= newLink;
        }
    }

    Link search(int data){
        Link mark = current;
        //Iterate through the list and break when found or met the mark   
        while (current.iData != data) {
            if(current.next == mark){
                current = mark; //set the current to the original link;
                return null;
            }
            step();
        }
        return current;
    }

    /**
     * delete a link and return it.
     * @param data
     * @return
     */
    Link delete(int data){
        Link deleteLink=null;
        Link mark = current;
        Link previous=null;
        while(current.iData != data){
            if(current.next == mark) return null; // return null if not found
            previous = step();
        }
        deleteLink = current;
        current = current.next;
        previous.next = current;
        return deleteLink;
    }

    void displayList(){
        Link mark = current;
        System.out.print("The list: ");
        do {
            current.displayLink();
            step();
        } while (current != mark);
        System.out.println("");
        System.out.println("Current pointer is point at: "+current.iData);
    }
}

