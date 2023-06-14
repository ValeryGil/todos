import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldCheckQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] array = todos.findAll();

        boolean[] expected = {false, true, false};
        boolean[] actual = new boolean[3];

        for (int i = 0; i < array.length; i++) {
            actual[i] = array[i].matches("Хлеб");
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckQueryAllFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] array = todos.findAll();

        boolean[] expected = {false, false, false};
        boolean[] actual = new boolean[3];

        for (int i = 0; i < array.length; i++) {
            actual[i] = array[i].matches("Выпуск");
        }

        Assertions.assertArrayEquals(expected, actual);
    }
}
