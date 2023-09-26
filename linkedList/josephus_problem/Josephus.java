/*
 * Name: Hoang Viet Hung
 * Student code: SE183800
 * Purpose:
 *  An application that uses a circular linked list to caluclate the Josephus problem.
 */

import java.util.Scanner;

class Link{
    int data;
    Link next;

    Link(int index){
        this.data = index;
    }


    void displayLink(){
        System.out.print(this.data+" ");
    }
}

class CirLinkedList{
    Link ptr = null; //pointer
    

    /**
     * move the pointer "step" times and return the previous link of the pointer.
     * @param step
     */
    Link move(){
        if(ptr == null)//- Check if the list is empty
            return null;
        else{
            Link previous = ptr;
            ptr = ptr.next;
            return previous;
            }
    }
    

    /**
     * check if the list contains only ONE link
     * @return
     */
    boolean isContainsOne(){
        return (ptr.next==ptr);
    }

    /**
     * check if the list is empty
     * @return
     */
    boolean isEmpty(){
        return (ptr==null);
    }

    /**
     * add a link to the list and move the pointer to the new link.
     * @param num
     */
    private void add(int num){
        Link newLink = new Link(num);
        if(isEmpty()){ 
            ptr = newLink;
            ptr.next = newLink;
        }  
        else{
            newLink.next = ptr.next;
            ptr.next = newLink;
            ptr = newLink;
        }      
    }
    /**
     * add "size" links to the list and move the pointer to the first link.
     * Example addSomeLink(5) -> List: 1 -> 2 -> 3 -> 4 -> 5 --- ptr is at 1
     * @param size
     */
    void addSomeLink(int size){
        for (int i = 1; i <= size ; i++){
            add(i);
        }
        move();
    }

    /**
     * Search a value from the list
     * -If found: return the link set the pointer to the link.
     * -Not found: return null the pointer unchanged.
     * @param num
     * @return
     */
    Link search(int num){
        Link mark = ptr;
        //Iterate through the list and break when found or met the mark   
        while (ptr.data != num) {
            if(ptr.next == mark){
                ptr = mark; //set the current to the original link;
                return null;
            }
            move(); 
        }
        return ptr;
    }

    /**
     * delete next link of the ptr and move the ptr to the link after it.
     * @return
     */
    Link deleteAfter(){
        Link deleteLink = ptr.next;
        ptr.next = deleteLink.next;
        ptr = ptr.next;
        return deleteLink;
    }

    /**
     * search and delete a link by its data.
     * @param data
     * @return
     */
    Link delete(int data){
        Link deleteLink=null;
        Link mark = ptr;
        Link previous=null;
        while(ptr.data != data){
            if(ptr.next == mark) return null; // return null if not found
            previous = move();
        }
        deleteLink = ptr;
        ptr = ptr.next;
        previous.next = ptr;
        return deleteLink;
    }

    void displayList(){
        Link mark = ptr;
        System.out.print("The list: ");
        do {
            ptr.displayLink();
            move();
        } while (ptr != mark);
        System.out.println("");
        System.out.println("Current pointer is point at: "+ptr.data);
    }
}

public class Josephus {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        String temp ="";
        System.out.println("\tJosephus problem application:");
        do {
            josh();
            System.out.print("Countinue? (yes/no): ");
            temp= sc.nextLine();
        } while (temp.equalsIgnoreCase("yes"));
    }


    static void josh(){
        CirLinkedList circle = new CirLinkedList();
        int numberOfPeople = inputInt("Enter the number of people in the circle");
        circle.addSomeLink(numberOfPeople); // add "numberOfPeople to the link"
        int countingOff = inputInt("Enter the number used for counting off"); //First link to be eliminated
        int start = inputInt("Enter the number of the person where counting starts: "); //start position
        if(circle.search(start) == null) System.out.println("Not found");
        else {
            System.out.print("Elimination order: ");
            //loop until there's only one link in the list
            while(!circle.isContainsOne()){
                // move the ptr to the link where next link will be eliminated.
                for (int i = 0; i < countingOff-start-1; i++) {
                    circle.move();
                }
                // delete the link and print out.
                Link eliminateLink = circle.deleteAfter();
                eliminateLink.displayLink();
            }
            System.out.println("");
            System.out.print("Last persion standing: ");
            circle.ptr.displayLink();
            System.out.println("");
        }
    }
    
    static int inputInt(String mess){
        int num=0;
        boolean condition = false;
        do {
            try {
                System.out.print(mess+": ");
                num = Integer.parseInt(sc.nextLine());
                if(num <= 0) throw new Exception();
                condition = true;
            } catch (Exception e) {
                System.out.println("Invalid input! Enter again");
                condition = false;
            }
        } while (!condition);
        return num;
    }
}

