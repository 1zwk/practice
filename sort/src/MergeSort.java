public class MergeSort {
    private static void merge(int[] array, int low, int high, int mid) {
        int length = high - low;
        int[] extra = new int[length];
//		int min = low;
//		int iextra = 0;
//		for(int i = low + 1 ; i< high; i++){
//			if(array[i] < array[min]){
//				min = i;
//			}
//			extra[iextra++] = array[i];
//		}

    }

    //非递归写法
    private static void mergeNoR(int[] array) {
        for (int i = 1; i < array.length; i = i * 2){ //循环次数是以2 为底的log^array.length
            for(int j = 0; j < array.length; j = j + i * 2){ //
                int low = j;
                int mid = j + i;
                int high = mid + i;
                if(mid > array.length){
                    continue;
                }
                if(high > array.length){
                    high = array.length;
                }

                merge(array, low, mid ,high);
            }
        }
    }
}
