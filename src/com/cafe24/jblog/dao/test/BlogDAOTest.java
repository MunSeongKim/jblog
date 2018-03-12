package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.BlogDAO;
import com.cafe24.jblog.vo.BlogVO;

public class BlogDAOTest {

    public static void main( String[] args ) {
	createTest( "dooly", "둘리블로그", null );
	readAllTest();
	readByIdTest( "dooly" );
//	deleteByIdTest("dooly");
    }

    private static void createTest( String userId, String title, String image ) {
	BlogDAO dao = new BlogDAO();
	BlogVO vo = new BlogVO();

	vo.setUserId( userId );
	vo.setTitle( title );
	vo.setImage( image );

	System.out.println( dao.create( vo ) ? "Create complete" : "Create Error" );
    }

    private static void readAllTest() {
	List<BlogVO> list = new BlogDAO().readAll();

	for ( BlogVO vo : list ) {
	    System.out.println( vo );
	}
    }

    private static void readByIdTest( String userId ) {
	BlogVO vo = new BlogDAO().readById( userId );
	System.out.println( vo );
    }

    private static void deleteByIdTest( String userId ) {
	BlogDAO dao = new BlogDAO();
	System.out.println( dao.deleteById( userId ) ? "Delete complete" : "Delete Error" );
    }

}
