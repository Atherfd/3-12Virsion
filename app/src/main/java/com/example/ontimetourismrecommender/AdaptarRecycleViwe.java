package com.example.ontimetourismrecommender;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import static com.example.ontimetourismrecommender.R.layout.*;

public class AdaptarRecycleViwe extends RecyclerView.Adapter<AdaptarRecycleViwe.ProductViewHolder>{


        private Context mCtx;
        private List<HistoryFeedData> HistoryFeedList;

        public AdaptarRecycleViwe(Context mCtx, List<HistoryFeedData> HistoryFeedList) {
            this.mCtx = mCtx;
            this.HistoryFeedList = HistoryFeedList;
        }

        @Override
        public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(activity_history_feed, null);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ProductViewHolder holder, int position) {
            HistoryFeedData history = HistoryFeedList.get(position);

            Picasso.get().load(history.getImage()).into(new Target(){

                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    holder.imageView.setBackground(new BitmapDrawable(mCtx.getResources(), bitmap));
                }

                @Override
                public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                    Log.d("TAG", "FAILED");
                }



                @Override
                public void onPrepareLoad(final Drawable placeHolderDrawable) {
                    Log.d("TAG", "Prepare Load");
                }
            });

            holder.textViewTitle.setText(history.getName());
            if(history.getRating()>=0)
           holder.rate.setRating(history.getRating());
            else{

holder.rate.setVisibility(View.INVISIBLE);
holder.Asktorate.setVisibility(View.VISIBLE);
                holder.Asktorate.setOnClickListener(new View.OnClickListener(){


                    @Override
                    public void onClick(View v) {

                        Sheardpref.getInstance(mCtx).StoreId(history.getSiteId());
                        Intent intent =new Intent(mCtx, dialog.class);
                        mCtx.startActivity(intent);




                    }});


            }

        }

        @Override
        public int getItemCount() {
            return HistoryFeedList.size();
        }

        class ProductViewHolder extends RecyclerView.ViewHolder {

            TextView textViewTitle, Asktorate;
            RatingBar rate;
            View imageView;

            public ProductViewHolder(View itemView) {
                super(itemView);

                textViewTitle = itemView.findViewById(R.id.PlaceName);
               rate = itemView.findViewById(R.id.ratingBar);
                imageView = itemView.findViewById(R.id.view);
                Asktorate=itemView.findViewById(R.id.asktorate);
            }
        }
    }