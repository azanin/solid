package exercise.finalex.encoders;

import com.squareup.moshi.JsonAdapter;
import exercise.finalex.model.Report;

public class JsonReportEncoder implements ReportEncoder<Json> {

    private final JsonAdapter<Report> jsonAdapter;

    public JsonReportEncoder(JsonAdapter<Report> jsonAdapter) {
        this.jsonAdapter = jsonAdapter;
    }

    @Override
    public Json encode(Report report) {
        final String content = jsonAdapter.toJson(report);
        return Json.from(content);
    }
}
