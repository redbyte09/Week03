package com.linaerandbinary;
//import
import java.util.Arrays;
import java.util.Random;
//make method here
public class LinerSearchAndBinarySearch {
    public int[] randomArray(int n){
        //random object
        Random random=new Random();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            //generate random array
            arr[i]=random.nextInt(n);
        }
        return arr;
    }
    //perform linear Search here
    public void linerSearch(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) {
                System.out.println("element found at index" + i);
                return;
            }
        }
        System.out.println("element not found");
        return;
    }

     //perform binary search here
    public void binarySearch(int[] arr,int target){

        Arrays.sort(arr);
       int li=0;
       int hi=arr.length-1;
       int mid=(li+hi)/2;
       while(li<=hi){
           if(arr[mid]==target){
               System.out.println("elemnt found at index"+mid);
               break;
           }
           else if(arr[mid]<target){
               li=mid+1;
           }
           else{
              hi=mid-1;
           }
           mid=(li+hi)/2;
       }
    }
}
