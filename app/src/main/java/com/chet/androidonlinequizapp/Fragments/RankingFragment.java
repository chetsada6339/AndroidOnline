package com.chet.androidonlinequizapp.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.chet.androidonlinequizapp.Interface.ItemClickListener;
import com.chet.androidonlinequizapp.Model.Category;
import com.chet.androidonlinequizapp.Model.Ranking;
import com.chet.androidonlinequizapp.R;
import com.chet.androidonlinequizapp.ViewHolder.CategoryViewHolder;
import com.chet.androidonlinequizapp.ViewHolder.RankingViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class RankingFragment extends Fragment{
    View myFragment;

    RecyclerView listRanking;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Ranking,RankingViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference rankings;

    public  static  RankingFragment newInstance(){
        RankingFragment rankingFragment= new RankingFragment();
        return  rankingFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        rankings = database.getReference("Ranking");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment =inflater.inflate(R.layout.fragment_ranking,container,false);
        listRanking = (RecyclerView)myFragment.findViewById(R.id.listRanking);
        listRanking.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        listRanking.setLayoutManager(layoutManager);

        loadRankings();

        return  myFragment;
    }
    private void loadRankings() {
       adapter = new FirebaseRecyclerAdapter<Ranking, RankingViewHolder>(
               Ranking.class,
               R.layout.ranking_layout,
               RankingViewHolder.class,
               rankings

       ) {
           @Override
           protected void populateViewHolder(RankingViewHolder viewHolder, final Ranking model, int position) {
               viewHolder.ranking_name.setText(model.getName());
               Picasso.with(getActivity())
                       .load(model.getImage())
                       .into(viewHolder.ranking_image);

               viewHolder.setItemClickListener(new ItemClickListener() {
                   @Override
                   public void onClick(View view, int position, boolean isLongClick) {
                       Toast.makeText(getActivity(),String.format("%s|%s",adapter.getRef(position).getKey(),model.getName()),Toast.LENGTH_SHORT).show();
                   }
               });

           }

       };
        adapter.notifyDataSetChanged();
        listRanking.setAdapter(adapter);

    }
}
