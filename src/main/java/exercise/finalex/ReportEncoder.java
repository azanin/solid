package exercise.finalex;

import java.io.OutputStream;

public interface ReportEncoder<T> {
    T encode(App.Report report);
}

class JsonReportEncoder implements ReportEncoder<String> {

    @Override
    public String encode(App.Report report) {
        return null;
    }
}

class FileReportEncoder implements ReportEncoder<OutputStream> {

    @Override
    public OutputStream encode(App.Report report) {
        return null;
    }
}
