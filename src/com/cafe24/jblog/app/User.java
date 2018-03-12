package com.cafe24.jblog.app;

import java.util.List;

import com.cafe24.jblog.dao.UserDAO;
import com.cafe24.jblog.vo.UserVO;

public class User {

    public void create( String id, String name, String password ) {
	UserDAO dao = new UserDAO();
	UserVO vo = new UserVO();

	vo.setId( id );
	vo.setName( name );
	vo.setPassword( password );

	System.out.println( dao.create( vo ) ? "Create complete" : "Create Error" );
    }

    public void readAll() {
	List<UserVO> list = new UserDAO().readAll();
	for ( UserVO vo : list ) {
	    System.out.println( vo );
	}
    }

    public void readById( String id ) {
	UserVO vo = new UserDAO().readById( id );
	System.out.println( vo );
    }

    public void deleteById( String id ) {
	UserDAO dao = new UserDAO();
	System.out.println( dao.deleteById( id ) ? "Delete complete" : "Delete Error" );
    }

}
