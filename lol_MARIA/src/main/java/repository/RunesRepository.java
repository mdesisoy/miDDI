package repository;
import models.Runes;
import connection.*;

import java.util.*;
import java.sql.*;

public class RunesRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Runes> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Runes> runesList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from runes");
            rs = statement.executeQuery();

            RunesRepository runesRepo = new RunesRepository();

            while (rs.next()) {
                Runes r = new Runes();
                r.setId(rs.getInt("id"));
                r.setTier(rs.getInt("tier"));
                r.setRune_name(rs.getString("rune_name"));
                r.setRune_description(rs.getString("rune_description"));
                runesList.add(r);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  runesList;
    }

    public void insertOne(Runes r) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO runes(id, tier, rune_name, rune_description) VALUES (?, ?, ?, ?)");
            statement.setInt(1, r.getId());
            statement.setInt(2, r.getTier());
            statement.setString(3, r.getRune_name());
            statement.setString(4, r.getRune_description());
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
