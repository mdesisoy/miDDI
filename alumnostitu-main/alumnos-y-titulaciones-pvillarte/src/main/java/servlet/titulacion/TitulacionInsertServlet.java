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
import models.Alumno;
import models.Titulacion;
import repositories.AlumnoRepository;
import repositories.TitulacionRepository;
import servlet.BaseServlet;

@WebServlet(name="titulacionInsertServlet", value="/TitulacionInsert")
public class TitulacionInsertServlet extends BaseServlet{
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
		String titulo = req.getParameter("titulo");
		Titulacion t = new Titulacion(0, titulo);
		repository.insertOne(t);
		redirect(req, resp, "/Titulacion/TitulacionList.jsp");
	}
}