package comparator;

import model.Pokemon;

import java.util.Comparator;

public class amountComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon o1, Pokemon o2) {
        int amount1 = o1.getAmount();
        int amount2 = o2.getAmount();
        return Integer.compare(amount1,amount2);
    }
}
