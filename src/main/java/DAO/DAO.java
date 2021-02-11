package DAO;

import db.Dbconnect;
import services.ServiceJson;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {

	public static Map<String, String> getUsers(List<String> usersLastNames) throws SQLException {
		Map<String, String> fromDBUsers = new HashMap<>();
		PreparedStatement pstst;
		Connection connection = null;
		ResultSet resultSet;
		if ((usersLastNames != null && usersLastNames.size() != 0)) {
			try {
				String[] list = new String[usersLastNames.size()];
				usersLastNames.toArray(list);
				connection = Dbconnect.getConnection();
				String sql = "select \"firstName\", \"lastName\" from schema_parser.customer WHERE \"lastName\" = ANY (?)";
//						"WHERE 'lastName' = ANY (?) ";
				pstst = connection.prepareStatement(sql);
				System.out.println(pstst);
				Array arrayUsersLastNames = connection.createArrayOf("varchar", list);
				pstst.setArray(1, arrayUsersLastNames);
				resultSet = pstst.executeQuery();

				if (resultSet != null) {
					while (resultSet.next()) {
						ServiceJson.fromDBUsers.put(resultSet.getString("firstName"), resultSet.getString("lastName"));
//						System.out.println(resultSet.getString("firstName") + " " + resultSet.getString("lastName"));
					}
				}

				System.out.println(ServiceJson.fromDBUsers);

			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		}
		return fromDBUsers;
	}

//	public static Map<String, String> getCountOfProductBought(List<String> usersLastNames) throws SQLException {
//		Map<String, String> fromDBUsers = new HashMap<>();
//		PreparedStatement pstst = null;
//		Connection connection = null;
//		ResultSet resultSet = null;
//		if ((usersLastNames != null && usersLastNames.size() != 0)) {
//			try {
//				String[] list = new String[usersLastNames.size()];
//				usersLastNames.toArray(list);
//				connection = Dbconnect.getConnection();
//				String sql = "select \"firstName\", \"lastName\" from schema_parser.customer WHERE \"lastName\" = ANY (?)";
////						"WHERE 'lastName' = ANY (?) ";
//				pstst = connection.prepareStatement(sql);
//				System.out.println(pstst);
//				Array arrayUsersLastNames = connection.createArrayOf("varchar", list);
//				pstst.setArray(1, arrayUsersLastNames);
//				resultSet = pstst.executeQuery();
//
//				if (resultSet != null) {
//					while (resultSet.next()) {
//						ServiceJson.fromDBUsers.put(resultSet.getString("firstName"), resultSet.getString("lastName"));
////						System.out.println(resultSet.getString("firstName") + " " + resultSet.getString("lastName"));
//					}
//				}
//
//				System.out.println(ServiceJson.fromDBUsers);
//
//			} catch (SQLException throwables) {
//				throwables.printStackTrace();
//			} finally {
//				if (connection != null) {
//					connection.close();
//				}
//			}
//		}
//		return fromDBUsers;
//	}



}
