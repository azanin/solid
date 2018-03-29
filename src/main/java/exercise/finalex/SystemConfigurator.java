package exercise.finalex;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import exercise.finalex.api.GitHubAdapter;
import exercise.finalex.api.GitHubApi;
import exercise.finalex.api.GitHubInvoker;
import exercise.finalex.encoders.*;
import exercise.finalex.model.Report;
import exercise.finalex.model.Unit;
import exercise.finalex.repository.ReportRepository;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.function.Function;

class SystemConfigurator {

    private SystemConfigurator() {
    }

    static String provideUrl() {
        return "https://api.gitHub.com";
    }

    static <Invoker> Invoker provideHttpInvoker(String apiUrl, Class<Invoker> invokerclass) {
        // Create a very simple REST adapter which points the GitHubInvoker API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        // Create an instance of our GitHubInvoker API interface.
        return retrofit.create(invokerclass);
    }

    static GitHubApi provideHttpApi(GitHubInvoker invoker) {
        return new GitHubAdapter(invoker);
    }

    static ReportRepository provideRepository(GitHubApi api) {
        throw new NotImplementedException();
    }

    static ReportEncoder<Custom> provideCustomEncoder() {
        return new CustomReportEncoder();
    }

    static <T> JsonAdapter<T> provideJsonAdapter(Class<T> modelClass) {
        return new Moshi.Builder().build().adapter(modelClass);
    }

    static ReportEncoder<Json> provideJsonEncoder(JsonAdapter<Report> adapter) {
        return new JsonReportEncoder(adapter);
    }

    static ReportPrinter<Json, Unit> provideJsonConsolePrinter(ReportEncoder<Json> jsonReportEncoder) {

        Function<Json, Effect<Unit>> f = new Function<Json, Effect<Unit>>() {
            @Override
            public Effect<Unit> apply(Json json) {

                Effect<Unit> e = () -> {
                    System.out.println(json.getContent());
                    return Unit.value;
                };
                return e;
            }
        };

        return new ReportPrinter<>(jsonReportEncoder, f);
    }


    static ReportPrinter<Custom, Unit> provideCustomConsolePrinter(ReportEncoder<Custom> customEnc) {

        Function<Custom, Effect<Unit>> fun = customFormat -> () -> {
            System.out.println(customFormat.getContent());
            return Unit.value;
        };

        return new ReportPrinter<>(customEnc, fun);
    }

}
