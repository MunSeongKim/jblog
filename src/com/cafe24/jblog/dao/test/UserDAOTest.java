package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.UserDAO;
import com.cafe24.jblog.vo.UserVO;

public class UserDAOTest {

    public static void main( String[] args ) {
	createTest( "dooly", "둘리", "1234" );
	readAllTest();
	readByIdTest( "dooly" );
//	deleteByIdTest("dooly");
//	readByIdTest( "dooly" );
    }

    private static void createTest( String id, String name, String password ) {
	UserDAO dao = new UserDAO();
	UserVO vo = new UserVO();

	vo.setId( id );
	vo.setName( name );
	vo.setPassword( password );

	System.out.println( dao.create( vo ) ? "Create complete" : "Create Error" );
    }

    private static void readAllTest() {
	List<UserVO> list = new UserDAO().readAll();

	for ( UserVO vo : list ) {
	    System.out.println( vo );
	}
    }

    private static void readByIdTest( String id ) {
	UserVO vo = new UserDAO().readById( id );
	System.out.println( vo );
    }

    private static void deleteByIdTest( String id ) {
	UserDAO dao = new UserDAO();
	System.out.println( dao.deleteById( id ) ? "Delete complete" : "Delete Error" );
    }

}
