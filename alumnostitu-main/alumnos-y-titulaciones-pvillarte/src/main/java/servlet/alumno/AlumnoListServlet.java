package servlet.alumno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alumno;
import repositories.AlumnoRepository;
import servlet.BaseServlet;

import java.io.IOException;
import java.util.List;

@WebServlet(name="alumnoListServlet", value="/AlumnoList")
public class AlumnoListServlet extends BaseServlet {
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
		List<Alumno> alumnoList = repository.findAll();
		req.setAttribute("alumnos", alumnoList);
		redirect(req, resp, "/Alumno/AlumnoList.jsp");
	}
}
