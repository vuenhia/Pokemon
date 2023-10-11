package dao;

import model.Pokemon;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utility.DBUtility;
import utility.WorkbookUtility;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDaoImpl implements PokemonDao{
    final static String DROP_TABLE = "drop table if exists pokemon";
    final static String CREATE_TABLE = "create table pokemon (id integer primary key autoincrement, boxName text, cardName text, amount integer);";
    final static String SELECT_ALL_FROM_POKEMON = "select * from pokemon;";
    @Override
    public void populate(String filePath) throws PokemonDaoException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtility.createConnection();
            statement = connection.createStatement();

            statement.executeUpdate(DROP_TABLE);
            statement.executeUpdate(CREATE_TABLE);

            //Populate DB from WB Util
            final File inputFile = new File(filePath);
            final List<Pokemon> pokemonList = WorkbookUtility.retrieveCard(inputFile);

            for(final Pokemon pokemon: pokemonList) {
                final String insertValues = "insert into pokemon (boxName, cardName, amount) " +
                        "values ('" + pokemon.getBoxName() + "', '"
                        + pokemon.getCardName() + "',"
                        + pokemon.getAmount() + ");";


                System.out.println(insertValues);
                statement.executeUpdate(insertValues);
            }



        } catch (SQLException | ClassNotFoundException | InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Pokemon> retrievePokemon() throws PokemonDaoException {
        final List<Pokemon> pokemonList = new ArrayList<Pokemon>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBUtility.createConnection();
            statement = connection.createStatement();

            statement.setQueryTimeout(DBUtility.TIMEOUT);

            final ResultSet results = statement.executeQuery(SELECT_ALL_FROM_POKEMON);

            while(results.next()) {
                final String boxName = results.getString("boxName");
                final String cardName = results.getString("cardName");
                final int amount = results.getInt("amount");

                pokemonList.add(new Pokemon(boxName, cardName, amount));

            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new PokemonDaoException("Error: Unable to retrieve list");
        }

        return pokemonList;
    }

    @Override
    public void insertPokemon(Pokemon pokemon) throws PokemonDaoException {
        Connection connection = null;
        PreparedStatement insertStatement = null;

        try {
            connection = DBUtility.createConnection();
            final String sqlString = "insert into pokemon(boxName, cardName, amount) values (?,?,?);";

            insertStatement = connection.prepareStatement(sqlString);
            insertStatement.setString(1,pokemon.getBoxName());
            insertStatement.setString(2,pokemon.getCardName());
            insertStatement.setInt(3,pokemon.getAmount());

            insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
            insertStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new PokemonDaoException("Error: unable to insert pokemon card");
        }

    }
}
