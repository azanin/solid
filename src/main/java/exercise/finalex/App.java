package exercise.finalex;

import exercise.finalex.api.GitHub;
import exercise.finalex.api.GitHubAdapter;
import exercise.finalex.encoders.JsonReportEncoder;
import exercise.finalex.encoders.PlainReportEncoder;
import exercise.finalex.encoders.ReportEncoder;
import exercise.finalex.model.Report;
import exercise.finalex.repository.ReportRepository;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import java.io.IOException;

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

        ReportEncoder jsonReportEncoder = new JsonReportEncoder();

        ReportEncoder customReportEncoder = new PlainReportEncoder();

        ReportRepository reportRepository = new ReportRepository(gitHubAdapter);

        Report report = reportRepository.reportsFor("ekmett");

        Report starredReport = report.forMostStarredRepo();

        String json = jsonReportEncoder.encode(report);

        String custom = customReportEncoder.encode(starredReport);



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


    private String format(String user, int num, String repoName, int numStars, String description) {
        return user + " owns " + num + " repos. \n" +
                "His most starred one is " + repoName + " with " + numStars + " stars. \n" +
                "Here is a brief description: " + description + ". \n";
    }
}


