package question_array;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46
 * 来源：牛客网
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class CreateMultArray {
    /**
     * 思路：可以把b[i] = a[0]*a[1]....a[i-1]*a[i+1]...a[n-2]*a[n-1]分为两半，
     *       前半部分为b[i] = a[0]*[a1}..a[i-1]，就相当于b[i] = b[i-1]*a[i-1],
     *       后半部分b[i]  = a[i+1]*....a[n-2]*a[n-1] ，就相当于b[i] = b[i+1]*a[i+1]
     */
    public int[] mult(int[] a){
        if(a == null && a.length < 1){
            return null;
        }
        int[] b = new int[a.length];
        b[0] = 1;
        //计算前半部分，从前向后
        for(int i=1; i<b.length; i++){
            b[i] = b[i-1]*a[i-1];
        }
        //计算后半部分相加,从后向前（因为从i+1开始的话，i的值是不能确定的，无法处理）
        int temp = 1;
        for(int i = a.length-2; i >= 0; i--){
            temp = temp * a[i+1];
            b[i] *= temp;
        }
        return b;
    }
}
