package servlets;

import com.google.gson.Gson;
import genres.*;
import models.Movie;
import models.MovieDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/api/movies")
public class MovieServlet extends HttpServlet {

    private final List<Movie> movies = Arrays.asList(
            new Movie("The Conjuring", new Horror()),
            new Movie("Insidious", new Horror()),
            new Movie("Hereditary", new Horror()),
            new Movie("Superbad", new Comedy()),
            new Movie("21 Jump Street", new Comedy()),
            new Movie("The Hangover", new Comedy()),
            new Movie("Dumb and Dumber", new Comedy()),
            new Movie("Anchorman", new Comedy()),
            new Movie("The Notebook", new Romance()),
            new Movie("Titanic", new Romance()),
            new Movie("Avengers", new Action())
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String genreParam = req.getParameter("genre");
            List<Movie> filtered = movies;

            if (genreParam != null && !genreParam.isEmpty()) {
                filtered = movies.stream()
                        .filter(m -> m.getGenre().getClass().getSimpleName().equalsIgnoreCase(genreParam))
                        .collect(Collectors.toList());
            }

            List<MovieDTO> movieDTOs = filtered.stream()
                    .map(m -> new MovieDTO(m.getTitle(), m.getHexCode()))
                    .collect(Collectors.toList());

            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(new Gson().toJson(movieDTOs));
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
