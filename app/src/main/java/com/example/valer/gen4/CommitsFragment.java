package com.example.valer.gen4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.valer.gen4.Models.CommitModel;
import com.example.valer.gen4.ui.DividerItemDecorator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommitsFragment extends Fragment {

    private RecyclerView recyclerView;

    public CommitsFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_commits, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.commits_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecorator dividerItemDecoration = new DividerItemDecorator(ContextCompat.getDrawable(getContext(), R.drawable.divider));
        recyclerView.addItemDecoration(dividerItemDecoration);

        final CommitsAdapter commitsAdapter = new CommitsAdapter();
        recyclerView.setAdapter(commitsAdapter);


        App.getApi().getCommits().enqueue(new Callback<List<CommitModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<CommitModel>> call, @NonNull Response<List<CommitModel>> response) {
                commitsAdapter.updateCommits(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<CommitModel>> call, @NonNull Throwable t) {
                Context context = getContext();

                if (context != null){
                    Toast.makeText(context, "Error networking", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
