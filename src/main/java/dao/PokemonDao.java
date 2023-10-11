package dao;

import model.Pokemon;

import java.util.List;

public interface PokemonDao {
    void populate(String filePath) throws PokemonDaoException;
    List<Pokemon> retrievePokemon() throws PokemonDaoException;
    void insertPokemon(Pokemon pokemon) throws PokemonDaoException;
}
