package repositories;
import models.Alumno;
import connection.*;
import models.Titulacion;

import java.util.*;
import java.sql.*;

public class AlumnoRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Alumno> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Alumno> alumnoList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from alumno");
            rs = statement.executeQuery();

            TitulacionRepository tituRepo = new TitulacionRepository();

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setEdad(rs.getInt("edad"));
                a.setTitulacion(tituRepo.findById(rs.getInt("titulacion")));
                alumnoList.add(a);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  alumnoList;
    }

    public void insertOne(Alumno a) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO alumno(nombre, edad, titulacion) VALUES (?, ?, ?)");
            statement.setString(1, a.getNombre());
            statement.setInt(2, a.getEdad());
            statement.setInt(3, a.getTitulacion().getId());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }

    public void updateTitulacion(int id, int titulacion) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("update alumno set titulacion = ? where id = ?");
            statement.setInt(1, titulacion);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }
    public String calcTitulacionStr(int id){
        TitulacionRepository titulacionRepository = new TitulacionRepository();
        return titulacionRepository.findById(id).getTitulo();
    }
}
