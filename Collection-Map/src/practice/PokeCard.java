package practice;

public class PokeCard{
    private int val;
    private String colour;

    public PokeCard(int val, String colour){
        this.val = val;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return String.format("[" + val + "," + colour + "]" );
    }


}
