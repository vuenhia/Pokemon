package comparator;

import model.Pokemon;

import java.util.Comparator;

public class cardNameComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon o1, Pokemon o2) {
        return o1.getCardName().compareTo(o2.getCardName());
    }
}
