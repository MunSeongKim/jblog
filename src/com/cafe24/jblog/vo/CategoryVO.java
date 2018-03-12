package com.cafe24.jblog.vo;

public class CategoryVO {
    private Long no;
    private String name;
    private String description;
    private Integer postCount;

    public Long getNo() {
	return no;
    }

    public void setNo( Long no ) {
	this.no = no;
    }

    public String getName() {
	return name;
    }

    public void setName( String name ) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription( String description ) {
	this.description = description;
    }

    public Integer getPostCount() {
	return postCount;
    }

    public void setPostCount( Integer postCount ) {
	this.postCount = postCount;
    }

    @Override
    public String toString() {
	return "[카테고리 번호:" + no + ", 이름:" + name + ", 설명:" + description + ", 포스트 수:" + postCount
		+ "]";
    }

}
