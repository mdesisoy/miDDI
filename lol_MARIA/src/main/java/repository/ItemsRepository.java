package repository;
import models.Items;
import connection.*;

import java.util.*;
import java.sql.*;

public class ItemsRepository {

    private final AbstractConnection manager = new H2Connection();

    public List<Items> findAll() {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        List<Items> itemsList = new ArrayList<>();
        ResultSet rs = null;

        try{
            statement = conn.prepareStatement("select * from items");
            rs = statement.executeQuery();

            ItemsRepository itemsRepo = new ItemsRepository();

            while (rs.next()) {
                Items i = new Items();
                i.setId(rs.getInt("id"));
                i.setItem_name(rs.getString("item_name"));
                i.setEffect(rs.getString("effect"));
                itemsList.add(i);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            manager.close(rs);
            manager.close(statement);
            manager.close(conn);
        }
        return  itemsList;
    }

    public void insertOne(Items i) {
        Connection conn = manager.open();
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO items(id, item_name, effect) VALUES (?, ?, ?)");
            statement.setInt(1, i.getId());
            statement.setString(2, i.getItem_name());
            statement.setString(3, i.getEffect());
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
