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
    
//parent ,child
public static void levelOrder1(Node node){
  Queue<Node> que = new ArrayDeque<>();
  Queue<Node> cque = new ArrayDeque<>();
  que.add(node);
  while(que.size()>0){
    Node temp =que.remove();
    System.out.print(temp.data+" ");
    if(temp.left!=null){
      cque.add(temp.left);
    }
    if(temp.right!=null){
      cque.add(temp.right);
    }
    if(que.size()==0){
      que=cque;
      cque =new ArrayDeque<>();
      System.out.println();
    }
  }
}
//count approach
public static void levelOrder2(Node node){
  Queue<Node> que = new ArrayDeque<>();
  que.add(node);
  while(que.size()>0){
int size =que.size();
for(int i=0;i<size;i++){
      Node temp =que.remove();
    System.out.print(temp.data+ " ");
    if(temp.left!=null){
      que.add(temp.left);
    }
    if(temp.right!=null){
      que.add(temp.right);
    }
}  
System.out.println();   
  }

}
//delimeter
public static void levelOrder3(Node node){
  Queue<Node> que = new ArrayDeque<>();
  Node dumy=new Node(-1,null,null);
  que.add(node);
  que.add(dumy);
  while(que.size()>0){
    Node temp =que.remove();
    if(temp!=dumy){
      System.out.print(temp.data+ " ");
      if(temp.left!=null){
      que.add(temp.left);
      }
      if(temp.right!=null){
        que.add(temp.right);
      }

    }else{
      System.out.println();
      if(que.size()>0){
        que.add(temp);
      }
      continue;
    }
  }
}

//isme aagr arrayDeque ki jagah linkedlist looge to usme null se kaam ho jaega dumy banana nhi padega
  public static void levelOrder4(Node node) {
     Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null); //har node ke baad null daal  o
        
        while(queue.size()>0){
          Node temp =queue.remove();
          if(temp!=null){
              System.out.print(temp.data + " ");
              if(temp.left!=null){
                  queue.add(temp.left);
              }
              if(temp.right !=null){
                  queue.add(temp.right);
              }
          }
          //jaise he temp null encounter hua us time he new line kardo and null daal do
          else {
              if(queue.size()>0){
                  System.out.println();
                  queue.add(null);
                  
              }
          }

        }
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
    levelOrder1(root);
     levelOrder2(root);
      levelOrder3(root);
       levelOrder4(root);
  }

}