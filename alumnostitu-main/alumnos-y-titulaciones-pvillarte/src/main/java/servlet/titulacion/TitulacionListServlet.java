package servlet.titulacion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alumno;
import models.Titulacion;
import repositories.AlumnoRepository;
import repositories.TitulacionRepository;
import servlet.BaseServlet;

@WebServlet(name="titulacionListServlet", value="/TitulacionList")
public class TitulacionListServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//doNothing()
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		TitulacionRepository repository = new TitulacionRepository();
		List<Titulacion> titulacionList = repository.findAll();
		req.setAttribute("titulaciones", titulacionList);
		redirect(req, resp, "/Titulacion/TitulacionList.jsp");
	}
}
