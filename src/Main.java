import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<HtmlTag> queuee = new LinkedList<HtmlTag>();
        String filepath = "src/index.html";

        queuee=HtmlReader.getTagsFromHtmlFile(filepath);
        System.out.println(queuee);

        System.out.println();

        Stack<HtmlTag> val = HtmlValidator.isValidHtml(queuee);
        System.out.println(val);
    }
}


