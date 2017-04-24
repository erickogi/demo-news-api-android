package com.erickogi14gmail.demo_news_api_android1.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 4/22/2017.
 */

public class ArticlesJsonParser {
    static ArrayList<ArticlesModel> articlesModelArrayList;

    public static ArrayList<ArticlesModel> parseData(String content) {

        JSONArray articles_arry = null;
        ArticlesModel model = null;
        try {


            articlesModelArrayList = new ArrayList<>();
            JSONObject jObj = new JSONObject(content);
            articles_arry = jObj.getJSONArray("articles");

            for (int i = 0; i < articles_arry.length(); i++) {

                JSONObject obj = articles_arry.getJSONObject(i);
                model = new ArticlesModel();

                model.setAuthor(obj.getString(Constants.KEY_ARTICLE_AUTOR));
                model.setTitle(obj.getString(Constants.KEY_ARTICLE_TITLE));
                model.setDescription(obj.getString(Constants.KEY_ARTICLE_DESCRIPTION));
                model.setUrl(obj.getString(Constants.KEY_ARTICLE_URL));
                model.setUrlToImage(obj.getString(Constants.KEY_ARTICLE_URLTOIMAGE));
                model.setPublishedAt(obj.getString(Constants.KEY_ARTICLE_PUBLISHEDAT));


                articlesModelArrayList.add(model);
            }
            return articlesModelArrayList;

        } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
