package exercise.finalex;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import exercise.finalex.api.GitHubInvoker;
import exercise.finalex.api.GitHubAdapter;
import exercise.finalex.api.GitHubApi;
import exercise.finalex.encoders.JsonReportEncoder;
import exercise.finalex.encoders.CustomReportEncoder;
import exercise.finalex.encoders.ReportEncoder;
import exercise.finalex.model.Report;
import exercise.finalex.repository.ReportRepository;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class SystemConfigurator {

    private SystemConfigurator() {
    }

    public static String provideUrl() {
        return "https://api.gitHub.com";
    }

    public static <Invoker> Invoker provideHttpInvoker(String apiUrl, Class<Invoker> invokerclass) {
        // Create a very simple REST adapter which points the GitHubInvoker API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        // Create an instance of our GitHubInvoker API interface.
        return retrofit.create(invokerclass);
    }

    public static GitHubApi provideHttpApi(GitHubInvoker invoker) {
        return new GitHubAdapter(invoker);
    }

    public static ReportRepository provideRepository(GitHubApi api) {
        return new ReportRepository(api);
    }

    public static ReportEncoder providePlainEncoder() {
        return new CustomReportEncoder();
    }

    public static <T> JsonAdapter<T> provideJsonAdapter(Class<T> modelClass) {
        return new Moshi.Builder().build().adapter(modelClass);
    }

    public static  ReportEncoder provideJsonEncoder(JsonAdapter<Report> adapter) {
        return new JsonReportEncoder(adapter);
    }

}
