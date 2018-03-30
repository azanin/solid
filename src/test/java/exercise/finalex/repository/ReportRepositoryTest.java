package exercise.finalex.repository;

import exercise.finalex.TestSamplesFactory;
import exercise.finalex.api.GitHubApi;
import exercise.finalex.api.data.CommitContainer;
import exercise.finalex.api.data.CommitContainer.Commit;
import exercise.finalex.api.data.Repository;
import exercise.finalex.model.Report;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportRepositoryTest {

    @Test
    public void testSomeRepo() {
        final Repository sampleRepo = TestSamplesFactory.aRepoWithName("aRepoName");
        final GitHubApi gitHubApiTest = new GitHubApiStub(
                "aOwner",
                "aRepoName",
                sampleRepo,
                Collections.singletonList(new CommitContainer(new Commit("message"))));

        final ReportRepository sut = new ReportRepository(gitHubApiTest);
        final Report result = sut.reportFor("aOwner");

        assertThat(result.getUsername(), is("aOwner"));
        assertThat(result.mostStarredRepo().get().getName(), is("aRepoName"));
        assertThat(result.mostStarredRepo().get().getCommits().size(), is(1));
        assertThat(result.mostStarredRepo().get().getCommits().get(0), is("message"));
    }

    @Test
    public void testNoneRepo() {
        final GitHubApiStub gitHubApiTest = new GitHubApiStub(
                "aOwner",
                "aRepoName",
                TestSamplesFactory.aRepoWithName("name"),
                Collections.emptyList());

        final ReportRepository sut = new ReportRepository(gitHubApiTest);
        final Report result = sut.reportFor("anotherOwner");

        assertThat(result.mostStarredRepo().isPresent(), is(false));
        assertThat(result.getRepos().size(), is(0));

    }
}