import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSimpleTaskNoMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);


    }


    @Test
    public void testEpicMatches() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Хлеб");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicNoMatches() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Картофель");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingMatchesTopic() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingMatchesProject() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Приложение НетоБанка");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingNoMatches() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Приложение Сбера");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }
}