package question_array;
import java.util.*;
/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 * 思路：
 * 这题应该是用快排的思想：例如找49个元素里面第24大的元素，那么按如下步骤： 1.进行一次快排（将大的
 * 元素放在前半段，小的元素放在后半段）,假设得到的中轴为p 2.判断 p - low + 1 == k ，如果成立，直接输出
 * a[p]，（因为前半段有k - 1个大于a[p]的元素，故a[p]为第K大的元素） 3.如果 p - low + 1 > k， 则第k大的元
 * 素在前半段，此时更新high = p - 1，继续进行步骤1 4.如果p - low + 1 < k， 则第k大的元素在后半段， 此时
 * 更新low = p + 1, 且 k = k - (p - low + 1)，继续步骤1. 由于常规快排要得到整体有序的数组，而此方法每次可
 * 以去掉“一半”的元素，故实际的复杂度不是o(nlgn), 而是o(n)
 */

public class FindKthByQuickSort {
    public int findKth(int[] array, int k){
        return findKth(array,0,array.length - 1,k);
    }

    public int findKth(int[] array,int low, int high, int k ){
        int part = partation(array,low, high);
        if(part - low + 1 == k){
            return array[part];
        }else if(part - low + 1 > k){
            return findKth(array, low, part - 1,k);
        }else{
            return findKth(array, part + 1, high, k - part + low - 1);//k在后半段，要找的k应该变为原来的k减去前半段。
        }
    }

    private int partation(int[] array, int low, int high) {
        int key = array[high];
        while(low < high ){               //把符号改变，形成逆序。
            while(low < high && array[low] >= key){//一定记得比较的是key数字不是array【key】

                low++;
            }
            array[high] = array[low];
            while(low < high && array[high] <= key){
                high--;
            }
            array[low] = array[high];
        }
        array[low] = key;
        return low;
    }

    public static void main(String[] args) {
        int[] array = {3,45,2,452,5,123,34,123,22,1,3};
        FindKthByQuickSort f = new FindKthByQuickSort();
        int k = f.findKth(array,3);
        System.out.println(k);
    }

}
