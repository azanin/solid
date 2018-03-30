package exercise.finalex.model;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportTest {

    @Test
    public void repoCount() {
        final Report sut = new Report("aUser",
                Arrays.asList(
                        new Repo(1, "name1", "descr", Collections.emptyList()),
                        new Repo(2, "name2", "descr", Collections.emptyList()),
                        new Repo(2, "name3", "descr", Collections.emptyList())
                ));

        assertThat(sut.repoCount(), is(3));

    }

    @Test
    public void repoCount_WhenNoRepo() {
        final Report sut = new Report("aUser",
                Collections.emptyList());

        assertThat(sut.repoCount(), is(0));

    }

    @Test
    public void mostStarredRepo_WhenEmpty() {

        final Report sut = new Report("aUser",
                Collections.emptyList());

        assertThat(sut.mostStarredRepo(), is(Optional.empty()));
    }

    @Test
    public void mostStarredRepo_WhenFull() {

        final Repo starred = new Repo(2, "name2", "descr", Collections.emptyList());

        final Report sut = new Report("aUser",
                Arrays.asList(
                        new Repo(1, "name1", "descr", Collections.emptyList()),
                        starred,
                        new Repo(2, "name3", "descr", Collections.emptyList())
                ));

        assertThat(sut.mostStarredRepo(), is(Optional.of(starred)));

    }
}