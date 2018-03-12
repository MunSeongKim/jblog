package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.CommentDAO;
import com.cafe24.jblog.vo.CommentVO;

public class CommentDAOTest {

    public static void main( String[] args ) {
	//createTest("Wow", 1L);
	//createTest("Thank you for your kind", 2L);
	createTest("Thanks", 1L);
	createTest("Awesome!", 2L);
	readAllTest();
	// readByNoTest(2L);
	
    }
    
    private static void createTest( String body, Long postNo ) {
	CommentDAO dao = new CommentDAO();
	CommentVO vo = new CommentVO();

	vo.setBody( body );
	vo.setPostNo( postNo );

	System.out.println( dao.create( vo ) ? "Create complete" : "Create Error" );
    }

    private static void readAllTest() {
	List<CommentVO> list = new CommentDAO().readAll();

	for ( CommentVO vo : list ) {
	    System.out.println( vo );
	}
    }

    private static void readByNoTest( Long no ) {
	CommentVO vo = new CommentDAO().readByNo( no );
	System.out.println( vo );
    }

    private static void deleteByNoTest( Long no ) {
	CommentDAO dao = new CommentDAO();
	System.out.println( dao.deleteByNo( no ) ? "Delete complete" : "Delete Error" );
    }
}
