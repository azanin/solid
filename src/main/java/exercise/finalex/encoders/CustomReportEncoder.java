package exercise.finalex.encoders;

import exercise.finalex.model.Report;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CustomReportEncoder implements ReportEncoder<Custom> {

    @Override
    public Custom encode(Report report) {
        throw new NotImplementedException();
    }

}
