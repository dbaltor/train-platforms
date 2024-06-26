/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package platforms;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import java.security.InvalidParameterException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test void shouldReturn1For1Train() {
        // Given
        var timetable = List.of(new TrainSchedule("10:00", "11:00"));
        // When
        var platforms = calculator.calculatePlatforms(timetable);
        // Then
        assertEquals(1, platforms);
    }

    @Test void shouldReturn1For2TrainsWithoutOverlapping() {
        // Given
        var timetable = List.of(
                new TrainSchedule("10:00", "11:00"),
                new TrainSchedule("12:00","13:00"));
        // When
        var platforms = calculator.calculatePlatforms(timetable);
        // Then
        assertEquals(1, platforms);
    }

    @Test void shouldReturn2For2TrainsWithOverlapping() {
        // Given
        var timetable = List.of(
                new TrainSchedule("10:00", "11:00"),
                new TrainSchedule("10:30","13:00"));
        // When
        var platforms = calculator.calculatePlatforms(timetable);
        // Then
        assertEquals(2, platforms);
    }

    @Test void shouldReturn2For3TrainsWith1Overlapping() {
        // Given
        var timetable = List.of(
                new TrainSchedule("14:00","14:10"),
                new TrainSchedule("10:00", "11:00"),
                new TrainSchedule("10:30","13:00"));
        // When
        var platforms = calculator.calculatePlatforms(timetable);
        // Then
        assertEquals(2, platforms);
    }

    @Test void shouldReturn3For3TrainsWith2Overlapping() {
        // Given
        var timetable = List.of(
                new TrainSchedule("10:00", "11:00"),
                new TrainSchedule("10:30","13:00"),
        new TrainSchedule("09:00","14:10"));
        // When
        var platforms = calculator.calculatePlatforms(timetable);
        // Then
        assertEquals(3, platforms);
    }

    @Test void shouldRejectInvertedSchedule() {
        // Given
        var timetable = List.of(
                new TrainSchedule("12:00", "11:00"));
        // When
        var exception = assertThrows(RuntimeException.class,
                () -> {
                    var platforms = calculator.calculatePlatforms(timetable);
                });
        // Then
        assertEquals("Invalid schedule provided: TrainSchedule[arrival=12:00, departure=11:00]",
                exception.getMessage());
    }
}
