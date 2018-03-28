package exercise.finalex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface GitHub {

    @GET("/users/{owner}/repos")
    Call<List<Repository>> repos(
            @Path("owner") String owner
    );

    @GET("/repos/{owner}/{repo}/commits")
    Call<List<Commit>> commits(
            @Path("owner") String owner,
            @Path("repo") String repo
    );

}
