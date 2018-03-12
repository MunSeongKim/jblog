package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.PostDAO;
import com.cafe24.jblog.vo.PostVO;

public class PostDAOTest {

    public static void main( String[] args ) {
	createTest("dooly", 1L, "Class", "class blah blah");
	createTest("dooly", 1L, "Class2", "class2 blah blah");
	readAllTest();
	readByNoTest(2L);
	
    }
    
    private static void createTest( String userId, Long categoryNo, String title, String body ) {
	PostDAO dao = new PostDAO();
	PostVO vo = new PostVO();

	vo.setUserId( userId );
	vo.setCategoryNo( categoryNo );
	vo.setTitle( title );
	vo.setBody( body );

	System.out.println( dao.create( vo ) ? "Create complete" : "Create Error" );
    }

    private static void readAllTest() {
	List<PostVO> list = new PostDAO().readAll();

	for ( PostVO vo : list ) {
	    System.out.println( vo );
	}
    }

    private static void readByNoTest( Long no ) {
	PostVO vo = new PostDAO().readByNo( no );
	System.out.println( vo );
    }

    private static void deleteByNoTest( Long no ) {
	PostDAO dao = new PostDAO();
	System.out.println( dao.deleteByNo( no ) ? "Delete complete" : "Delete Error" );
    }

}
