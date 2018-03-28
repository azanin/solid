package exercise.finalex;

import java.util.List;

interface GitHubApi {
    List<Repository> repos(String owner);

    List<Commit> commits(String owner, String repo);
}
