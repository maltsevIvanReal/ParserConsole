package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnect {

	public static Connection getConnection()  {
		String url = "jdbc:postgresql://localhost:5432/parser_db";
		String name ="postgres";
		String password = "postgres";

		try {

			return DriverManager.getConnection(url,name,password);
		} catch (SQLException throwables) {
			System.out.println("Ошибка подключения к базе данных. Подробнее: " + throwables);
		}
		return null;
	}


}
