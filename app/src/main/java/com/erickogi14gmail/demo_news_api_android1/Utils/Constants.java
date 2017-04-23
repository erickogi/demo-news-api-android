package com.erickogi14gmail.demo_news_api_android1.Utils;

/**
 * Created by kimani kogi on 4/22/2017.
 */

public class Constants {

    public final static String API_KEY="a063b2f6f85b4df6b9bce476d25f3e60";
    public final static String ARTICLES_END_POINT="https://newsapi.org/v1/articles?source=";
    public final static String SOURCES_END_POINT="https://newsapi.org/v1/sources";

    public final static int ALL_SORUCES_PARSING_CODE=100;
    public final static int ALL_TECH_SOURCES_PARSING_CODE=200;

    public final static String KEY_CATEGORY_TECH="technology";
    public final static String KEY_URL_TAG="key_url";
    public final static String KEY_URL_TO_IMAGE_TAG="key_url_to_image";


//SOURCE
public final static String KEY_SOURCE_ID="id";
    public final static String KEY_SOURCE_NAME="name";
    public final static String KEY_SOURCE_DESCRIPTION="description";
    public final static String KEY_SOURCE_URL="url";
    public final static String KEY_SOURCE_CATEGORY="category";
    public final static String KEY_SOURCE_LANGUAGE="language";
    public final static String KEY_SOURCE_COUNTRY="country";



//ARTICLES
public final static String KEY_ARTICLE_AUTOR="author";
    public final static String KEY_ARTICLE_TITLE="title";
    public final static String KEY_ARTICLE_DESCRIPTION="description";
    public final static String KEY_ARTICLE_URL="url";
    public final static String KEY_ARTICLE_URLTOIMAGE="urlToImage";
    public final static String KEY_ARTICLE_PUBLISHEDAT="publishedAt";
//REQUEST CODES
public final static int KEY_ARTICLE_REQUEST=200;
    public final static int KEY_SOURCES_REQUEST=300;


    public static final String LOGIN_URL = "http://erickogi.co.ke/fdarad/api/login.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NAME = "name";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "fdaradlogin";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "email";
    public static final String KEY_SHARED_PREF = "user_key";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}
