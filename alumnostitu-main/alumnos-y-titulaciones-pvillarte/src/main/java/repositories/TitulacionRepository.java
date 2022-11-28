package repositories;
import models.Alumno;
import models.Titulacion;
import connection.*;
import java.util.*;
import java.sql.*;


public class TitulacionRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Titulacion> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Titulacion> titulacionList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from titulacion");
            rs = statement.executeQuery();

            while (rs.next()) {
                Titulacion t = new Titulacion();
                t.setId(rs.getInt("id"));
                t.setTitulo(rs.getString("titulo"));
                titulacionList.add(t);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  titulacionList;
    }

    public Titulacion findById(int idTitu){
        Connection conn = manager.open();
        PreparedStatement statement = null;
        Titulacion titulacion = new Titulacion();
        ResultSet rs = null;
        try{
            statement = conn.prepareStatement("select * from titulacion where id=?");
            statement.setInt(1, idTitu);
            rs= statement.executeQuery();
            while (rs.next()) {
                titulacion.setId(rs.getInt("id"));
                titulacion.setTitulo(rs.getString("titulo"));
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  titulacion;
    }

    public void insertOne(Titulacion t) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO titulacion(titulo) VALUES ?");
            statement.setString(1, t.getTitulo());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }

    public void deleteById(int id){
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("delete from alumno where titulacion = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            manager.close(statement);
            statement = conn.prepareStatement("delete from titulacion where id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }
}
