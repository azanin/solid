package exercise.finalex.encoders;

import com.squareup.moshi.Moshi;
import exercise.finalex.model.Repo;
import exercise.finalex.model.Report;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class JsonReportEncoderTest {

    @Test
    public void encode() {

        Report input = new Report("John", asList(
                new Repo(1, "repo1", "descr1", asList("Initial commit", "Fix initial commit")),
                new Repo(11, "repo2", "descr2", singletonList("Greatest initial commit"))));

        JsonReportEncoder sut = new JsonReportEncoder(new Moshi.Builder().build().adapter(Report.class));
        Json actual = sut.encode(input);

        Json expected = Json.from("{\"repos\":" +
                "[" +
                "{\"commits\":[\"Initial commit\",\"Fix initial commit\"],\"description\":\"descr1\",\"name\":\"repo1\",\"stars\":1}," +
                "{\"commits\":[\"Greatest initial commit\"],\"description\":\"descr2\",\"name\":\"repo2\",\"stars\":11}" +
                "]," +
                "\"username\":\"John\"}");

        assert actual.equals(expected);
    }
}
