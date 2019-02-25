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

import com.example.valer.gen4.Models.PostModel;
import com.example.valer.gen4.ui.DividerItemDecorator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SquareNameFragment extends Fragment {

    private RecyclerView recyclerView;

    public SquareNameFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_square_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecorator dividerItemDecoration = new DividerItemDecorator(ContextCompat.getDrawable(getContext(), R.drawable.divider));
        recyclerView.addItemDecoration(dividerItemDecoration);

        final SquareNameAdapter adapter = new SquareNameAdapter();

        SquareNameAdapter.IItemClickListener lidtener = new SquareNameAdapter.IItemClickListener()
        {
            @Override
            public void onItemClick(PostModel model) {

                RepoInfoFragment fragment = new RepoInfoFragment();

                Bundle args = new Bundle();
                args.putParcelable("post", model);
                fragment.setArguments(args);

                getFragmentManager().beginTransaction().replace(R.id.activity_main, fragment).addToBackStack(null).commit();

            }
        };
        adapter.setOnClickListener(lidtener);
        recyclerView.setAdapter(adapter);



        App.getApi().getRepos().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<PostModel>> call, @NonNull Response<List<PostModel>> response) {
                adapter.updateNames(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<PostModel>> call, @NonNull Throwable t) {
                Context context = getContext();

                if (context != null){
                    Toast.makeText(context, "Error networking", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
