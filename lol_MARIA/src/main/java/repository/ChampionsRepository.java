package repository;
import models.Champions;
import connection.*;

import java.util.*;
import java.sql.*;

public class ChampionsRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Champions> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Champions> championsList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from champions");
            rs = statement.executeQuery();

            ChampionsRepository championsRepo = new ChampionsRepository();

            while (rs.next()) {
                Champions c = new Champions();
                c.setId(rs.getInt("id"));
                c.setChampion_name(rs.getString("champion_name"));
                c.setTitle(rs.getString("title"));
                c.setLore(rs.getString("lore"));
                c.setTags(rs.getString("tags"));
                championsList.add(c);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  championsList;
    }

    public void insertOne(Champions c) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO champions(id, champion_name, title, lore, tags) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, c.getId());
            statement.setString(2, c.getChampion_name());
            statement.setString(3, c.getTitle());
            statement.setString(3, c.getLore());
            statement.setString(3, c.getTags());
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
