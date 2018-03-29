package exercise.finalex;

import exercise.finalex.encoders.DataType;
import exercise.finalex.model.Report;
import exercise.finalex.model.Result;
import exercise.finalex.model.Unit;
import exercise.finalex.repository.ReportRepository;

import java.util.List;

public class App {

    private final ReportRepository repository;
    private final List<ReportPrinter<? extends DataType, Unit>> printers;

    App(ReportRepository repository, List<ReportPrinter<? extends DataType, Unit>> printers) {
        this.repository = repository;
        this.printers = printers;
    }

    public Result<Unit> generateRportsFor(String userName) {

        Report report = repository.reportFor(userName);

        for (ReportPrinter<? extends DataType, Unit> reportPrinter : printers) {
            Result<Unit> observableSideEffect = reportPrinter.printOf(report);
            if(observableSideEffect.isFailure())
                return observableSideEffect;
        }

        return Result.success(Unit.value);
    }

}


