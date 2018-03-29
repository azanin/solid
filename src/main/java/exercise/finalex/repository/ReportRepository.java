package exercise.finalex.repository;


import exercise.finalex.api.GitHubApi;
import exercise.finalex.api.data.Commit;
import exercise.finalex.api.data.Repository;
import exercise.finalex.model.Repo;
import exercise.finalex.model.Report;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ReportRepository {

    private final GitHubApi gitHubApi;

    public ReportRepository(GitHubApi gitHubApi) {
        this.gitHubApi = gitHubApi;
    }

    public Report reportFor(String userName) {

        List<Repository> repositories = gitHubApi.repos(userName);

        List<Repo> repos = new ArrayList<>();

        for (Repository repository : repositories) {
            List<Commit> commits = gitHubApi.commits(userName, repository.getName());
            List<String> messages = new ArrayList<>();

            for (Commit commit : commits) {
                messages.add(commit.getMessage());
            }

            repos.add(new Repo(
                    repository.getStargazers(),
                    repository.getName(),
                    repository.getDescription(),
                    messages)
            );
        }

        return new Report(userName, repos);





       /* List<Repo> repositories = gitHubApi.repositories(userName)
                .stream()
                .map(repos -> new Repo(
                        repos.getStargazers(),
                        repos.getName(),
                        repos.getDescription(),
                        gitHubApi.commits(userName, repos.getName())
                                .stream()
                                .map(Commit::getMessage)
                                .collect(toList())
                ))
                .collect(toList());*/

    }
}
