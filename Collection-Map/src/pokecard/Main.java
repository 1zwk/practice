package pokecard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
    //交换牌方法
    public static void swap(ArrayList<PokeCard> cards, int i, int j) {
        PokeCard temp1 = cards.get(i);
        PokeCard temp2 = cards.get(j);
        cards.set(i, temp2);
        cards.set(j, temp1);

    }

    public static void main(String[] args) {
        //创建牌盒
        ArrayList<PokeCard> cards = new ArrayList<>(52);
        String[] colour = new String[]{"红桃", "黑桃", "方块", "梅花"};
        //给牌盒里面放牌
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                PokeCard card = new PokeCard(j, colour[i]);
                cards.add(card);
            }
        }

        //洗牌
        Random random = new Random(20);
        for (int i = 51; i > 0; i--) {
            int j = random.nextInt(i);
            swap(cards, i, j);
        }
        System.out.println(cards);

        //给三个玩家发牌
        ArrayList<PokeCard> A = new ArrayList<>();
        ArrayList<PokeCard> B = new ArrayList<>();
        ArrayList<PokeCard> C = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            PokeCard card = cards.remove(cards.size() - 1);
            switch (i % 3) {
                case 0:
                    A.add(card);
                    break;
                case 1:
                    B.add(card);
                    break;
                case 2:
                    C.add(card);
                    break;
            }
        }
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);

        //判断A牌中是否有黑桃1,
        PokeCard heard1 = new PokeCard(0, "黑桃");
        //如果是自定义的类，判断两个对象是否相等的方法，需要覆写equals方法；
        for (PokeCard card : A) {
            if (card.equals(heard1)) {
                System.out.println("包含");
            }
        }
        //ArrayList 类，判断列表中是否包含某个对象，直接使用equals方法。
        if (A.equals(heard1)) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }

        //迭代器
        Iterator<PokeCard> it = A.iterator();
        while (it.hasNext()) {
            PokeCard o = it.next();
            if (o.equals(heard1)){
                it.remove();
            }
        }
        System.out.println(A);

    }
}
