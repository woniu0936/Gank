package com.woniu.gank.data.bean;

/**
 * @author woniu
 * @title GankBean
 * @description gank通用实体类
 * @modifier
 * @date
 * @since 16/10/25 下午12:55
 */

public class GankBean {
    /**
     * _id : 5808f2a0421aa90e6f21b41e
     * createdAt : 2016-10-21T00:36:48.978Z
     * desc : 关于SharedPreference踩的那些坑
     * publishedAt : 2016-10-25T11:35:01.586Z
     * source : web
     * type : Android
     * url : http://shaohui.me/2016/10/20/%E5%85%B3%E4%BA%8ESharedPreference%E8%B8%A9%E7%9A%84%E9%82%A3%E4%BA%9B%E5%9D%91/
     * used : true
     * who : 邵辉Vista
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public String toString() {
        return "GankBean{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }
}
