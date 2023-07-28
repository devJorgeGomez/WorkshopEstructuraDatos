import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> queue){
        Stack<HtmlTag> validator = new Stack<HtmlTag>();
        int tamanio= queue.size();
        for (int i=0; i < tamanio; i++){
            HtmlTag reserv=queue.poll();

            if (reserv.isSelfClosing()){

            }else if (reserv.openTag){
                validator.push(reserv);
            } else if (!reserv.openTag) {
                if (validator.empty()){
                    return null;
                }

                HtmlTag top = validator.peek();

                if (reserv.matches(top)){
                    validator.pop();
                }else {
                    return validator;
                }
            }
        }
        return validator;
    }
    public static void main(String[] args) throws IOException {
        Queue<HtmlTag> queuee = new LinkedList<HtmlTag>();
        String filepath = "src/index.html";

        queuee=HtmlReader.getTagsFromHtmlFile(filepath);
        System.out.println(queuee);

        System.out.println();

        Stack<HtmlTag> val = isValidHtml(queuee);
        System.out.println(val);
    }
}
