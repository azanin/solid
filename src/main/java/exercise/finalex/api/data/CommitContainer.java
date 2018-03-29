package exercise.finalex.api.data;

public class CommitContainer {

    private final Commit commit;

    public CommitContainer(Commit commit) {
        this.commit = commit;
    }

    public Commit getCommit() {
        return commit;
    }


    public static class Commit {
        private final String message;

        public Commit(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }
}
