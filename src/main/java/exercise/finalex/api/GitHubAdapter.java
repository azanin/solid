package exercise.finalex.api;

import exercise.finalex.api.data.CommitContainer;
import exercise.finalex.api.data.Repository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GitHubAdapter implements GitHubApi {

    private final static String ACCESS_TOKEN = "";

    private final GitHubInvoker gitHub;

    public GitHubAdapter(GitHubInvoker gitHub) {
        this.gitHub = gitHub;
    }

    @Override
    public List<Repository> repos(String owner) {
        try {
            List<Repository> body = this.gitHub.repos(owner, ACCESS_TOKEN).execute().body();
            return body == null ? Collections.emptyList() : body;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public List<CommitContainer> commits(String owner, String repo) {
        try {
            List<CommitContainer> body = this.gitHub.commits(owner, repo, ACCESS_TOKEN).execute().body();
            return body == null ? Collections.emptyList() : body;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
