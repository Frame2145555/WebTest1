package servlets;

import com.google.gson.Gson;

import models.Movie;
import moviedata.MovieData;
import moviedata.MovieDataHorror;
import moviedata.MovieDataComedy;
import moviedata.MovieDataRomance;
import moviedata.MovieDataAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/movieDetail")
public class MovieDetailServlet extends HttpServlet {
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String genre = request.getParameter("genre");
        String title = request.getParameter("title");

        if (genre == null || title == null || genre.isEmpty() || title.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing 'genre' or 'title' parameter");
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

        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.print(gson.toJson(movie));
                return;
            }
        }

        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Movie not found");
    }
}
