package exercise.srp;

public class SrpApp {

    public static void main(String[] args) {
        //TODO Try to print a post to console
        final Post post = new Post("aut", "title", "body");
        final PostPrinter postPrinter = new PostPrinter(post);

        System.out.println(postPrinter.plainText());
        System.out.println(postPrinter.json());

    }
}
