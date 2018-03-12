package com.cafe24.jblog.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JblogConnectManager {
    protected Connection getConnection() throws SQLException {
	Connection conn = null;

	try {
	    Class.forName( "com.mysql.jdbc.Driver" );
	    String url = "jdbc:mysql://localhost:3306/jblog";
	    conn = DriverManager.getConnection( url, "jblog", "jblog" );
	} catch ( ClassNotFoundException e ) {
	    System.out.println( "Failed to load driver : " + e );
	}

	return conn;
    }

    protected void closeConnection( Connection conn, PreparedStatement pstmt, ResultSet rs ) {
	try {
	    if ( rs != null ) rs.close();
	    if ( pstmt != null ) pstmt.close();
	    if ( conn != null ) conn.close();
	} catch ( SQLException e ) {
	    e.printStackTrace();
	}
    }

}
