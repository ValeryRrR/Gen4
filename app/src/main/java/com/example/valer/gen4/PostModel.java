package com.example.valer.gen4;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PostModel implements Parcelable {

    @SerializedName("name")
    private final String squareName;

    @SerializedName("stargazers_count")
    private final int stargazersCount;

    @SerializedName("forks_count")
    private final int forksCount;

    @SerializedName("description")
    private final String description;

    public PostModel(String squareName, int stargazersCount, int forksCount, String description) {
        this.description = description;
        this.squareName = squareName;
        this.stargazersCount = stargazersCount;
        this.forksCount = forksCount;
    }

    protected PostModel(Parcel in) {
        description = in.readString();
        squareName = in.readString();
        stargazersCount = in.readInt();
        forksCount = in.readInt();
    }

    public String getSquareName() {
        return squareName;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public int getForksCount() {
        return forksCount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(squareName);
        dest.writeInt(stargazersCount);
        dest.writeInt(forksCount);
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>()
    {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

}

