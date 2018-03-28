package exercise.finalex.model;

import java.util.List;

public class Repo {
    public int getStars() {
        return stars;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCommits() {
        return commits;
    }

    private final int stars;
    private final String name;
    private final String description;
    private final List<String> commits;

    public Repo(int stars, String name, String description, List<String> commits) {
        this.stars = stars;
        this.name = name;
        this.description = description;
        this.commits = commits;
    }
}