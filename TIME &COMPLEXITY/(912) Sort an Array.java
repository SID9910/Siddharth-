class Solution {
  
    //merge sort 
 public int[] sortArray(int[] nums) {
     int [] arr =mergesort(nums, 0, nums.length-1);
     return arr;
    }
	
    public int[] mergesort(int[] nums, int left, int right){
        if(left ==right){
            int[] base = new int[1];
            base[0] =nums[left];
            return base;
        }
        
            int mid = (left + right) / 2;
        int[] leftsorted =mergesort(nums, left, mid);
        
        int[] rightsorted =mergesort(nums, mid+1, right);
       int[] sorted=merge( leftsorted, rightsorted);
        return sorted;
        
    }
    
    public int[] merge(int[] a,int[] b){
    int i=0,  j= 0, k=0;
    int[] temp = new int[a.length+b.length];
    while( i<a.length && j<b.length)
    {
        if (a[i] <= b[j]){
            temp[k] = a[i];
        i++;
        k++;}
        else{
            temp[k] = b[j];
        j++;
        k++;
        }
    }
    while (i <a.length) { temp[k] = a[i];
                        k++;
                         i++;
                        }
    while (j <b.length) { temp[k] = b[j];
                        j++;
                        k++;
                        }
        return temp;
    
  }


}
  
  
    //insertion sort not working here 
    //selection sort tle
//     public int[] sortArray(int[] nums) {
    
//         for(int i =0;i<nums.length-1;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 int minimum=i;
//                 if(nums[j]<nums[minimum]){
//                     int temp = nums[j];
//                     nums[j]=nums[minimum];
//                     nums[minimum]=temp;
//                 }
                
//             }
//         }
//         return nums;
        
        
        
//     }
    
    
// }
    
    //bubble sort shows tle
//     public int[] sortArray(int[] nums) {
//      for(int itr=1;itr<=nums.length-1;itr++){
//          for(int j=0;j<nums.length-itr;j++){
//              if(nums[j]>nums[j+1]){
//                  int temp = nums[j];
//                  nums[j]=nums[j+1];
//                  nums[j+1]=temp;
//              }
//          }
//      }    
    
//     return nums;
//     }
// }