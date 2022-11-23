public class Test {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("tuy");
        list.add("anh");
        list.add("không");
        list.add("giàu");

        print(list.getElements());
        System.out.println(list.indexOf("không"));
        System.out.println(list.indexOf("có"));
        list.remove(2);
        print(list.getElements());
        list.add("rất", 2);
        print(list.getElements());

        MyList<String> clone = list.clone();
        System.out.println(clone.contains("anh"));
        System.out.println(clone.contains("nghèo"));
        System.out.println(clone.get(1));
        System.out.println(clone.size());
        clone.clear();
        System.out.println(clone.size());
        print(clone.getElements());
    }

    static void print(Object[] list) {
        for (Object x : list) {
            if (!(x == null)) {
                System.out.println((String) x);
            }
        }
        System.out.println("\n");
    }
}
