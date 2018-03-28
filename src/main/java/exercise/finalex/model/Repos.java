package exercise.finalex.model;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Repos {
    private final List<Repo> repos;

    public Repos(List<Repo> repos) {
        this.repos = repos;
    }

    public Optional<Repo> mostStarredRepo() {
        return repos.stream().max(Comparator.comparingInt(Repo::getStars));
    }

    public int repoCount() {
        return repos.size();
    }
}
