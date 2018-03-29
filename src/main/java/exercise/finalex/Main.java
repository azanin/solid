package exercise.finalex;

import exercise.finalex.api.GitHubInvoker;
import exercise.finalex.encoders.ReportEncoder;
import exercise.finalex.model.Report;
import exercise.finalex.repository.ReportRepository;

import static exercise.finalex.SystemConfigurator.*;
import static exercise.finalex.SystemConfigurator.provideJsonEncoder;
import static exercise.finalex.SystemConfigurator.providePlainEncoder;

public class Main {

    public static void main(String ...s) {

        ReportRepository repository =
                provideRepository(
                        provideHttpApi(
                                provideHttpInvoker(
                                        provideUrl(), GitHubInvoker.class)));

        ReportEncoder jsonEnc = provideJsonEncoder(provideJsonAdapter(Report.class));
        ReportEncoder plainEnc = providePlainEncoder();

        //provide printer for the console

        //provide printer for a json file

        new App(repository, null, null).run();
    }
}
