package com.example.valer.gen4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class RepoInfoFragment extends Fragment implements View.OnClickListener {

    private TextView repoName;
    private TextView description;
    private PostModel mPostModel;
    private Button buttonCommits;

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

        buttonCommits = view.findViewById(R.id.button_commits);
        buttonCommits.setOnClickListener(this);

    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       mPostModel = getArguments().getParcelable("post");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_commits:
                getFragmentManager().beginTransaction().replace(R.id.activity_main, new CommitsFragment()).addToBackStack(null).commit();
                break;
            case R.id.button_contributors:

                break;
        }
    }
}
