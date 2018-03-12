package com.cafe24.jblog.dao.test;

import java.util.List;

import com.cafe24.jblog.dao.CategoryDAO;
import com.cafe24.jblog.vo.CategoryVO;

public class CategoryDAOTest {

    public static void main( String[] args ) {
	createTest(1L, "미분류", "카테고리를 지정하지 않은 경우입니다. (기본)");
	createTest(2L, "자바 프로그래밍", "자바 프로그래밍 해보기");
	createTest(3L, "JDBC", "자바 데이터베이스 프로그래밍");
	readAllTest();
	readByNoTest(2L);
//	deleteByNoTest(1L);
//	deleteByNoTest(2L);
//	deleteByNoTest(3L);
    }

    private static void createTest( Long no, String name, String description ) {
	CategoryDAO dao = new CategoryDAO();
	CategoryVO vo = new CategoryVO();

	vo.setNo( no );
	vo.setName( name );
	vo.setDescription( description );

	System.out.println( dao.create( vo ) ? "Create complete" : "Create Error" );
    }

    private static void readAllTest() {
	List<CategoryVO> list = new CategoryDAO().readAll();

	for ( CategoryVO vo : list ) {
	    System.out.println( vo );
	}
    }

    private static void readByNoTest( Long no ) {
	CategoryVO vo = new CategoryDAO().readByNo( no );
	System.out.println( vo );
    }

    private static void deleteByNoTest( Long no ) {
	CategoryDAO dao = new CategoryDAO();
	System.out.println( dao.deleteByNo( no ) ? "Delete complete" : "Delete Error" );
    }

}
