package exercise.finalex.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Report {
    private final String username;
    private final List<Repo> repos;

    public Report(String username, List<Repo> repos) {
        this.username = username;
        this.repos = repos;
    }

    public String getUsername() {
        return username;
    }

    public List<Repo> getRepos() {
        return Collections.unmodifiableList(repos);
    }

    public int repoCount() {
        return repos.size();
    }

    public Optional<Repo> mostStarredRepo() {
        return repos.stream().max(Comparator.comparingInt(Repo::getStars));
    }
}
