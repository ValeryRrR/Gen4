package com.example.valer.gen4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RepoInfoFragment extends Fragment {

    private TextView repoName;
    private TextView description;
    private PostModel mPostModel;

    public RepoInfoFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repo_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        repoName = view.findViewById(R.id.repoName);
        description = view.findViewById(R.id.description);

        repoName.setText(mPostModel.getSquareName());
        description.setText(mPostModel.getDescription());

    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       mPostModel = getArguments().getParcelable("post");
    }
}
