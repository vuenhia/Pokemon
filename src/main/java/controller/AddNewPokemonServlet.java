package controller;

import com.google.common.base.Strings;
import dao.PokemonDao;
import dao.PokemonDaoException;
import dao.PokemonDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Pokemon;

import java.io.IOException;

@WebServlet(name = "AddNewPokemonServlet", value = "/AddNewPokemon")
public class AddNewPokemonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            final String boxName = request.getParameter("boxName");
            final String cardName = request.getParameter("cardName");
            final String amountString = request.getParameter("amount");

            if(Strings.isNullOrEmpty(boxName) || Strings.isNullOrEmpty(cardName) || Strings.isNullOrEmpty(amountString)) {
                request.setAttribute("message", "Please fill out all fields");
            } else {
                final int amount = Integer.parseInt(amountString);
                final PokemonDao pokemonDao = new PokemonDaoImpl();
                final Pokemon pokemon = new Pokemon(boxName,cardName,amount);
                pokemonDao.insertPokemon(pokemon);
                request.setAttribute("message", "Pokemon was added");
            }
        } catch (PokemonDaoException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
        }
        getServletContext().getRequestDispatcher("/add-pokemon.jsp").forward(request,response);
    }
}
