package com.cafe24.jblog.vo;

public class CommentVO {
    private Long no;
    private String body;
    private Long postNo;

    public Long getNo() {
	return no;
    }

    public void setNo( Long no ) {
	this.no = no;
    }

    public String getBody() {
	return body;
    }

    public void setBody( String body ) {
	this.body = body;
    }

    public Long getPostNo() {
	return postNo;
    }

    public void setPostNo( Long postNo ) {
	this.postNo = postNo;
    }

    @Override
    public String toString() {
	return "[게시글 번호:" + postNo + ", 댓글 번호:" + no + ", 내용:" + body + "]";
    }

}
