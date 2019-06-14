package com.jsystems.qaapi.database;

import com.jsystems.qaapi.model.user.UserDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

    public static UserDb getoneById(Long id){
        String sql = "select * from testuser where id = " + id;

        UserDb userDb = new UserDb();

     try {
         Statement statement = DataBaseConnector.getConnection().createStatement();
         ResultSet wynik = statement.executeQuery(sql);

         while (wynik.next()){
             userDb.setId(wynik.getLong(1));
             userDb.setName(wynik.getString(2));
             userDb.setSurname(wynik.getString(3));
         }
         wynik.close();
         statement.close();
     }catch (SQLException e){
         e.printStackTrace();
     }
        return userDb;
    }
}
