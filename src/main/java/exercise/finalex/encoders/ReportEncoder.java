package exercise.finalex.encoders;

import exercise.finalex.model.Report;

public interface ReportEncoder<EncodeTo> {
    EncodeTo encode(Report report);
}

