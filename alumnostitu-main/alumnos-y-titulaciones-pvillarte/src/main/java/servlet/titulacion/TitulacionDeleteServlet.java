package servlet.titulacion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Titulacion;
import repositories.TitulacionRepository;
import servlet.BaseServlet;

@WebServlet(name="titulacionDeleteServlet", value="/TitulacionDelete")
public class TitulacionDeleteServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doYourOtherThing(req,resp);
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		TitulacionRepository repository = new TitulacionRepository();
		Integer id = Integer.parseInt(req.getParameter("idTitulacion"));
		repository.deleteById(id);
		redirect(req, resp, "/Titulacion/TitulacionList.jsp");
	}

	private void doYourOtherThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String nomTitulacion = req.getParameter("nomTitulacion");
		Integer idTitulacion = Integer.parseInt(req.getParameter("idTitulacion"));
		req.setAttribute("idTitulacion", idTitulacion);
		req.setAttribute("nomTitulacion", nomTitulacion);
		redirect(req, resp, "/Titulacion/TitulacionDelete.jsp");
	}
}
