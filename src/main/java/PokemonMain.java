import model.Pokemon;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utility.WorkbookUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PokemonMain {
    public final static String INPUT_FILE = "src\\main\\webapp\\assets\\PokemonCards.xlsx";
    public static void main(String[] args) {
        final File inputFile = new File(INPUT_FILE);

        try {
            final List<Pokemon> pokemonList = WorkbookUtility.retrieveCard(inputFile);
            for(final Pokemon pokemon: pokemonList){
                System.out.println(pokemon);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

    }
}
