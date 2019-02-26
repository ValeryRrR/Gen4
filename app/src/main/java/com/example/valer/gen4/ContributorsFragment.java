package com.example.valer.gen4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.valer.gen4.Models.ContributorsModel;
import com.example.valer.gen4.Models.PostModel;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContributorsFragment extends Fragment {

    private RecyclerView recyclerView;
    private PostModel mPostModel;

    public ContributorsFragment(){
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPostModel = getArguments().getParcelable("post");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contributors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.contributors_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        final ContributorsAdapter contributorsAdapter = new ContributorsAdapter();
        recyclerView.setAdapter(contributorsAdapter);


        App.getApi().getContributors(mPostModel.getSquareName()).enqueue(new Callback<List<ContributorsModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<ContributorsModel>> call, @NonNull Response<List<ContributorsModel>> response) {
                contributorsAdapter.updateContributors(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<ContributorsModel>> call, @NonNull Throwable t) {
                Context context = getContext();

                if (context != null){
                    Toast.makeText(context, "Error networking", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
