public class ReverseApp{
   public static void main(String[] args) {
      Person[] listOfPeople = new Person[10];
      listOfPeople[0] = new Person("Hung", 18, true);
      listOfPeople[1] = new Person("Thu", 19, false);
      listOfPeople[2] = new Person("Duy", 19, true);
      listOfPeople[3] = new Person("Hien", 18, false);
      listOfPeople[4] = new Person("Thach", 30, true);
      listOfPeople[5] = new Person("Hoa", 40, false);
      System.out.println("Before reverse:");
      displayList(listOfPeople);

      System.out.println("Atfer reverse:");
      reverseList(listOfPeople);
      displayList(listOfPeople);

   }

   /**
    * reverse all object in the list using stack
    * @param list
    */
   static void reverseList(Object[] list){
      StackClass stack = new StackClass(list.length); //initialize a stack with the same size of list
      for (int i = 0; i < list.length; i++) { //add object to the stack.
         if(list[i]==null) break; //break when added all object
         else
            stack.push(list[i]);
      }
      for (int i = 0; i < list.length; i++) {
         if(!stack.isEmpty()){ //break when no object in the stack
            list[i] = stack.pop(); //push back to the list
         }
         else break;
      }
   }

   /**
    * print out all object in the list
    * @param list
    */
   static void displayList(Object[] list){
      System.out.println("\tThe list: ");
      for (int i = 0; i < list.length; i++) {
         if(list[i]==null) return; //loop until the pointer point to "null"
         else System.out.println(list[i]);
      }
   }
}
