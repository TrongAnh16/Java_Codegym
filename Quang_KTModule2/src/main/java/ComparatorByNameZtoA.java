import java.util.Comparator;

public class ComparatorByNameZtoA implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {

        if (o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()) > 1) {
            return -1;
        } else if (o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
