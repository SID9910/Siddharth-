import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static Node construct(int[] arr) {
    Stack<Node> st = new Stack<>();
    Node root = new Node();
    for(int val:arr){
      if(val!=-1){
        Node t = new Node();
        t.data=val;
        st.push(t);
      }else{
        Node temp =st.pop();
        if(st.size()>0){
          Node parent =st.peek();
          parent.children.add(temp);
        }else{
          root=temp;
        }
      }
      

      }
      return root;
    }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
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
    Construct(root);
  }

}


































