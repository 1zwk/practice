package pokecard;

public class PokeCard {
    private int val;
    private String colour;

    public PokeCard(int val, String colour) {
        this.val = val;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return String.format("[" + val + "," + colour + "]");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PokeCard)) {
            return false;
        }
        PokeCard other = (PokeCard) obj;
        return this.val == other.val
                && this.colour.equals(other.colour);
    }
}
