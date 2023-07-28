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
}
