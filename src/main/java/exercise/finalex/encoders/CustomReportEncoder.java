package exercise.finalex.encoders;

import exercise.finalex.model.Report;

import java.util.Arrays;

public class CustomReportEncoder implements ReportEncoder<Custom> {

    private final String customFormat = "%s owns %d repos.\n" +
            "His most starred one is %s with %d stars.\n" +
            "Here is a brief description: %s.\n";

    private final String errorFormat = "For the user %s there aren't any repos.";

    @Override
    public Custom encode(Report report) {

        if (report.mostStarredRepo().isPresent())
            return Custom.from(
                    String.format(customFormat,
                            Arrays.asList(
                                    report.getUsername(),
                                    report.repoCount(),
                                    report.mostStarredRepo().get()))
            );
        else
            return Custom.from(String.format(errorFormat, Arrays.asList(report.getUsername())));
    }

}
