package com.erickogi14gmail.demo_news_api_android1.Utils;

/**
 * Created by kimani kogi on 4/22/2017.
 */

public class ArticlesModel {
//    "author": "Bryan Clark",
//            "title": "Target is asking for trouble with new Mario Kart-themed stores",
//            "description": "In advance of the upcoming release of Mario Kart 8 Deluxe, Target has gone Nintendo crazy. According to its senior vice president of merchandising, Scotty Nygaard in a statement, it's ...",
//            "url": "https://thenextweb.com/gaming/2017/04/22/target-is-asking-for-trouble-with-new-mario-kart-themed-stores/",
//            "urlToImage": "https://cdn3.tnwcdn.com/wp-content/blogs.dir/1/files/2017/04/Starting-line-2.jpg",
//            "publishedAt": "2017-04-22T02:38:17Z"

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;

    public ArticlesModel() {
    }

    public ArticlesModel(String author, String title, String description, String url, String urlToImage, String publishedAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
