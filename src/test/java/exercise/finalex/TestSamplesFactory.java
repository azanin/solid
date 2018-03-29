package exercise.finalex;

import exercise.finalex.api.data.Repository;

public class TestSamplesFactory {

    public static Repository aRepoWithName(String name) {
        return new Repository(
                "id", name, 10, "descr", "https://api.github.blablabla.com");
    }
}
