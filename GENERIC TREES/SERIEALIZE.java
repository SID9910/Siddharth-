import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node){
    int max =node.data;
    for(Node child:node.children){
      int childmax =size(child);
      max=Math.max(childmax,max);
    }
    max=Math.max(max,node.data);
    return max;
  }
public static void serielize(Node node , ArrayList<Integer> list){  
  list.add(node.data);
  for(Node child:node.children){
    serielize(child,list);
  }
  list.add(-1);

}
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
   ArrayList<Integer> list =new ArrayList<>();
   serielize(root,list);
   for(int i=0;i<list.size();i++){
     System.out.print(list.get(i)+" ");
   }

    
  }

}