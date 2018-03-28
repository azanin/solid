package exercise.finalex;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GitHubAdapter implements GitHubApi {

    private final GitHub gitHub;

    public GitHubAdapter(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    @Override
    public List<Repository> repos(String owner) {
        try {
            return this.gitHub.repos(owner).execute().body();
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Commit> commits(String owner, String repo) {
        try {
            return this.gitHub.commits(owner, repo).execute().body();
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
