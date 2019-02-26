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

import com.example.valer.gen4.Models.PostModel;

public class RepoInfoFragment extends Fragment implements View.OnClickListener {

    private TextView repoName;
    private TextView description;
    private PostModel mPostModel;
    private Button buttonCommits;
    private Button buttonContributors;

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

        buttonContributors = view.findViewById(R.id.button_contributors);
        buttonContributors.setOnClickListener(this);

    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       mPostModel = getArguments().getParcelable("post");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_commits:

                CommitsFragment fragment = new CommitsFragment();

                Bundle args = new Bundle();
                args.putParcelable("post", mPostModel);
                fragment.setArguments(args);

                getFragmentManager().beginTransaction().replace(R.id.activity_main, fragment).addToBackStack(null).commit();
                break;

            case R.id.button_contributors:

                ContributorsFragment contributorsFragment = new ContributorsFragment();

                Bundle argsContributors = new Bundle();
                argsContributors.putParcelable("post", mPostModel);
                contributorsFragment.setArguments(argsContributors);

                getFragmentManager().beginTransaction().replace(R.id.activity_main, contributorsFragment).addToBackStack(null).commit();
                break;
        }
    }
}
