package exercise.srp;

public class PostPrinter {

    private Post post;

    public PostPrinter(Post post) {
        this.post = post;
    }

    public String plainText() {
        return String.format("author: %s, title: %s, body: %s",
                post.getAuthor(), post.getTitle(), post.getBody());
    }

    public String json() {
        return "{" +
                "/t\"author\": " + post.getAuthor() +
                "/t\"title\": " + post.getTitle() +
                "/t\"body\": " + post.getBody() +
                "}";
    }
}
