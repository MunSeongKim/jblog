package com.cafe24.jblog.app;

import java.util.List;

import com.cafe24.jblog.dao.BlogDAO;
import com.cafe24.jblog.vo.BlogVO;

public class Blog {
    public void create( String userId, String title, String image ) {
	BlogDAO dao = new BlogDAO();
	BlogVO vo = new BlogVO();

	vo.setUserId( userId );
	vo.setTitle( title );
	vo.setImage( image );

	System.out.println( dao.create( vo ) ? "Create complete" : "Create Error" );
    }

    public void readAll() {
	List<BlogVO> list = new BlogDAO().readAll();

	for ( BlogVO vo : list ) {
	    System.out.println( vo );
	}
    }

    public void readById( String userId ) {
	BlogVO vo = new BlogDAO().readById( userId );
	System.out.println( vo );
    }

    public void deleteById( String userId ) {
	BlogDAO dao = new BlogDAO();
	System.out.println( dao.deleteById( userId ) ? "Delete complete" : "Delete Error" );
    }
}
