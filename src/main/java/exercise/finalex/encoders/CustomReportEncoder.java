package exercise.finalex.encoders;

import exercise.finalex.model.Repo;
import exercise.finalex.model.Report;

import java.util.Collections;

public class CustomReportEncoder implements ReportEncoder<Custom> {

    private final String customFormat = "%s owns %d repos.\n" +
            "His most starred one is %s with %d stars.\n" +
            "Here is a brief description: %s.\n";

    private final String errorFormat = "For the user %s there aren't any repos.";

    @Override
    public Custom encode(Report report) {

        if (report.mostStarredRepo().isPresent()) {
            Repo repo = report.mostStarredRepo().get();
            return Custom.from(
                    String.format(customFormat,
                            report.getUsername(),
                            report.repoCount(),
                            repo.getName(),
                            repo.getStars(),
                            repo.getDescription())
            );
        }
        else
            return Custom.from(String.format(errorFormat, Collections.singletonList(report.getUsername())));
    }

}
