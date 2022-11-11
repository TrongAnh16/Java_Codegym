public class countCharacters {
    public static void main(String[] args) {
        String[] doctorine = {"T", "o", "n", "y", "T", "o", "n", "y", "C", "h", "o", "p", "p", "e", "r", "T", "o", "n", "y"};
        int count = 0;
        for (int i = 0; i < doctorine.length; i++) {
            if (doctorine[i].equals("T")) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
