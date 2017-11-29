package com.chet.androidonlinequizapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chet.androidonlinequizapp.Interface.ItemClickListener;
import com.chet.androidonlinequizapp.R;

/**
 * Created by user on 29/11/2560.
 */

public class RankingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


public TextView ranking_name;
public ImageView ranking_image;

private ItemClickListener itemClickListener;

public RankingViewHolder(View itemView) {
        super(itemView);
        ranking_image = (ImageView)itemView.findViewById(R.id.ranking_image);
        ranking_name = (TextView)itemView.findViewById(R.id.ranking_name);

        itemView.setOnClickListener(this);
        }

public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        }

@Override
public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

        }




}
