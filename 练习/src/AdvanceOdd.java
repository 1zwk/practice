
public class AdvanceOdd{
    public static int[] advanceOdd(int[] array){
        int front = 0;
        int back = array.length - 1;
        while(front < back){
            if(front % 2 == 0){
                if(back % 2 == 1){
                  int tmp = array[front];
                   array[front] = array[back];
                   array[back] = tmp;
                   back--;
               }
                front++;
            }
        front++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        AdvanceOdd a = new AdvanceOdd();

    }
}


