package repository;
import models.Tips;
import connection.*;

import java.util.*;
import java.sql.*;

public class TipsRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Tips> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Tips> tipsList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from champion_tips");
            rs = statement.executeQuery();

            TipsRepository tipsRepo = new TipsRepository();

            while (rs.next()) {
                Tips t = new Tips();
                t.setId(rs.getInt("id"));
                t.setChampion(rs.getInt("champion"));
                t.setTip(rs.getString("tip"));
                tipsList.add(t);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  tipsList;
    }

    public void insertOne(Tips t) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO tips(id, champion, tip) VALUES (?, ?, ?)");
            statement.setInt(1, t.getId());
            statement.setInt(2, t.getChampion());
            statement.setString(3, t.getTip());
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
