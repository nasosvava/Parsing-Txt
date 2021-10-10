import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);
    public static int checkingIntegers() {

        int number;

        while (true) {
            try {
                number = Integer.parseInt(scanner.next());

                break;
            } catch (NumberFormatException nfe) {
                System.out.println(Colour.TEXT_RED + "Please give only number." + Colour.TEXT_RESET);
            }
        }
        return number;
    }

    /**
     * We check if the integers are integers or the user did a mistake. With 2
     * parameters of min and max.
     *
     * @param min
     * @param max
     * @return integer
     */
    public static int checkingIntegers(int min, int max) {

        int result = Utils.checkingIntegers();
        boolean quit = false;
        while (!quit) {
            if (result < min || result > max) {
                System.out.println(Colour.TEXT_RED + "Please give the right number" + Colour.TEXT_RESET);
                result = Utils.checkingIntegers();
            } else {
                quit = true;
            }
        }
        return result;
    }
}
