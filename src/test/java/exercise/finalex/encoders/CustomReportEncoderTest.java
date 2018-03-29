package exercise.finalex.encoders;

import exercise.finalex.model.Repo;
import exercise.finalex.model.Report;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class CustomReportEncoderTest {

    @Test
    public void encode() {

        Report input = new Report("John", asList(
                new Repo(1, "repo1", "descr1", asList("Initial commit", "Fix initial commit")),
                new Repo(11, "repo2", "descr2", singletonList("Greatest initial commit"))));

        CustomReportEncoder sut = new CustomReportEncoder();
        Custom actual = sut.encode(input);

        Custom expected = Custom.from("John owns 2 repos.\n" +
                "His most starred one is repo2 with 11 stars.\n" +
                "Here is a brief description: descr2.\n");

        assert actual.equals(expected);
    }

    @Test
    public void encodeNoRepos() {

        Report input = new Report("John", emptyList());

        CustomReportEncoder sut = new CustomReportEncoder();
        Custom actual = sut.encode(input);

        Custom expected = Custom.from("For the user John there aren't any repos.");

        assert actual.equals(expected);
    }
}
