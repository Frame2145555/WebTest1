package servlets;

import com.google.gson.Gson;
import models.Movie;
import models.MovieDTO;
import moviedata.MovieDataAction;
import moviedata.MovieDataComedy;
import moviedata.MovieDataHorror;
import moviedata.MovieDataRomance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/api/movies")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        String genreParam = req.getParameter("genre");
        List<Movie> movies = new ArrayList<>();

        if (genreParam != null && !genreParam.isEmpty()) {
            switch (genreParam.toLowerCase()) {
                case "horror":
                    movies = new MovieDataHorror().getMovies();
                    break;
                case "comedy":
                    movies = new MovieDataComedy().getMovies();
                    break;
                case "romance":
                    movies = new MovieDataRomance().getMovies();
                    break;
                case "action":
                    movies = new MovieDataAction().getMovies();
                    break;
                default:
                    break;
            }
        }

        List<MovieDTO> movieDTOs = movies.stream()
                .map(m -> new MovieDTO(m.getTitle(), m.getHexCode(), m.getDescription()))
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
