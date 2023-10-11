package comparator;

import model.Pokemon;

import java.util.Comparator;

public class boxComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon o1, Pokemon o2) {
        return o1.getBoxName().compareTo(o2.getBoxName());
    }
}
