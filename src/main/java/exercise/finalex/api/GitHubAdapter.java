package exercise.finalex.api;

import exercise.finalex.api.data.Commit;
import exercise.finalex.api.data.Repository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GitHubAdapter implements GitHubApi {

    private final GitHubInvoker gitHub;

    public GitHubAdapter(GitHubInvoker gitHub) {
        this.gitHub = gitHub;
    }

    @Override
    public List<Repository> repos(String owner) {
        try {
            List<Repository> body = this.gitHub.repos(owner).execute().body();
            return body == null ? Collections.emptyList() : body;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Commit> commits(String owner, String repo) {
        try {
            List<Commit> body = this.gitHub.commits(owner, repo).execute().body();
            return body == null ? Collections.emptyList() : body;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
