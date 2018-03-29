package exercise.finalex.repository;


import exercise.finalex.api.GitHubApi;
import exercise.finalex.api.data.CommitContainer;
import exercise.finalex.model.Repo;
import exercise.finalex.model.Report;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ReportRepository {

    private final GitHubApi gitHubApi;

    public ReportRepository(GitHubApi gitHubApi) {
        this.gitHubApi = gitHubApi;
    }

    public Report reportFor(String userName) {
        List<Repo> repos = gitHubApi.repos(userName)
                .stream()
                .map(repo -> new Repo(
                        repo.getStargazers(),
                        repo.getName(),
                        repo.getDescription(),
                        gitHubApi.commits(userName, repo.getName())
                                .stream()
                                .map(CommitContainer::getCommit)
                                .map(CommitContainer.Commit::getMessage)
                                .collect(toList())))
                .collect(toList());


        return new Report(userName, repos);

    }
}
