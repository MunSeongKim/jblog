package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.jblog.dao.util.JblogConnectManager;
import com.cafe24.jblog.vo.CommentVO;

public class CommentDAO extends JblogConnectManager {
    public boolean create( CommentVO vo ) {
	boolean result = false;
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
	    conn = super.getConnection();
	    String sql = "INSERT INTO comment VALUES(null, ?, ?)";
	    pstmt = conn.prepareStatement( sql );

	    pstmt.setString( 1, vo.getBody() );
	    pstmt.setLong( 2, vo.getPostNo() );
	    int count = pstmt.executeUpdate();

	    result = (count == 1);
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, null );
	}

	return result;
    }

    public List<CommentVO> readAll() {
	List<CommentVO> list = new ArrayList<CommentVO>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    conn = super.getConnection();
	    String sql = "SELECT no, body, post_no FROM comment";
	    pstmt = conn.prepareStatement( sql );
	    rs = pstmt.executeQuery();

	    while ( rs.next() ) {
		CommentVO vo = new CommentVO();
		vo.setNo( rs.getLong( 1 ) );
		vo.setBody( rs.getString( 2 ) );
		vo.setPostNo( rs.getLong( 3 ) );

		list.add( vo );
	    }
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, rs );
	}

	return list;
    }

    public CommentVO readByNo( Long no ) {
	CommentVO vo = new CommentVO();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    conn = super.getConnection();
	    String sql = "SELECT no, body, post_no FROM comment WHERE no = ?";
	    pstmt = conn.prepareStatement( sql );
	    pstmt.setLong( 1, no );
	    rs = pstmt.executeQuery();

	    while ( rs.next() ) {
		vo.setNo( rs.getLong( 1 ) );
		vo.setBody( rs.getString( 2 ) );
		vo.setPostNo( rs.getLong( 3 ) );
	    }
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, rs );
	}

	return vo;
    }

    public boolean deleteByNo( Long no ) {
	boolean result = false;
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
	    conn = super.getConnection();
	    String sql = "DELETE FROM comment WHERE no = ?";
	    pstmt = conn.prepareStatement( sql );

	    pstmt.setLong( 1, no );
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
