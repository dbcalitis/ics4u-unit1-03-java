/*
* The Energy program allows the user to calculate
* the object's energy in joules through its mass
*
* @author  Daria Bernice Calitis
* @version 1.0
* @since   2022-09-15
*/

// Import Scanner
import java.util.Scanner;

/**
* .Class constructor Microwave.
*/
final class Microwave {
    /**
     * A minute in seconds.
     */
    public static final int MINUTE = 60;

    /**
     * Amount of seconds to microwave a sub.
     */
    public static final int SUB_TIME = 60;

    /**
     * Amount of seconds to microwave a pizza.
     */
    public static final int PIZZA_TIME = 45;

    /**
     * Amount of seconds to microwave a soup.
     */
    public static final int SOUP_TIME = 105;

    /**
     * Max amount of food in Microwave.
     */
    public static final int MAX_FOOD = 3;

    /**
     * Invalid input message.
     */
    public static final String ERR_MSG = "Invalid Input.";

    /**
     * Prevent instantiation.
     * Throw an exception IllegalStateException
     * if this ever is called
     *
     * @throws IllegalStateException
     *
     */
    private Microwave() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(final String[] args) {
        // Create Scanner Object
        final Scanner scan = new Scanner(System.in);
        System.out.print("Are you heating sub, pizza, or soup?: ");

        try {
            // Gets the food
            final String food = scan.nextLine();
            int foodTime = 0;

            switch (food) {
                case "sub":
                    foodTime = SUB_TIME;
                    break;
                case "pizza":
                    foodTime = PIZZA_TIME;
                    break;
                case "soup":
                    foodTime = SOUP_TIME;
                    break;
                default:
                    System.out.println(ERR_MSG);
            }

            if (foodTime != 0) {
                // Input for amount of food
                System.out.printf("How many %s(s) are you cooking? (max:3): ",
                    food
                );
                final int amountFood = scan.nextInt();

                if (!(amountFood > MAX_FOOD)) {
                    // Amount of time that it would
                    // take to microwave the food
                    final int amountTime = amountFood * foodTime;

                    // Prints out the duration
                    System.out.printf(
                        "The total cook time is %s minutes and %s seconds.\n",
                        (int) Math.floor(amountTime / MINUTE),
                        (int) amountTime % MINUTE
                    );
                } else {
                    System.out.println(ERR_MSG);
                }
            }
        } catch (java.util.InputMismatchException error) {
            System.out.println(ERR_MSG);
        }

        System.out.println("\nDone.");
    }
}
