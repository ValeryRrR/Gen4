package com.example.valer.gen4;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.valer.gen4.Models.PostModel;

import java.util.ArrayList;
import java.util.List;

public class SquareNameAdapter extends RecyclerView.Adapter<SquareNameAdapter.ViewHolder> {

    private List<PostModel> posts;
    private IItemClickListener listener;

    public SquareNameAdapter() {
        this.posts = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.square_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int index) {
        PostModel post = posts.get(index);
        holder.bind(post);
        holder.setItemClickListener(listener);
    }

    @Override
    public int getItemCount() {

        int count = 0;

        if (posts != null) {
            count = posts.size();
        }

        return count;
    }

    public void setOnClickListener(IItemClickListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private PostModel model;
        private TextView post;
        private TextView forks;
        private TextView stars;

        public ViewHolder(View itemView) {
            super(itemView);
            post = (TextView) itemView.findViewById(R.id.postname_item);
            forks = (TextView) itemView.findViewById(R.id.view_holder_forks);
            stars = (TextView) itemView.findViewById(R.id.view_holder_stars);
        }


        void bind(PostModel postModel) {
            model = postModel;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                post.setText(Html.fromHtml(postModel.getSquareName(), Html.FROM_HTML_MODE_LEGACY));
            } else {
                post.setText(Html.fromHtml(postModel.getSquareName()));
            }
            forks.setText(forks.getContext().getString(R.string.forks, postModel.getForksCount()));
            stars.setText(stars.getContext().getString(R.string.stars, postModel.getStargazersCount()));
        }

        void setItemClickListener(final IItemClickListener listener) {
            this.itemView.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(model);
                }
            });
        }
    }

    public void updateNames(List<PostModel> postModelList){

        posts.addAll(postModelList);
        notifyDataSetChanged();

    }

    interface IItemClickListener {
        void onItemClick(PostModel model);
    }
}
