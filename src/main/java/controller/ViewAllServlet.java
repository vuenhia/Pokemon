package controller;

import comparator.amountComparator;
import comparator.boxComparator;
import comparator.cardNameComparator;
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
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ViewAllServlet", urlPatterns = "/ViewAll")
public class ViewAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            final PokemonDao pokemonDao = new PokemonDaoImpl();
            final List<Pokemon> pokemonList = pokemonDao.retrievePokemon();

            String sortType = request.getParameter("sortType");
            if(null != sortType && sortType.equals("boxName")) {
                Collections.sort(pokemonList, new boxComparator());
            } else if(null != sortType && sortType.equals("cardName")) {
                Collections.sort(pokemonList, new cardNameComparator());
            } else if(null != sortType && sortType.equals("amount")) {
                Collections.sort(pokemonList, new amountComparator());
            }



            request.setAttribute("pokemonList", pokemonList);
        } catch (PokemonDaoException e) {
            throw new RuntimeException(e);
        }

        getServletContext().getRequestDispatcher("/view-all.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
