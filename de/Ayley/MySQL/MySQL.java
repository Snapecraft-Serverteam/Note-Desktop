package MySQL;

import java.sql.*;


public class MySQL {

    public static Connection con;
    
    public static String database = "Snapecraft";
    
    public static String username;
    public static String password;
    static final String URL = "jdbc:mysql://localhost:3306/" + database;
    


    public static void connect() {
    	username = "root";
    	password = "123456";
        try {
            if (!isConnected()) {
                con = DriverManager.getConnection(URL,username,password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isConnected() {
        return (con == null ? false : true);
    }

    public static void disconect() {
        if (isConnected()) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static void update(String sql) {
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException localSQLException) {
        }
    }

    public static ResultSet query(String qry) {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(qry);
        } catch (SQLException e) {
            connect();
            System.err.println(e);
        }
        return rs;
    }
}
