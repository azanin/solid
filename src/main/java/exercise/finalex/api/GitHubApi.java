package exercise.finalex.api;

import exercise.finalex.api.data.CommitContainer;
import exercise.finalex.api.data.Repository;

import java.util.List;

public interface GitHubApi {
    List<Repository> repos(String owner);

    List<CommitContainer> commits(String owner, String repo);
}
