import java.util.LinkedList;
import java.util.Stack;

public class CharESCMaxLength {
    public static void main(String[] args) {
        String character = "jtgnrke saoufodsas fjdsk";
            LinkedList <Character> linkedList = new LinkedList<>();
            linkedList.add(character.charAt(0));
            for (int i = 1; i < character.length(); i++) {
                if (character.charAt(i) > linkedList.getLast()) {
                    linkedList.addLast(character.charAt(i));
                }
        }
        System.out.println(linkedList);
    }
}
