package io.github.reverince.devtree.data;

public class Post {
    private String profile;
    private String summary;

    public Post(String profile, String summary) {
        this.profile = profile;
        this.summary = summary;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
