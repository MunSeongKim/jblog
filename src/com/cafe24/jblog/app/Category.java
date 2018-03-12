package com.cafe24.jblog.app;

import java.util.List;

import com.cafe24.jblog.dao.CategoryDAO;
import com.cafe24.jblog.vo.CategoryVO;

public class Category {
    public void create( Long no, String name, String description ) {
	CategoryDAO dao = new CategoryDAO();
	CategoryVO vo = new CategoryVO();

	vo.setNo( no );
	vo.setName( name );
	vo.setDescription( description );

	System.out.println( dao.create( vo ) ? "Create complete" : "Create Error" );
    }

    public void readAll() {
	List<CategoryVO> list = new CategoryDAO().readAll();

	for ( CategoryVO vo : list ) {
	    System.out.println( vo );
	}
    }

    public void readByNo( Long no ) {
	CategoryVO vo = new CategoryDAO().readByNo( no );
	System.out.println( vo );
    }

    public void deleteByNo( Long no ) {
	CategoryDAO dao = new CategoryDAO();
	System.out.println( dao.deleteByNo( no ) ? "Delete complete" : "Delete Error" );
    }
}
