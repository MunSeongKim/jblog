package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.jblog.dao.util.JblogConnectManager;
import com.cafe24.jblog.vo.BlogVO;

public class BlogDAO extends JblogConnectManager {
    public boolean create( BlogVO vo ) {
	boolean result = false;
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
	    conn = super.getConnection();
	    String sql = "INSERT INTO blog VALUES(?, ?, ?)";
	    pstmt = conn.prepareStatement( sql );

	    pstmt.setString( 1, vo.getUserId() );
	    pstmt.setString( 2, vo.getTitle() );
	    pstmt.setString( 3, vo.getImage() );
	    int count = pstmt.executeUpdate();

	    result = (count == 1);
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, null );
	}

	return result;
    }

    public List<BlogVO> readAll() {
	List<BlogVO> list = new ArrayList<BlogVO>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    conn = super.getConnection();
	    String sql = "SELECT user_id, title, image FROM blog";
	    pstmt = conn.prepareStatement( sql );
	    rs = pstmt.executeQuery();

	    while ( rs.next() ) {
		BlogVO vo = new BlogVO();
		vo.setUserId( rs.getString( 1 ) );
		vo.setTitle( rs.getString( 2 ) );
		vo.setImage( rs.getString( 3 ) );

		list.add( vo );
	    }
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, rs );
	}

	return list;
    }

    public BlogVO readById( String id ) {
	BlogVO vo = new BlogVO();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    conn = super.getConnection();
	    String sql = "SELECT user_id, title, image FROM blog WHERE user_id = ?";
	    pstmt = conn.prepareStatement( sql );
	    pstmt.setString( 1, id );
	    rs = pstmt.executeQuery();

	    while ( rs.next() ) {
		vo.setUserId( rs.getString( 1 ) );
		vo.setTitle( rs.getString( 2 ) );
		vo.setImage( rs.getString( 3 ) );
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
	    String sql = "DELETE FROM blog WHERE user_id = ?";
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
