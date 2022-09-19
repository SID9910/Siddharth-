import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn  = new Scanner(System.in);
    int n1 =scn.nextInt();
    int m1 =scn.nextInt();
    int[][] mat1 =new int[n1][m1];
    for(int i=0;i<n1;i++){
        for(int j=0;j<m1;j++){
            mat1[i][j]=scn.nextInt();
        }
    }
    //
     int n2 =scn.nextInt();
    int m2 =scn.nextInt();
    int[][] mat2 =new int[n2][m2];
    for(int i=0;i<n2;i++){
        for(int j=0;j<m2;j++){
            mat2[i][j]=scn.nextInt();
        }
    }

    if(m1!=n2){
        System.out.println("Invalid input");
            return;
            }

    int[][] mat3 = new int[n1][m2];
    for(int i=0;i<mat3.length;i++){
        for(int j=0;j<mat3[0].length;j++){
            int res =0;
            for(int k=0;k<m1;k++){
               res+=mat1[i][k]*mat2[k][j];
               mat3[i][j]=res;
            }
        }
    }

    for(int i=0;i<mat3.length;i++){
    for(int j=0;j<mat3[0].length;j++){
     System.out.print(mat3[i][j]+ " ");
    }
    System.out.println();
}


 } 

}