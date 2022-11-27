package servlet;

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

@WebServlet("/welcome")
public class WelComeServlet extends HttpServlet{
private String jdbcUrl = "jdbc:h2:file:./src/main/resources/testdb";


@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String nombre = req.getParameter("nombre");
	System.out.println(nombre);
	System.out.println(req.getParameter("apellido"));
	System.out.println(req.getParameter("dni"));
	
	Connection conn;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(jdbcUrl , "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		PreparedStatement preparedStatement = null;
		try {
			
			preparedStatement = conn.prepareStatement("CREATE TABLE IF NOT EXISTS USUARIO (nombre VARCHAR(100) )");
			preparedStatement.executeUpdate();
			preparedStatement.close();
			preparedStatement = conn.prepareStatement("INSERT INTO USUARIO VALUES ?");
			preparedStatement.setString(1, nombre);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("IMPRIMIENDO LISTADO");
			preparedStatement = conn.prepareStatement("SELECT * FROM USUARIO");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			ArrayList<String> listNombres = new ArrayList<String>();
			while (resultSet.next()) {
				String string = resultSet.getString(1);
				listNombres.add(string);
				System.out.println(string);
			} 
			req.setAttribute("nombres", listNombres);
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	
	
	
	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/fin.jsp");
	dispatcher.forward(req, resp);
}
}
