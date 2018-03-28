package exercise.finalex.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Report {
    private final String username;
    private final Repos repos;

    public Report(String username, Repos repos) {
        this.username = username;
        this.repos = repos;
    }

    private String getUsername() {
        return username;
    }

    private Repos getRepos() {
        return repos;
    }

    public Report forMostStarredRepo() {
        return new Report(getUsername(), new Repos(toList(getRepos().mostStarredRepo())));
    }

    private static List<Repo> toList(Optional<Repo> optionalStarredRepo) {
        List<Repo> starredRepos = new ArrayList<>();
        optionalStarredRepo.ifPresent(starredRepos::add);
        return starredRepos;
    }
}
