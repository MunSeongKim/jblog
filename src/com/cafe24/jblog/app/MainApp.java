package com.cafe24.jblog.app;

public class MainApp {
    static {
	// Initailizing - Data injection
//	User user = new User();
//	Blog blog = new Blog();
//	Category category = new Category();
//	Post post = new Post();
//	Comment comment = new Comment();
//	
//	user.create( "dooly", "둘리", "1234" );
//	blog.create( "dooly", "둘리블로그", null );
//	category.create(1L, "미분류", "카테고리를 지정하지 않은 경우입니다. (기본)");
//	category.create(2L, "자바 프로그래밍", "자바 프로그래밍 해보기");
//	category.create(3L, "JDBC", "자바 데이터베이스 프로그래밍");
//	post.create("dooly", 1L, "Class", "class blah blah");
//	post.create("dooly", 1L, "Class2", "class2 blah blah");
//	comment.create("Wow", 1L);
//	comment.create("Thank you for your kind", 2L);
    }
    
    public static void main( String[] args ) {
	User user = new User();
	Blog blog = new Blog();
	Category category = new Category();
	Post post = new Post();
	Comment comment = new Comment();
	
	System.out.println( "----------- 회원 목록 -----------" );
	user.readAll();
	System.out.println( "----------- 블로그 목록 -----------" );
	blog.readAll();
	System.out.println( "----------- 카테고리 목록 -----------" );
	category.readAll();
	System.out.println( "----------- 포스트 목록 -----------" );
	post.readAll();
	System.out.println( "----------- 댓글 목록 -----------" );
	comment.readAll();
	
    }

}
