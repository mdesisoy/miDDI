package servlet.Runes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Runes;
import repository.RunesRepository;
import servlet.BaseServlet;

import java.io.IOException;
import java.util.List;

@WebServlet(name="runesSearch", value="/runesSearch")
public class RunesSearch extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
    }
    private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RunesRepository repository = new RunesRepository();
		String name = req.getParameter("rune_name");
        repository.search(name);
		redirect(req, resp, "/runes/runesList.jsp");
	}
	
}
