/**
 * You are trying to keep track of friend circles. Remember the basic operations: find-set, make-set, and union
 * makeSet = you're making a circle out of one person
 * find = find that person's friend circle, return the rep of that circle
 * union = join two friend circles, everyone becomes friends, rep may or not change
 *
 * You have total freedom over how you wanna implement!
 * That means data structures
 */
import java.util.*;

public class DisjointSets {

  // You want some globals or constructor, determined by which improvements you're implementing
  // using which data structures
  static HashMap<String, DJSnode> DJS = new HashMap<String, DJSnode>();
  static DJSnode newNode;
  static String newString;

  /**
   * Make a set given a person's name
   * @param name
   */
  public static void makeSet(String name) {
    if(DJS.containsKey(name)){
      // if set already exists
    }
    else{
      newNode = new DJSnode(name);
      DJS.put(name, newNode);
    }
  }

  /**
   * Return the rep of the set the name is part of
   * @param name person's name
   * @return representative of that person's set
   */
  public static String find(String name) {
    //name exists
    if(DJS.containsKey(name)){

      newNode = DJS.get(name);

      //if node isn't root
      if(!newNode.isRoot()){
        newString = newNode.getParent();
        newNode.setParent( find(newString) );
      }
      //node is root
      else{
        return newNode.getName();
      }
      return newNode.getName();
    }
    //name doesn't exist
    else{
      newString = "";
      return newString;
    }
  }

  /**
   * Union the set of two people
   * @param name1 first person's name
   * @param name2 second person's name
   */
  public static void union(String name1, String name2) {
    String n1 = name1;
    String n2 = name2;

    n1 = find(name1);
    n2 = find(name2);

    DJSnode node1 = DJS.get(n1);
    DJSnode node2 = DJS.get(n2);

    int rank1 = node1.getRank();
    int rank2 = node2.getRank();

    if(rank1 >= rank2){
      node2.setParent(n1);
      node1.incrementRank();
    }
    else{
      node1.setParent(n2);
      node2.incrementRank();
    }
  }

  public static void main(String[] args) {
    String[] names = {"Tasha", "Rui", "Tenzin", "Liz", "Nev", "Loan", "George"};

    // construct the class
    // play around!
    for(int i=0; i<names.length; i++){
      makeSet(names[i]);
    }

    System.out.println("Each person and hir or her respective representative:");
    for(int i=0; i<names.length; i++){
      System.out.println(names[i] + "'s representative is " + find(names[i]));
    }


    System.out.println("\nUnion of friend circles: ");
    for(int i=1; i<names.length; i++){
      union(names[0], names[i]);
      System.out.println("Union of " + names[0] + "'s and " + names[i] + "'s friend circles");
    }

    System.out.println("\nEach person and his or her respective representative:");
    for(int i=0; i<names.length; i++){
      System.out.println(names[i] + "'s representative is " + find(names[i]) );
    }

  }
}
