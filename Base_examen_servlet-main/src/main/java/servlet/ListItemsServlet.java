package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;



import model.Champions;
import model.Items;
import repository.ChampionRepository;
import repository.ItemsRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/listItems")
public class ListItemsServlet extends BaseServlet{

	ItemsRepository repository = new ItemsRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Items> items = repository.listAll();
		req.setAttribute("lista", items);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listItems.jsp");
		dispatcher.forward(req, resp);
	}

}
