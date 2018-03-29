package exercise.finalex.api;

import exercise.finalex.api.data.CommitContainer;
import exercise.finalex.api.data.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface GitHubInvoker {

    @GET("/users/{owner}/repos?")
    Call<List<Repository>> repos(
            @Path("owner") String owner,
            @Query("access_token") String accessToken
    );

    @GET("/repos/{owner}/{repo}/commits?")
    Call<List<CommitContainer>> commits(
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Query("access_token") String accessToken
    );

}
