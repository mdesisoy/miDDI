package servlet.Abilities;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Abilities;
import repository.AbilitiesRepository;
import servlet.BaseServlet;

import java.io.IOException;
import java.util.List;

@WebServlet(name="abilitiesList", value="/abilitiesList")
public class AbilitiesList extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//doNothing()
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		AbilitiesRepository repository = new AbilitiesRepository();
		List<Abilities> abilitiesList = repository.findAll();
		req.setAttribute("abilities", abilitiesList);
		redirect(req, resp, "/abilities/abilitiesList.jsp");
	}
}
