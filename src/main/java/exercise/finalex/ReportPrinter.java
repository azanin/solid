package exercise.finalex;

import exercise.finalex.encoders.ReportEncoder;
import exercise.finalex.model.Report;

public class ReportPrinter<EncodeTo,Media> {

    private final ReportEncoder<EncodeTo> encoder;

    public ReportPrinter(ReportEncoder<EncodeTo> encoder) {
        this.encoder = encoder;
    }

    public Media printOf(Report report) {
        final EncodeTo encode = encoder.encode(report);
        //....
        return null;
    }

}
