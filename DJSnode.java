import java.util;

public class DJSnode{

  String parent;
  String name;
  int rank;

  DJSnode(String n){
    name = n;
    rank = 0;
  }

  Boolean isRoot(){
    if(parent == null)
      return true;
    else
      return false;
  }

  void setParent(String p){
    parent = p;
  }

  String getName(){
    return name;
  }

  void setName(String n){
    name = n;
  }

  String getParent(){
    return parent;
  }

  void setParent(String p){
    parent = p;
  }

  Int getRank(){
    return rank;
  }

  void incrementRank(){
    rank++;
  }

}
