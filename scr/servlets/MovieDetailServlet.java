package servlets;

import com.google.gson.Gson;
import models.*;
import moviedata.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

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

        Movie movie = movieData.getMovies(title);

        if (movie != null) {
            MovieResponse movieResponse = new MovieResponse(
                movie.getTitle(),
                movie.getDescription(),
                movie.getGenre().getHexColor()
            );
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(movieResponse));
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Movie not found");
        }
    }
}