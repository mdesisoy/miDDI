package servlet.alumno;

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
import repositories.AlumnoRepository;
import servlet.BaseServlet;

@WebServlet(name="alumnoUpdateServlet", value="/AlumnoUpdate")
public class AlumnoUpdateServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doYourOtherThing(req, resp);
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		AlumnoRepository repository = new AlumnoRepository();
		Integer id = Integer.parseInt(req.getParameter("id"));
		Integer titulacion = Integer.parseInt(req.getParameter("titulacion"));
		repository.updateTitulacion(id, titulacion);
		redirect(req, resp, "/Alumno/AlumnoUpdate.jsp");
	}

	private void doYourOtherThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer idAlumno = Integer.parseInt(req.getParameter("idAlumno"));
		Integer idTitulacion = Integer.parseInt(req.getParameter("idTitulacion"));
		req.setAttribute("id", idAlumno);
		req.setAttribute("titulacion", idTitulacion);
		redirect(req, resp, "/Alumno/AlumnoUpdate.jsp");
	}
}