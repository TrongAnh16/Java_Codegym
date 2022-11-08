import java.util.Scanner;

public class numberToText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (1 > 0) {
            System.out.println("Enter a number (0 - 999): ");
            String input = sc.nextLine();
            String[] inputRay = input.split("");
            while (!((input.matches("[1-9][0-9]?[0-9]")) || input.matches("[0-9]"))) {
                System.out.println("Out of ability");
                System.out.println("Enter a number (0 - 999): ");
                input = sc.nextLine();
            }
            switch (inputRay.length) {
                case 1:
                    if (inputRay[0].equals("0")) {
                        System.out.println("zero");
                    } else {
                        System.out.println(unit(inputRay[0]));
                    }
                    break;
                case 2:
                    System.out.println(ten(inputRay[0], unit(inputRay[1])));
                    break;
                case 3:
                    if ((inputRay[0].equals("0")) && (inputRay[1].equals("0"))) {
                        System.out.println(hundred(inputRay[0]));
                    } else {
                        System.out.println(hundred(inputRay[0]) + "and " + ten(inputRay[1], unit(inputRay[2])) + "\n");
                    }
                    break;
            }

        }
    }

    private static String unit(String number) {
        switch (number) {
            case "0":
            return "";

            case "1":
            return "one";

            case "2":
            return "two";

            case "3":
            return "three";

            case "4":
            return "four";

            case "5":
            return "five";

            case "6":
            return "six";

            case "7":
            return "seven";

            case "8":
            return "eight";

            case "9":
            return "nine";

            default:
                return "out of ability";
        }
    }

    private static String ten(String number, String units) {
        switch (number) {
            case "0":
                return units;
            case "1":
                switch (units) {
                    case "":
                        return "ten";
                    case "one":
                        return "eleven";
                    case "two":
                        return "twelve";
                    case "three":
                        return "thirteen";
                    case "four":
                        return "fourteen";
                    case "five":
                        return "fifteen";
                    default:
                        return units + "teen";
                }
            case "2":
                return "twenty " + units;
            case "3":
                return "thirty " + units;
            case "4":
                return "forty " + units;
            case "5":
               return "fifty " + units;
            case "8":
                return "eighty " + units;
            default:
                return unit(number) + "ty "+ units;
        }
    }
    private static String hundred(String number) {
        return unit(number) + " hundred ";
    }
}
