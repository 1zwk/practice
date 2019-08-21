import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给一组数据，让其中任意三个数组成一个三角形，求能组成的最大三角形周长
 * <p>
 * 思路：满足三角形的必要条件是 A+B>C , 因为是求最大周长，所以把整个数组从大到小排序，开始遍历，
 * 当满足 A+B>C 的时候，返回即可。
 */
public class TriangleMaxPerimeter {

    public static int solution(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i > 0; i--){
            if(A[i] + A[i+1] > A[i+2]){
                return A[i] + A[i+1] + A[i+2];
            }
        }
        return -1;
    }




    public static void main(String[] args) {
        int[] array = new int[]{2, 4,56,7,8,99,4,53,424,54,354,5};
        System.out.println(solution(array));
    }

}
