package com.erickogi14gmail.demo_news_api_android1.Utils;

/**
 * Created by kimani kogi on 4/22/2017.
 */

public class SourcesModel {
//    "id": "abc-news-au",
//            "name": "ABC News (AU)",
//            "description": "Australia's most trusted source of local, national and world news. Comprehensive, independent, in-depth analysis, the latest business, sport, weather and more.",
//            "url": "http://www.abc.net.au/news",
//            "category": "general",
//            "language": "en",
//            "country": "au",
//            -"urlsToLogos": {
//        "small": "",
//                "medium": "",
//                "large": ""
//    },
//            -"sortBysAvailable": [
//            "top"
//            ]

    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String language;
    private String country;

    public SourcesModel() {
    }

    public SourcesModel(String id, String name, String description, String url, String category, String language, String country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = category;
        this.language = language;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
