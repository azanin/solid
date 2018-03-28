package exercise.finalex.repository;


import exercise.finalex.api.GitHubApi;
import exercise.finalex.api.data.Commit;
import exercise.finalex.encoders.ReportEncoder;
import exercise.finalex.model.Repo;
import exercise.finalex.model.Report;
import exercise.finalex.model.Repos;

import java.util.List;
import java.util.stream.Collectors;

public class ReportRepository {

    private final GitHubApi gitHubApi;

    public ReportRepository(GitHubApi gitHubApi) {
        this.gitHubApi = gitHubApi;
    }

    public Report reportsFor(String userName) {

        List<Repo> repos = gitHubApi.repos(userName)
                .stream()
                .map(repo -> {
                    List<Commit> comms = gitHubApi.commits(userName, repo.getName());
                    List<String> messages = comms.stream().map(Commit::getMessage)
                            .collect(Collectors.toList());

                    return new Repo(
                            repo.getStargazers(),
                            repo.getName(),
                            repo.getDescription(),
                            messages
                    );

                }).collect(Collectors.toList());


        return new Report(userName, new Repos(repos));
    }
}
