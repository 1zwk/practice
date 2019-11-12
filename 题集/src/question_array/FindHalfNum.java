package question_array;

import java.util.Arrays;
import java.util.Scanner;

public class FindHalfNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] a = str.split(" ");
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.parseInt(a[i]);
        }
        int result = find(b);
        System.out.println(result);

    }

    private static int find(int[] a) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                temp = a[i];
                count++;
            } else {
                temp = (temp == a[i] ? count++ : count--);
            }
        }
        count = 0;
        for (int i = 0; i < a.length; i++) {
            if (temp == a[i]) {
                count++;
            }
        }
        return count >= (a.length / 2 + 1) ? temp : 0;
    }

}
