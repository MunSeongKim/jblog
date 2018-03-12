package com.cafe24.jblog.app;

import java.util.List;

import com.cafe24.jblog.dao.PostDAO;
import com.cafe24.jblog.vo.PostVO;

public class Post {
    public void create( String userId, Long categoryNo, String title, String body ) {
	PostDAO dao = new PostDAO();
	PostVO vo = new PostVO();

	vo.setUserId( userId );
	vo.setCategoryNo( categoryNo );
	vo.setTitle( title );
	vo.setBody( body );

	System.out.println( dao.create( vo ) ? "Create complete" : "Create Error" );
    }

    public void readAll() {
	List<PostVO> list = new PostDAO().readAll();

	for ( PostVO vo : list ) {
	    System.out.println( vo );
	}
    }

    public void readByNo( Long no ) {
	PostVO vo = new PostDAO().readByNo( no );
	System.out.println( vo );
    }

    public void deleteByNo( Long no ) {
	PostDAO dao = new PostDAO();
	System.out.println( dao.deleteByNo( no ) ? "Delete complete" : "Delete Error" );
    }
}
