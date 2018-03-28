package exercise.finalex;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class App {

    public static final String API_URL = "https://api.gitHub.com";

    public static void main(String... args) throws IOException {

        // Create a very simple REST adapter which points the GitHub API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        // Create an instance of our GitHub API interface.
        GitHub github = retrofit.create(GitHub.class);

        GitHubAdapter gitHubAdapter = new GitHubAdapter(github);

        Stream<List<Commit>> ekmett = gitHubAdapter.repos("ekmett")
                .stream()
                .map((Repository repo) -> gitHubAdapter.commits("ekmett", repo.getName()));

    }

//    {
//        "user": "ekmett",
//            "repos": [{
//        "id": 85458673,
//                "username": "compiler",
//                "stargazers": 10,
//                "description": "description",
//                "commits": ["commit message1","commit message2"]
//    }]
//    }

    public static class Report {
        private final String username;
        private final Repos repos;

        public Report(String username, Repos repos) {
            this.username = username;
            this.repos = repos;
        }

        public String getUsername() {
            return username;
        }

        public Repos getRepos() {
            return repos;
        }
    }

    private static class Repos {
        private final List<Repo> repos;

        private Repos(List<Repo> repos) {
            this.repos = repos;
        }

        public Optional<Repo> mostStarredRepo() {
            return repos.stream().max(Comparator.comparingInt(o -> o.stars));
        }

        public int repoCount() {
            return repos.size();
        }
    }

    public static class Repo {
        private final int stars;
        private final String name;
        private final String description;
        private final List<String> commits;

        public Repo(int stars, String name, String description, List<String> commits) {
            this.stars = stars;
            this.name = name;
            this.description = description;
            this.commits = commits;
        }
    }

    private String format(String user, int num, String repoName, int numStars, String description) {
        return user + " owns " + num + " repos. \n" +
                "His most starred one is " + repoName + " with " + numStars + " stars. \n" +
                "Here is a brief description: " + description + ". \n";
    }
}


