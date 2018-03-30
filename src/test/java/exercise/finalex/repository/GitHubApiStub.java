package exercise.finalex.repository;

import exercise.finalex.api.GitHubApi;
import exercise.finalex.api.data.CommitContainer;
import exercise.finalex.api.data.Repository;

import java.util.Collections;
import java.util.List;

public class GitHubApiStub implements GitHubApi{

    private final String repoName;
    private final String owner;
    private final Repository repository;
    private final List<CommitContainer> commits;

    public GitHubApiStub(String owner,
                         String repoName,
                         Repository repository,
                         List<CommitContainer> commits) {
        this.owner = owner;
        this.repoName = repoName;
        this.repository = repository;
        this.commits = commits;
    }

    @Override
    public List<Repository> repos(String owner) {
        return owner.equals(this.owner)
                ? Collections.singletonList(this.repository)
                : Collections.emptyList();
    }

    @Override
    public List<CommitContainer> commits(String owner, String repo) {
        return owner.equals(this.owner) && repo.equals(this.repoName)
                ? this.commits
                : Collections.emptyList();
    }
}
