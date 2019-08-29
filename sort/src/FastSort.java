public class FastSort {
    public static void fastSort(int[] array) {

    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        int great = right;
        while (less < right) {
            while (less < right && array[less] < pivot) {
                less++;
            }
            while (less < right && array[great] < pivot) {
                great++;
            }
            swap(array, less, great);
        }
        swap(array, less, right);
        return -1;
    }

    private static void swap(int[] array, int less, int great) {
        int tmp = array[less];
        array[less] = array[great];
        array[great] = tmp;
    }

    private static int partition2(int[] array, int right, int left) {
        int pivot = array[right];
        int less = left;
        int great = right;
        while (less < right) {
            while (less < right && array[less] < pivot) {
                less++;
            }
            array[great] = array[less];
            while (less < right && array[right] > pivot) {
                right++;
            }
            array[less] = array[great];
        }
        return less;
    }

    private static int partition3(int[] array, int right, int left) {
        int pivot = array[right];
        int less = left;
        //[left,less)< pivot;
        //[less, i) >= piovt;
        //[i, right)  ?
        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                swap(array, less, i);
                less++;
            }
        }
        swap(array,less,right);
        return less;
    }
}
