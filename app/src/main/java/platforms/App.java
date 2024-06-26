/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package platforms;

import org.checkerframework.checker.units.qual.C;

import java.util.Arrays;
import java.util.List;

public class App {


    public static void main(String[] args) {

        var calculator = new Calculator();

        System.out.println("""
                Number of platforms required for this timetable:
                [(10, 11), (12, 13), (14, 15), (09, 20)] """);
        try {
            System.out.println("# platforms required: %d\n".formatted(
                    calculator.calculatePlatforms(List.of(
                            new TrainSchedule("10", "11"),
                            new TrainSchedule("12", "13"),
                            new TrainSchedule("14", "15"),
                            new TrainSchedule("09", "20")))));
        } catch (RuntimeException exception) {
            printErrorMessage(exception);
        }

            System.out.println("""
                    Number of platforms required for this timetable:
                    [(20, 11), (09, 20)] """);
            try {
                System.out.println("# platforms required: %d\n".formatted(
                        calculator.calculatePlatforms(List.of(
                                new TrainSchedule("20", "11"),
                                new TrainSchedule("09", "20")
                        ))));
            } catch (RuntimeException exception) {
                printErrorMessage(exception);
            }

            System.out.println("""
                    Number of platforms required for this timetable:
                    [(900, 1000), (815, 915), (955, 1005), (450, 1010)] """);
            try {
                System.out.println("# platforms required: %d\n".formatted(
                        calculator.calculatePlatforms(List.of(
                                new TrainSchedule("9:00", "10:00"),
                                new TrainSchedule("8:15", "9:15"),
                                new TrainSchedule("9:55", "10:05"),
                                new TrainSchedule("4:50", "10:00")
                        ))));
            } catch (RuntimeException exception) {
                printErrorMessage(exception);
            }
    }

    private static void printErrorMessage(RuntimeException exception) {
        System.out.println("========================================");
        System.out.println(exception.getMessage());
        System.out.println("========================================\n");
    }

}
