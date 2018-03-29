package exercise.finalex;

import exercise.finalex.encoders.ReportEncoder;
import exercise.finalex.model.Report;
import exercise.finalex.model.Result;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.function.Function;

public class ReportPrinter<EncodeTo, Media> {

    private final ReportEncoder<EncodeTo> encoder;
    private final Function<EncodeTo, Effect<Media>> toSideEffect;

    ReportPrinter(ReportEncoder<EncodeTo> encoder, Function<EncodeTo, Effect<Media>> toSideEffect) {
        this.encoder = encoder;
        this.toSideEffect = toSideEffect;
    }

    public Result<Media> printOf(Report report) {
//        ...
//        return Result.fromEffect("Report Printer", ...);
        throw new NotImplementedException();
    }

}
