package MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLUser {
	
	public static void Table() {
		MySQL.update("CREATE TABLE IF NOT EXISTS USER (McName VARCHAR(20), Password VARCHAR(20))");
	}
	public static boolean User(String user) {
		try {
			ResultSet rs = MySQL.query("SELECT McName FROM  `user` WHERE  `McName` = '" + user + "'");
			if(rs.next()) {
				return rs.getString("McName") != null;
			}
			return false;
		}catch (SQLException e) {
			e.setStackTrace(null);
		}
		return false;
	}
	public static boolean Password(String Password) {
		try {
			ResultSet rs = MySQL.query("SELECT Password FROM  `user` WHERE  `Password` = '" + Password + "'");
			if(rs.next()) {
				return rs.getString("Password") != null;
			}
			return false;
		}catch (SQLException e) {
			e.setStackTrace(null);
		}
		return false;
	}
}
