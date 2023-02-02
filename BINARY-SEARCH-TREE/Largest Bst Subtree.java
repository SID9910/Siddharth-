import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  public static class isbst{
    boolean binarytree;
    int max;
    int min;
    Node root;
    int size;
  }
  public static isbst binary(Node node){
    if(node ==null){
      isbst bp = new isbst();
      bp.binarytree=true;
      bp.max=Integer.MIN_VALUE;
      bp.min=Integer.MAX_VALUE;
      return bp;
    }

    isbst left =binary(node.left);
    isbst right =binary(node.right);
    isbst mp= new isbst();
    mp.binarytree =left.binarytree && right.binarytree &&(node.data>=left.max && node.data<=right.min);
    mp.max =Math.max(node.data ,Math.max(left.max ,right.max));
    mp.min =Math.min(node.data ,Math.min(left.min ,right.min));

    if(mp.binarytree==true){
      mp.root =node;
      mp.size=left.size+right.size+1;
    }else if(left.size>right.size)
    {
      mp.root=left.root;
      mp.size=left.size;
    }else{
      mp.root =right.root;
      mp.size =right.size;
    }
    return mp;

  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    isbst b = binary(root);
    System.out.println(b.root.data+"@"+b.size);
  }

}