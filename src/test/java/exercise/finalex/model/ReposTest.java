//package exercise.finalex.model;
//
//import exercise.finalex.api.data.Commit;
//import org.junit.Test;
//import scala.collection.immutable.List;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//import static org.junit.Assert.*;
//
//public class ReposTest {
//
//    @Test
//    public void mostStarredRepo() {
//        final Repo repo1 = new Repo(3, "a", "descr", Collections.emptyList());
//        final Repo repo2 = new Repo(3, "b", "descr", Collections.emptyList());
//        final Repos repos = new Repos(Arrays.asList(repo2, repo1));
//        assert repos.mostStarredRepo().get().getName() == "a";
//
//    }
//}