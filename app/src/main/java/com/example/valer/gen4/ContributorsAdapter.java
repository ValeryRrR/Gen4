package com.example.valer.gen4;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.valer.gen4.Models.ContributorsModel;

import java.util.ArrayList;
import java.util.List;

public class ContributorsAdapter extends RecyclerView.Adapter<ContributorsAdapter.ViewHolder> {

    private List<ContributorsModel> posts;

    public ContributorsAdapter() {
        this.posts = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contributor_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int index) {
        ContributorsModel post = posts.get(index);
        holder.bind(post);
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
        private ContributorsModel model;
        private TextView post;


        public ViewHolder(View itemView) {
            super(itemView);
            post = itemView.findViewById(R.id.textViewName);
        }


        void bind(ContributorsModel postModel) {
            model = postModel;

            post.setText(postModel.getContributorLogin());

        }
    }

    public void updateContributors(List<ContributorsModel> postModelList){

        posts.addAll(postModelList);
        notifyDataSetChanged();

    }
}
