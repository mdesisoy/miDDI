package servlet.alumno;

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

@WebServlet(name="alumnoInsertServlet", value="/AlumnoInsert")
public class AlumnoInsertServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//doNothing()
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		AlumnoRepository repository = new AlumnoRepository();
		TitulacionRepository tituRepo = new TitulacionRepository();

		String nombre = req.getParameter("nombre");
		Integer edad = Integer.parseInt(req.getParameter("edad"));
		Integer tituId = Integer.parseInt(req.getParameter("titulacion"));

		Alumno a = new Alumno();
		a.setNombre(nombre);
		a.setEdad(edad);
		a.setTitulacion(tituRepo.findById(tituId));
		
		repository.insertOne(a);
		req.setAttribute("titulaciones", tituRepo.findAll());
		redirect(req, resp, "/Alumno/AlumnoList.jsp");
	}
}
