package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.jblog.dao.util.JblogConnectManager;
import com.cafe24.jblog.vo.PostVO;

public class PostDAO extends JblogConnectManager {
    public boolean create( PostVO vo ) {
	boolean result = false;
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
	    conn = super.getConnection();
	    String sql = "INSERT INTO post VALUES(null, ?, ?, ?, ?)";
	    pstmt = conn.prepareStatement( sql );

	    pstmt.setString( 1, vo.getUserId() );
	    pstmt.setLong( 2, vo.getCategoryNo() );
	    pstmt.setString( 3, vo.getTitle() );
	    pstmt.setString( 4, vo.getBody() );
	    int count = pstmt.executeUpdate();

	    CategoryDAO catDao = new CategoryDAO();
	    catDao.updateCount( vo.getNo() );
	    
	    result = (count == 1);
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, null );
	}

	return result;
    }

    public List<PostVO> readAll() {
	List<PostVO> list = new ArrayList<PostVO>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    conn = super.getConnection();
	    String sql = "SELECT no, user_id, category_no, title, body FROM post";
	    pstmt = conn.prepareStatement( sql );
	    rs = pstmt.executeQuery();

	    while ( rs.next() ) {
		PostVO vo = new PostVO();
		vo.setNo( rs.getLong( 1 ) );
		vo.setUserId( rs.getString( 2 ) );
		vo.setCategoryNo( rs.getLong( 3 ) );
		vo.setTitle( rs.getString( 4 ) );
		vo.setBody( rs.getString( 5 ) );

		list.add( vo );
	    }
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, rs );
	}

	return list;
    }

    public PostVO readByNo( Long no ) {
	PostVO vo = new PostVO();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    conn = super.getConnection();
	    String sql = "SELECT no, user_id, category_no, title, body FROM post WHERE no = ?";
	    pstmt = conn.prepareStatement( sql );
	    pstmt.setLong( 1, no );
	    rs = pstmt.executeQuery();

	    while ( rs.next() ) {
		vo.setNo( rs.getLong( 1 ) );
		vo.setUserId( rs.getString( 2 ) );
		vo.setCategoryNo( rs.getLong( 3 ) );
		vo.setTitle( rs.getString( 4 ) );
		vo.setBody( rs.getString( 5 ) );
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
	    String sql = "DELETE FROM post WHERE no = ?";
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
