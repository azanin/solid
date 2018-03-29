package exercise.finalex;

import exercise.finalex.api.GitHubInvoker;
import exercise.finalex.encoders.Custom;
import exercise.finalex.encoders.DataType;
import exercise.finalex.encoders.Json;
import exercise.finalex.model.Report;
import exercise.finalex.model.Unit;
import exercise.finalex.repository.ReportRepository;

import java.util.Arrays;
import java.util.List;

import static exercise.finalex.SystemConfigurator.*;
import static exercise.finalex.SystemConfigurator.provideJsonEncoder;
import static exercise.finalex.SystemConfigurator.provideCustomEncoder;

public class Main {

    public static void main(String... s) {

        ReportRepository repository =
                provideRepository(
                        provideHttpApi(
                                provideHttpInvoker(
                                        provideUrl(), GitHubInvoker.class)));

        ReportPrinter<Json, Unit> consoleJsonPrinter =
                provideJsonConsolePrinter(
                        provideJsonEncoder(
                                provideJsonAdapter(Report.class)));

        ReportPrinter<Custom, Unit> consoleCustomPrinter =
                provideCustomConsolePrinter(
                        provideCustomEncoder());

        List<ReportPrinter<? extends DataType, Unit>> printers =
                Arrays.asList(consoleCustomPrinter, consoleJsonPrinter);

        new App(repository, printers)
                .generateRportsFor("azanin")
                .get();
    }
}
