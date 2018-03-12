package com.cafe24.jblog.vo;

public class PostVO {
    private Long no;
    private String userId;
    private Long categoryNo;
    private String title;
    private String body;

    public Long getNo() {
        return no;
    }

    public void setNo( Long no ) {
        this.no = no;
    }

    public String getUserId() {
	return userId;
    }

    public void setUserId( String userId ) {
	this.userId = userId;
    }

    public Long getCategoryNo() {
	return categoryNo;
    }

    public void setCategoryNo( Long categoryNo ) {
	this.categoryNo = categoryNo;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle( String title ) {
	this.title = title;
    }

    public String getBody() {
	return body;
    }

    public void setBody( String body ) {
	this.body = body;
    }

    @Override
    public String toString() {
	return "[번호:" + no + ", 아이디:" + userId + ", 카테고리 번호:" + categoryNo + ", 제목:" + title + ", 본문:"
		+ body + "]";
    }

}
