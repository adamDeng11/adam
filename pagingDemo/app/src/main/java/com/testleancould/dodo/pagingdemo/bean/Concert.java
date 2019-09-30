package com.testleancould.dodo.pagingdemo.bean;

import java.util.Objects;

/**
 * Created by adamDeng on 2019/9/27
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class Concert {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(title, concert.title) &&
                Objects.equals(content, concert.content) &&
                Objects.equals(author, concert.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, author);
    }

    private String title;
    private String content;
    private String author;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }




}
