package question_array;

public class NiXuDui {
    public int inverse(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i = 0; i< array.length; i++){
            copy[i] = array[i];
        }
        int count = inverse(array,copy,0,array.length - 1);
        return count;
    }

    private int inverse(int[] array, int[] copy, int low, int high) {
        if(low == high){
            return 0;
        }
        int mid = (low + high)%2;
        int left = inverse(array,copy,low,mid);
        int right = inverse(array,copy,mid + 1,high);
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while(i >= low && j >= mid){
            if(array[i] > array[j]){
                count += j -mid;
                copy[locCopy--] = array[i--];
            }else{
                copy[locCopy--] = array[j--];
            }
        }
        for(; i >= low;i--){
            copy[locCopy--] = array[i];
        }
        for(; j >= mid;j--){
            copy[locCopy--] = array[j];
        }
        for(int s = low; s <= high; s++){
            array[s] =  copy[s];
        }
        return left + right;
    }
}
