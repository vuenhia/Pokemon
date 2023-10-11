package utility;

import model.Pokemon;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkbookUtility {
    public final static String INPUT_FILE = "assets\\PokemonCards.xlsx";

    public static List<Pokemon> retrieveCard(final File inputFile) throws IOException, InvalidFormatException {
        final List<Pokemon> pokemonList = new ArrayList<>();
        final Workbook workbook = WorkbookFactory.create(inputFile);
        final Sheet sheet = workbook.getSheetAt(0);

        for (final Row row : sheet) {
            final Cell boxNameCell = row.getCell(0);
            final Cell cardNameCell = row.getCell(1);
            final Cell amountCell = row.getCell(2);

            final Pokemon pokemon = new Pokemon(boxNameCell.getStringCellValue().trim(), cardNameCell.getStringCellValue().trim(), (int) amountCell.getNumericCellValue());
            pokemonList.add(pokemon);
        }
        return pokemonList;
    }
}
