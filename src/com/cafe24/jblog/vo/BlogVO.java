package com.cafe24.jblog.vo;

public class BlogVO {
    private String userId;
    private String title;
    private String image;

    public String getUserId() {
	return userId;
    }

    public void setUserId( String userId ) {
	this.userId = userId;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle( String title ) {
	this.title = title;
    }

    public String getImage() {
	return image;
    }

    public void setImage( String image ) {
	this.image = image;
    }

    @Override
    public String toString() {
	return "사용자 아이디:" + userId + ", 제목:" + title + ", 이미지 경로:" + image + "]";
    }

}
