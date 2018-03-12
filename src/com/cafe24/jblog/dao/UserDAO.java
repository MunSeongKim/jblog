package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.jblog.dao.util.JblogConnectManager;
import com.cafe24.jblog.vo.UserVO;

public class UserDAO extends JblogConnectManager {
    public boolean create( UserVO vo ) {
	boolean result = false;
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
	    conn = super.getConnection();
	    String sql = "INSERT INTO user VALUES(?, ?, PASSWORD(?))";
	    pstmt = conn.prepareStatement( sql );

	    pstmt.setString( 1, vo.getId() );
	    pstmt.setString( 2, vo.getName() );
	    pstmt.setString( 3, vo.getPassword() );
	    int count = pstmt.executeUpdate();

	    result = (count == 1);
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, null );
	}

	return result;
    }

    public List<UserVO> readAll() {
	List<UserVO> list = new ArrayList<UserVO>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    conn = super.getConnection();
	    String sql = "SELECT id, name FROM user";
	    pstmt = conn.prepareStatement( sql );
	    rs = pstmt.executeQuery();

	    while ( rs.next() ) {
		UserVO vo = new UserVO();
		vo.setId( rs.getString( 1 ) );
		vo.setName( rs.getString( 2 ) );

		list.add( vo );
	    }
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, rs );
	}

	return list;
    }

    public UserVO readById( String id ) {
	UserVO vo = new UserVO();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    conn = super.getConnection();
	    String sql = "SELECT id, name FROM user WHERE id = ?";
	    pstmt = conn.prepareStatement( sql );
	    pstmt.setString( 1, id );
	    rs = pstmt.executeQuery();

	    while ( rs.next() ) {
		vo.setId( rs.getString( 1 ) );
		vo.setName( rs.getString( 2 ) );
	    }
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, rs );
	}

	return vo;
    }

    public boolean deleteById( String id ) {
	boolean result = false;
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
	    conn = super.getConnection();
	    String sql = "DELETE FROM user WHERE id = ?";
	    pstmt = conn.prepareStatement( sql );

	    pstmt.setString( 1, id );
	    int count = pstmt.executeUpdate();

	    result = (count == 1);
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, null );
	}

	return result;
    }
}
