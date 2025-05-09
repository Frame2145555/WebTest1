package servlets;

import com.google.gson.Gson;
import models.Movie;
import moviedata.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/movies")
public class MovieServlet extends HttpServlet {
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String genre = request.getParameter("genre");
        if (genre == null || genre.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing 'genre' parameter");
            return;
        }

        MovieData movieData;
        switch (genre.toLowerCase()) {
            case "horror":
                movieData = new MovieDataHorror();
                break;
            case "comedy":
                movieData = new MovieDataComedy();
                break;
            case "romance":
                movieData = new MovieDataRomance();
                break;
            case "action":
                movieData = new MovieDataAction();
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid genre");
                return;
        }

        List<Movie> movies = movieData.getMovies();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(movies));
    }
}