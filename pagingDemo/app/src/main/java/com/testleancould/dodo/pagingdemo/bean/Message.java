package com.testleancould.dodo.pagingdemo.bean;

import java.util.List;

/**
 * Created by adamDeng on 2019/9/27
 * Copyright © 2019年 深圳市云歌人工智能技术有限公司. All rights reserved.
 */
public class Message {

    /**
     * code : 200
     * message : 成功!
     * result : [{"sid":"29792566","text":"哈哈哈哈哈哈哈哈哈哈哈哈哈竟然也有一丝犹豫？\u201c不行吧\u201d","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0924/5d8a3a839ac8b_wpd.jpg","video":"http://wvideo.spriteapp.cn/video/2019/0924/5d8a3a839ac8b_wpd.mp4","images":null,"up":"188","down":"12","forward":"6","comment":"4","uid":"23134993","name":"真无双","header":"http://wimg.spriteapp.cn/profile/large/2019/07/04/5d1da9c13ec00_mini.jpg","top_comments_content":"梗还是原来的味道，笑死姐夫了","top_comments_voiceuri":"","top_comments_uid":"19707713","top_comments_name":"用户A9j2xP","top_comments_header":"http://wimg.spriteapp.cn/profile/large/2019/09/25/5d8b335f28a52_mini.jpg","passtime":"2019-09-27 02:53:02"},{"sid":"29791496","text":"看这向你义无反顾奔来的无辜眼神","type":"gif","thumbnail":"http://wimg.spriteapp.cn/ugc/2019/09/24/5d89b8b6cbcb4_a_1.jpg","video":null,"images":"http://wimg.spriteapp.cn/ugc/2019/09/24/5d89b8b6cbcb4.gif","up":"78","down":"4","forward":"1","comment":"0","uid":"23128385","name":"梁山伯","header":"http://wimg.spriteapp.cn/profile/large/2019/07/04/5d1d708b2a4f9_mini.jpg","top_comments_content":null,"top_comments_voiceuri":null,"top_comments_uid":null,"top_comments_name":null,"top_comments_header":null,"passtime":"2019-09-27 02:52:02"}]
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * sid : 29792566
         * text : 哈哈哈哈哈哈哈哈哈哈哈哈哈竟然也有一丝犹豫？“不行吧”
         * type : video
         * thumbnail : http://wimg.spriteapp.cn/picture/2019/0924/5d8a3a839ac8b_wpd.jpg
         * video : http://wvideo.spriteapp.cn/video/2019/0924/5d8a3a839ac8b_wpd.mp4
         * images : null
         * up : 188
         * down : 12
         * forward : 6
         * comment : 4
         * uid : 23134993
         * name : 真无双
         * header : http://wimg.spriteapp.cn/profile/large/2019/07/04/5d1da9c13ec00_mini.jpg
         * top_comments_content : 梗还是原来的味道，笑死姐夫了
         * top_comments_voiceuri :
         * top_comments_uid : 19707713
         * top_comments_name : 用户A9j2xP
         * top_comments_header : http://wimg.spriteapp.cn/profile/large/2019/09/25/5d8b335f28a52_mini.jpg
         * passtime : 2019-09-27 02:53:02
         */

        private String sid;
        private String text;
        private String type;
        private String thumbnail;
        private String video;
        private Object images;
        private String up;
        private String down;
        private String forward;
        private String comment;
        private String uid;
        private String name;
        private String header;
        private String top_comments_content;
        private String top_comments_voiceuri;
        private String top_comments_uid;
        private String top_comments_name;
        private String top_comments_header;
        private String passtime;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public Object getImages() {
            return images;
        }

        public void setImages(Object images) {
            this.images = images;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getDown() {
            return down;
        }

        public void setDown(String down) {
            this.down = down;
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getTop_comments_content() {
            return top_comments_content;
        }

        public void setTop_comments_content(String top_comments_content) {
            this.top_comments_content = top_comments_content;
        }

        public String getTop_comments_voiceuri() {
            return top_comments_voiceuri;
        }

        public void setTop_comments_voiceuri(String top_comments_voiceuri) {
            this.top_comments_voiceuri = top_comments_voiceuri;
        }

        public String getTop_comments_uid() {
            return top_comments_uid;
        }

        public void setTop_comments_uid(String top_comments_uid) {
            this.top_comments_uid = top_comments_uid;
        }

        public String getTop_comments_name() {
            return top_comments_name;
        }

        public void setTop_comments_name(String top_comments_name) {
            this.top_comments_name = top_comments_name;
        }

        public String getTop_comments_header() {
            return top_comments_header;
        }

        public void setTop_comments_header(String top_comments_header) {
            this.top_comments_header = top_comments_header;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }
    }
}
