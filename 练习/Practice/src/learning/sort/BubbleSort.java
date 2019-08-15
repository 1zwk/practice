package learning.sort;
/*
*
**冒泡排序
*
*/

public class BubbleSort {
	public static void main(String[] args) {
		 int[] array = new int[] {1,2000,-3,299,-49,27,5};
		  
		  for(int i = 0; i < array.length - 1; i++) {
			  for(int j = 0; j < array.length - 1 - i; j++) {
				  if(array[j] > array[j+1]) {
					  int temp = array[j];
					  array[j] = array[j+1];
					  array[j+1] = temp;					  
				  }
			  }
		  }	
		  for(int i = 0; i < array.length; i++) {
			  System.out.print(array[i] + " ");
		  }
		 
	}	   
}
    
    

