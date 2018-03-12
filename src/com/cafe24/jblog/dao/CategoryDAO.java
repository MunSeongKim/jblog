package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.jblog.dao.util.JblogConnectManager;
import com.cafe24.jblog.vo.CategoryVO;

public class CategoryDAO extends JblogConnectManager {
    public boolean create( CategoryVO vo ) {
	boolean result = false;
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
	    conn = super.getConnection();
	    String sql = "INSERT INTO category VALUES(?, ?, ?, 0)";
	    pstmt = conn.prepareStatement( sql );

	    pstmt.setLong(1, vo.getNo() );
	    pstmt.setString( 2, vo.getName() );
	    pstmt.setString( 3, vo.getDescription() );
	    int count = pstmt.executeUpdate();

	    result = (count == 1);
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, null );
	}

	return result;
    }

    public List<CategoryVO> readAll() {
	List<CategoryVO> list = new ArrayList<CategoryVO>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    conn = super.getConnection();
	    String sql = "SELECT no, name, description, post_count FROM category";
	    pstmt = conn.prepareStatement( sql );
	    rs = pstmt.executeQuery();

	    while ( rs.next() ) {
		CategoryVO vo = new CategoryVO();
		vo.setNo( rs.getLong( 1 ) );
		vo.setName( rs.getString( 2 ) );
		vo.setDescription( rs.getString( 3 ) );
		vo.setPostCount( rs.getInt( 4 ) );

		list.add( vo );
	    }
	} catch ( SQLException e ) {
	    e.printStackTrace();
	} finally {
	    super.closeConnection( conn, pstmt, rs );
	}

	return list;
    }

    public CategoryVO readByNo( Long no ) {
	CategoryVO vo = new CategoryVO();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    conn = super.getConnection();
	    String sql = "SELECT no, name, description, post_count FROM category WHERE no = ?";
	    pstmt = conn.prepareStatement( sql );
	    pstmt.setLong( 1, no );
	    rs = pstmt.executeQuery();

	    while ( rs.next() ) {
		vo.setNo( rs.getLong( 1 ) );
		vo.setName( rs.getString( 2 ) );
		vo.setDescription( rs.getString( 3 ) );
		vo.setPostCount( rs.getInt( 4 ) );
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
	    String sql = "DELETE FROM category WHERE no = ?";
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
    
    public boolean updateCount( Long no ) {
	boolean result = false;
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
	    conn = super.getConnection();
	    String sql = "UPDATE category SET post_count=post_count+1 WHERE no = ?";
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
