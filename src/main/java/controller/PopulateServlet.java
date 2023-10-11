package controller;

import dao.PokemonDao;
import dao.PokemonDaoException;
import dao.PokemonDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utility.WorkbookUtility;

import java.io.IOException;

@WebServlet(name = "PopulateServlet", urlPatterns = "/Populate")
public class PopulateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String filePath = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
        final PokemonDao pokemonDao = new PokemonDaoImpl();


        String message = "";


        try {
            pokemonDao.populate(filePath);
            message = "The database was successfully populated";

        } catch (PokemonDaoException e) {
            e.printStackTrace();
            message = "There was an error. The database was not populated";

        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/populate.jsp").forward(request, response);
    }
}
