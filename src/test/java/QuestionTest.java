import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import java.io.ByteArrayInputStream;


public class QuestionTest {
    @Test
    public void testQuestion() {
        String choices[] = { "Luxemburg", "Angola", "Berlin", "NRW" };
        String  correctChoices[] = { "Berlin" };
        Question q = new Question("Was ist die Hauptstadt von Deutschland?",choices,correctChoices);

        String[] chosen = { "Berlin" };
        assertTrue(q.answerQuestion(chosen));

        String[] wrongChosen = { "Luxemburg" };
        assertFalse(q.answerQuestion(wrongChosen));
    }

    @Test
    public void testInvalidDescription() {
        String[] choices = { "Luxemburg", "Angola", "Berlin", "NRW" };
        String[] correctChoices = { "Berlin" };

        assertThrows(IllegalArgumentException.class, () -> {
            new Question("Was ist die Hauptstadt von Deutschland", choices, correctChoices);
        });
    }

    @Test
    public void testInvalidChoices() {

        String[] choices = { "Berlin" };
        String[] correctChoices = { "Berlin" };

        assertThrows(IllegalArgumentException.class, () -> {
            new Question("Was ist die Hauptstadt von Deutschland?", choices, correctChoices);
        });
    }

    @Test
    public void testInvalidCorrectChoices() {
        String[] choices = { "Luxemburg", "Angola", "Berlin", "NRW" };
        String[] invalidCorrectChoices = { "Paris" };

        assertThrows(IllegalArgumentException.class, () -> {
            new Question("Was ist die Hauptstadt von Deutschland?", choices, invalidCorrectChoices);
        });
    }

    @Test
    public void testAddQuestion(){
        Quiz quiz = new Quiz();

        String description1 = "Was ist die Hauptstadt von Luxemburg?";
        String[] choices1 = {"Luxemburg", "Angola", "Berlin", "NRW"};
        String[] correctChoices1 = {"Luxemburg"};
        Question question1 = new Question(description1, choices1, correctChoices1);
        quiz.addQuestion(question1);

        assert quiz.getQuestions().size() == 1 : "Frage wurde nicht korrekt hinzugefügt";
    }

    @Test
    public void testMultipleCorrectChoices(){
        Quiz quiz = new Quiz();
        String description1 = "Was ist die Hauptstadt von Luxemburg?";
        String[] choices1 = {"Luxemburg", "Angola", "Berlin", "NRW"};
        String[] correctChoices1 = {"Luxemburg", "Berlin"};
        Question question1 = new Question(description1, choices1, correctChoices1);
        quiz.addQuestion(question1);
        User user = new User("Alice");
        String input = "1,3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int correctAnswers = quiz.askQuestions(user);

        assert user.getScore() == 1 : "Punktzahl wurde nicht korrekt aktualisiert";
    }


    @Test
    public void testUserAnswerAndScoreUpdate(){
        Quiz quiz = new Quiz();
        String description1 = "Was ist die Hauptstadt von Luxemburg?";
        String[] choices1 = {"Luxemburg", "Angola", "Berlin", "NRW"};
        String[] correctChoices1 = {"Luxemburg"};
        Question question1 = new Question(description1, choices1, correctChoices1);
        quiz.addQuestion(question1);
        User user = new User("Alice");
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int correctAnswers = quiz.askQuestions(user);
        assert user.getScore() == 1 : "Punktzahl wurde nicht korrekt aktualisiert";
    }

    @Test
    public void testGetUsername() {
        User user = new User("Alice");
        assert user.getUsername().equals("Alice") : "getUsername() funktioniert nicht korrekt";
    }

    @Test
    public void testGetScore() {
        User user = new User("Alice");
        assert user.getScore() == 0 : "getScore() funktioniert nicht korrekt";
    }

    @Test
    public void testIncrementScore() {
        User user = new User("Alice");
        user.incrementScore();
        assert user.getScore() == 1 : "incrementScore() funktioniert nicht korrekt";
    }

}
