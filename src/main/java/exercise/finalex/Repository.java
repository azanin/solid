package exercise.finalex;

import com.squareup.moshi.Json;

public class Repository {

    private final String id;
    private final String name;
    @Json(name = "stargazers_count")
    private final int stargazers;
    private final String description;
    @Json(name = "commits_url")
    private final String commitsUrl;

    public Repository(String id, String name, int stargazers, String description, String commitsUrl) {
        this.id = id;
        this.name = name;
        this.stargazers = stargazers;
        this.description = description;
        this.commitsUrl = commitsUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStargazers() {
        return stargazers;
    }

    public String getDescription() {
        return description;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }
}
