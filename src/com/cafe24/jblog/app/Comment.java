package com.cafe24.jblog.app;

import java.util.List;

import com.cafe24.jblog.dao.CommentDAO;
import com.cafe24.jblog.vo.CommentVO;

public class Comment {
    public void create( String body, Long postNo ) {
	CommentDAO dao = new CommentDAO();
	CommentVO vo = new CommentVO();

	vo.setBody( body );
	vo.setPostNo( postNo );

	System.out.println( dao.create( vo ) ? "Create complete" : "Create Error" );
    }

    public void readAll() {
	List<CommentVO> list = new CommentDAO().readAll();

	for ( CommentVO vo : list ) {
	    System.out.println( vo );
	}
    }

    public void readByNo( Long no ) {
	CommentVO vo = new CommentDAO().readByNo( no );
	System.out.println( vo );
    }

    public void deleteByNo( Long no ) {
	CommentDAO dao = new CommentDAO();
	System.out.println( dao.deleteByNo( no ) ? "Delete complete" : "Delete Error" );
    }
}
