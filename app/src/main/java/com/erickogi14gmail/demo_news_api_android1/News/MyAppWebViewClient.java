package com.erickogi14gmail.demo_news_api_android1.News;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by kimani kogi on 4/23/2017.
 */
public class MyAppWebViewClient extends WebViewClient {

    boolean refreshed;
    String url;

    public MyAppWebViewClient(String url) {
        this.url = url;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if (Uri.parse(url).getHost().contains(this.url)) {
            return false;
        }

        return false;
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        if (!refreshed) {
            view.loadUrl(failingUrl);

            refreshed = true;
        }
    }
}
