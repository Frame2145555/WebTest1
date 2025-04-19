import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/api/genres")
public class GenreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Map<String, String>> genres = new ArrayList<>();

        genres.add(createGenre("Horror", "#8B0000"));
        genres.add(createGenre("Comedy", "#FFD700"));
        genres.add(createGenre("Romance", "#FF69B4"));
        genres.add(createGenre("Action", "#1E90FF"));

        PrintWriter out = response.getWriter();
        out.print(toJson(genres));
        out.flush();
    }

    private Map<String, String> createGenre(String name, String color) {
        Map<String, String> map = new HashMap<>();
        map.put("genre", name);
        map.put("color", color);
        return map;
    }

    private String toJson(List<Map<String, String>> list) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> item = list.get(i);
            json.append("{\"genre\":\"").append(item.get("genre"))
                .append("\",\"color\":\"").append(item.get("color")).append("\"}");
            if (i < list.size() - 1) json.append(",");
        }
        json.append("]");
        return json.toString();
    }
}