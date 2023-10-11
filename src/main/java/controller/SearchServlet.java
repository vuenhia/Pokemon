package controller;

import dao.PokemonDao;
import dao.PokemonDaoException;
import dao.PokemonDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Pokemon;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utility.WorkbookUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SearchServlet", urlPatterns = "/Search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            final PokemonDao pokemonDao = new PokemonDaoImpl();
            final List<Pokemon> pokemonList = pokemonDao.retrievePokemon();
            String boxName = request.getParameter("boxName");
            String cardName = request.getParameter("cardName");

            final List<Pokemon> boxFilter = pokemonList.stream()
                            .filter((Pokemon pokemons) -> pokemons.getBoxName().equalsIgnoreCase(boxName))
                            .collect(Collectors.toList());
            
            final List<Pokemon> nameFilter = pokemonList.stream()
                            .filter((Pokemon pokemons) -> pokemons.getCardName().equalsIgnoreCase(cardName))
                            .collect(Collectors.toList());



            request.setAttribute("pokemonList", boxFilter);
            request.setAttribute("pokemonList", nameFilter);


            getServletContext().getRequestDispatcher("/view-all.jsp").forward(request,response);

        }  catch (PokemonDaoException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
