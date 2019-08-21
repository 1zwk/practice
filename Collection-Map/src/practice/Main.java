package practice;

import java.util.ArrayList;
import java.util.Random;
import static java.util.Collections.swap;

public class Main {
    public static void main(String[] args) {
        ArrayList<PokeCard> cards = new ArrayList<>(52);
        String[] colour = new String[]{"红桃", "黑桃", "方块", "梅花"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                PokeCard card = new PokeCard(j, colour[i]);
                cards.add(card);
            }
        }

        Random random = new Random(2);
        for (int i = 51; i > 0; i--) {
            int j = random.nextInt(i);
            swap(cards, i, j);
        }


    }
}

