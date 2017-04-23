package com.erickogi14gmail.demo_news_api_android1.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.erickogi14gmail.demo_news_api_android1.R;
import com.erickogi14gmail.demo_news_api_android1.mPicasso.PicassoClient;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 4/22/2017.
 */

public class SorcesModelAdapter extends RecyclerView.Adapter<SorcesModelAdapter.MyViewHolder> {
    Context context;
    private ArrayList<SourcesModel> modelList;

    public SorcesModelAdapter(Context context){
        this.context = context;
        // this.listData = listData;
    }
    public interface OnItemClickListener {

        void onItemClick(SourcesModel item);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textId;
        private TextView textName;
        private TextView textDescription;

        private ImageView loadedImage;


        public MyViewHolder(View view) {
            super(view);
         //   textId = (TextView) view.findViewById(R.id.txt_source_id);
            textName = (TextView) view.findViewById(R.id.txt_source_name);
          //  textDescription = (TextView) view.findViewById(R.id.txt_source_description);
           // loadedImage=(ImageView)view.findViewById(R.id.img);

        }
    }


    public SorcesModelAdapter(ArrayList<SourcesModel> modelList,Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_source, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SourcesModel model = modelList.get(position);

        holder.textName.setText(model.getName());
       // holder.textDescription.setText(model.getDescription());
        //holder.textId.setText(model.getId());

        //PicassoClient.LoadImage(context,model.getUrl(),
        //        holder.loadedImage);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

}




