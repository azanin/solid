package exercise.finalex;

import exercise.finalex.model.Report;
import exercise.finalex.repository.ReportRepository;

public class App {

    private final ReportRepository repository;
    private final ReportPrinter consolePrinter;
    private final ReportPrinter jsonFilePrinter;

    public App(ReportRepository repository,
               ReportPrinter consolePrinter,
               ReportPrinter jsonFilePrinter) {
        this.repository = repository;
        this.consolePrinter = consolePrinter;
        this.jsonFilePrinter = jsonFilePrinter;
    }

    public void run() {

        Report report = repository.reportFor("ekmett");

//        String json = jsonEnc.encode(report);
//
//        String custom = plainEnc.encode(report);
//
//        printerService.printOn(json)
//        printerService.printOn(custom)

    }

}


