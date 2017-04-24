package com.erickogi14gmail.demo_news_api_android1.News;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.erickogi14gmail.demo_news_api_android1.R;
import com.erickogi14gmail.demo_news_api_android1.RecyclerViewUtils.HidingScrollListener;
import com.erickogi14gmail.demo_news_api_android1.RecyclerViewUtils.RecyclerTouchListener;
import com.erickogi14gmail.demo_news_api_android1.Utils.ArticlesJsonParser;
import com.erickogi14gmail.demo_news_api_android1.Utils.ArticlesModel;
import com.erickogi14gmail.demo_news_api_android1.Utils.ArticlesModelAdapter;
import com.erickogi14gmail.demo_news_api_android1.Utils.Constants;
import com.erickogi14gmail.demo_news_api_android1.Utils.SorcesModelAdapter;
import com.erickogi14gmail.demo_news_api_android1.Utils.SourcesJsonParser;
import com.erickogi14gmail.demo_news_api_android1.Utils.SourcesModel;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;

public class Categories extends AppCompatActivity {
    static RequestQueue queue;
    static Context context;
    static RecyclerView.LayoutManager mLayoutManager;
    static View view;
    static View viewSource;
    static ArrayList<ArticlesModel> articles;
    SwipeRefreshLayout swipe_refresh_layout;
    RecyclerView recyclerView_vertical;
    RecyclerView recyclerView_horizontal;
    FloatingActionButton fab;
    ArrayList<SourcesModel> sources;
    String category;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private boolean isListView;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Intent intent = getIntent();

        category = intent.getStringExtra(Constants.KEY_CATEGORY_INTENT);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(intent.getStringExtra(Constants.KEY_CATEGORY_LABEL));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Downloading in progress", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);

        recyclerView_horizontal = (RecyclerView) findViewById(R.id.all_news_horizontal_recyclerView);
        recyclerView_vertical = (RecyclerView) findViewById(R.id.all_news_vertical_recyclerView);
        swipe_refresh_layout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipe_refresh_layout.setProgressBackgroundColorSchemeResource(R.color.colorAccent);
        swipe_refresh_layout.setBackgroundResource(android.R.color.white);
        swipe_refresh_layout.setColorSchemeResources(android.R.color.white, android.R.color.holo_purple, android.R.color.white);

        swipe_refresh_layout.setRefreshing(true);

        swipe_refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe_refresh_layout.setRefreshing(true);
                getRecyclerView_sources();

            }
        });
        recyclerView_horizontal.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_horizontal, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                if (viewSource != null) {
                    viewSource.setBackgroundColor(Color.WHITE);
                }
                viewSource = view;
                view.setBackgroundColor(Color.rgb(255, 144, 64));
                swipe_refresh_layout.setRefreshing(true);
                getRecyclerView_articles(sources.get(position).getId());

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        recyclerView_vertical.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_vertical, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(Categories.this, ReadArticle.class);
                intent.putExtra(Constants.KEY_URL_TAG, articles.get(position).getUrl());
                intent.putExtra(Constants.KEY_URL_TO_IMAGE_TAG, articles.get(position).getUrlToImage());

                startActivity(intent);


            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerView_vertical.setOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideViews();
            }

            @Override
            public void onShow() {
                showViews();
            }
        });
        isListView = true;
        getRecyclerView_sources();
    }

    private void hideViews() {

        int fabBottomMargin = 45;
        fab.animate().translationY(fab.getHeight() + fabBottomMargin).setInterpolator(new AccelerateInterpolator(2)).start();
    }

    private void showViews() {
        fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();

    }

    public void setLayout(boolean isListView) {
        this.isListView = isListView;
        setRecyclerView_articles(articles);
    }

    void getRecyclerView_sources() {


        requestDataSources(Constants.SOURCES_END_POINT + "?category=" + category);
    }

    public void setRecyclerView_sources(ArrayList<SourcesModel> sourcesModelArrayList) {
        SorcesModelAdapter adapter;
        this.sources = sourcesModelArrayList;
        adapter = new SorcesModelAdapter(sourcesModelArrayList, getApplicationContext());
        SourcesModel model = sourcesModelArrayList.get(0);

        adapter.notifyDataSetChanged();
        swipe_refresh_layout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        recyclerView_horizontal = (RecyclerView) findViewById(R.id.all_news_horizontal_recyclerView);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());


        recyclerView_horizontal.setLayoutManager(mStaggeredLayoutManager);
        recyclerView_horizontal.setItemAnimator(new DefaultItemAnimator());


        recyclerView_horizontal.setAdapter(adapter);

        swipe_refresh_layout.setRefreshing(false);

        getRecyclerView_articles(model.getId());
    }

    void getRecyclerView_articles(String name) {

        requestDataArticles(Constants.ARTICLES_END_POINT + name + "&apiKey=" + Constants.API_KEY);

    }

    public void setRecyclerView_articles(ArrayList<ArticlesModel> articlesModelArrayList) {
        articles = articlesModelArrayList;
        ArticlesModelAdapter adapter;
        adapter = new ArticlesModelAdapter(articlesModelArrayList, getApplicationContext());
        adapter.notifyDataSetChanged();
        swipe_refresh_layout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        recyclerView_vertical = (RecyclerView) findViewById(R.id.all_news_vertical_recyclerView);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());

        if (this.isListView) {

            mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);


        } else {

            mStaggeredLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);


        }


        recyclerView_vertical.setLayoutManager(mStaggeredLayoutManager);

        recyclerView_vertical.setItemAnimator(new DefaultItemAnimator());


        recyclerView_vertical.setAdapter(adapter);
        swipe_refresh_layout.setRefreshing(false);
    }

    public void requestDataSources(String uri) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, uri,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ArrayList<SourcesModel> sourcesModelArrayList;

                        if (response != null || !response.isEmpty()) {

                            sourcesModelArrayList = SourcesJsonParser.parseData(response, Constants.ALL_TECH_SOURCES_PARSING_CODE);

                            setRecyclerView_sources(sourcesModelArrayList);

                        } else {
                            swipe_refresh_layout.setRefreshing(false);
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        StyleableToast st = new StyleableToast(getApplicationContext(), "Network error", Toast.LENGTH_SHORT);
                        st.setBackgroundColor(Color.parseColor("#ff9040"));
                        st.setTextColor(Color.WHITE);
                        st.setIcon(R.drawable.ic_error_outline_white_24dp);

                        st.setMaxAlpha();
                        st.show();
                        swipe_refresh_layout.setRefreshing(false);


                    }
                });
        queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);
        context = getApplicationContext();
    }

//    public Context getApplicationContext() {
//        Context applicationContext = getContext();
//        context = applicationContext;
//        return applicationContext;
//    }

    public void requestDataArticles(String uri) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, uri,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        ArrayList<ArticlesModel> articlesModelArrayList;

                        if (response != null || !response.isEmpty()) {

                            articlesModelArrayList = ArticlesJsonParser.parseData(response);


                            setRecyclerView_articles(articlesModelArrayList);


                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        StyleableToast st = new StyleableToast(getApplicationContext(), "Network error", Toast.LENGTH_SHORT);
                        st.setBackgroundColor(Color.parseColor("#ff9040"));
                        st.setTextColor(Color.WHITE);
                        st.setIcon(R.drawable.ic_error_outline_white_24dp);

                        st.setMaxAlpha();
                        st.show();
                        swipe_refresh_layout.setRefreshing(false);
                    }
                });

        queue.add(stringRequest);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_toggle) {
            toggle();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggle() {
        MenuItem item = menu.findItem(R.id.action_toggle);
        if (isListView) {
            mStaggeredLayoutManager.setSpanCount(2);
            item.setIcon(R.drawable.ic_list_white_24dp);
            item.setTitle("Show as list");
            isListView = false;
        } else {
            mStaggeredLayoutManager.setSpanCount(1);
            item.setIcon(R.drawable.ic_grid_on_white_24dp);
            item.setTitle("Show as grid");
            isListView = true;
        }
    }
}
