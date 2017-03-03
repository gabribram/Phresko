package com.gabri.phresko.model;

/**
 * Created by gabri on 27/02/2017.
 */

public class Post {
    public String username;
    public String profileurl;
    public String postime;
    public String photourl;
    public String title;
    public String description;
    public String location;
    public String defaulttag;
    public String firsttag;
    public String sescondtag;
    public String thirdtag;
    public String commentscount;
    public String favcounts;

    public Post(String username, String profileurl, String postime, String photourl, String title, String description, String location, String defaulttag, String firsttag, String sescondtag, String thirdtag, String commentscount, String favcounts) {
        this.username = username;
        this.profileurl = profileurl;
        this.postime = postime;
        this.photourl = photourl;
        this.title = title;
        this.description = description;
        this.location = location;
        this.defaulttag = defaulttag;
        this.firsttag = firsttag;
        this.sescondtag = sescondtag;
        this.thirdtag = thirdtag;
        this.commentscount = commentscount;
        this.favcounts = favcounts;
    }
    public Post() {
        this.username = username;
        this.profileurl = profileurl;
        this.postime = postime;
        this.photourl = photourl;
        this.title = title;
        this.description = description;
        this.location = location;
        this.defaulttag = defaulttag;
        this.firsttag = firsttag;
        this.sescondtag = sescondtag;
        this.thirdtag = thirdtag;
        this.commentscount = commentscount;
        this.favcounts = favcounts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getPostime() {
        return postime;
    }

    public void setPostime(String postime) {
        this.postime = postime;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDefaulttag() {
        return defaulttag;
    }

    public void setDefaulttag(String defaulttag) {
        this.defaulttag = defaulttag;
    }

    public String getFirsttag() {
        return firsttag;
    }

    public void setFirsttag(String firsttag) {
        this.firsttag = firsttag;
    }

    public String getSescondtag() {
        return sescondtag;
    }

    public void setSescondtag(String sescondtag) {
        this.sescondtag = sescondtag;
    }

    public String getThirdtag() {
        return thirdtag;
    }

    public void setThirdtag(String thirdtag) {
        this.thirdtag = thirdtag;
    }

    public String getCommentscount() {
        return commentscount;
    }

    public void setCommentscount(String commentscount) {
        this.commentscount = commentscount;
    }

    public String getFavcounts() {
        return favcounts;
    }

    public void setFavcounts(String favcounts) {
        this.favcounts = favcounts;
    }
}
