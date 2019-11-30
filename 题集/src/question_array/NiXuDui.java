package question_array;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/bb06495cc0154e90bbb18911fd581df6
 * 来源：牛客网
 *
 * 有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。请设计一个高效的算法，计算给定数组中的逆序对个数。
 *
 * 给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000。
 *
 * 测试样例：
 * [1,2,3,4,5,6,7,0],8
 * 返回：7
 */
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
