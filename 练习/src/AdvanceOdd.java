public class AdvanceOdd{
    public int[] advanceOdd(int[] array){
        int front = 0;
        int back = array.length - 1;
        while(front < back){
            if(front % 2 == 0){
               if(back % 2 == 1){
                   int tmp = array[front];
                   array[front] = array[back];
                   array[back] = tmp;
               }
            }
            front++;
            back--;
        }
        return array;
    }
}


