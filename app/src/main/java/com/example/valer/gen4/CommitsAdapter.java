package com.example.valer.gen4;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CommitsAdapter extends RecyclerView.Adapter<CommitsAdapter.ViewHolder> {

    private List<PostModel> posts;
    private IItemClickListenerCommits listener;

    public CommitsAdapter(){ this.posts = new ArrayList<>(); }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.commits_list_item, parent, false);
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

        if(posts != null)
            count = posts.size();

        return count;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private PostModel model;
        private TextView post;


        public ViewHolder(View itemView) {
            super(itemView);
            post = (TextView) itemView.findViewById(R.id.commit_item);
        }


        void bind(PostModel postModel) {
            model = postModel;
/*
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                post.setText(Html.fromHtml(postModel.getSquareName(), Html.FROM_HTML_MODE_LEGACY));
            } else {
                post.setText(Html.fromHtml(postModel.getSquareName()));
            }
            */
           post.setText(postModel.getCommit());

        }

        void setItemClickListener(final IItemClickListenerCommits listener) {
            this.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(model);
                }
            });
        }
    }

    interface IItemClickListenerCommits {
        void onItemClick(PostModel model);
    }
}
