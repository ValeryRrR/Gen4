package com.example.valer.gen4;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SquareNameAdapter extends RecyclerView.Adapter<SquareNameAdapter.ViewHolder> {

    private List<PostModel> posts;

    public SquareNameAdapter() {
        this.posts = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.square_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int index) {
        PostModel post = posts.get(index);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.post.setText(Html.fromHtml(post.getSquareName(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.post.setText(Html.fromHtml(post.getSquareName()));
        }
        holder.forks.setText(holder.forks.getContext().getString(R.string.forks, post.getForksCount()));
        holder.stars.setText(holder.stars.getContext().getString(R.string.stars, post.getStargazersCount()));
    }

    @Override
    public int getItemCount() {

        int count = 0;

        if (posts != null) {
            count = posts.size();
        }

        return count;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView post;
        TextView forks;
        TextView stars;

        public ViewHolder(View itemView) {
            super(itemView);
            post = (TextView) itemView.findViewById(R.id.postname_item);
            forks = (TextView) itemView.findViewById(R.id.view_holder_forks);
            stars = (TextView) itemView.findViewById(R.id.view_holder_stars);
        }
    }

    public void updateNames(List<PostModel> postModelList){

        posts.addAll(postModelList);
        notifyDataSetChanged();

    }

}
