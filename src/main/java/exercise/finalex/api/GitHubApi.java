package exercise.finalex.api;

import exercise.finalex.api.data.Commit;
import exercise.finalex.api.data.Repository;

import java.util.List;

public interface GitHubApi {
    List<Repository> repos(String owner);

    List<Commit> commits(String owner, String repo);
}
