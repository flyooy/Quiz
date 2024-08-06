public class Main {
    public static void main(String[] args) {
        // Erstellen eines Quiz
        Quiz quiz = new Quiz();

        // Erstellen von Fragen
        String description1 = "Was ist die Hauptstadt von Luxemburg?";
        String[] choices1 = {"Luxemburg", "Angola", "Berlin", "NRW"};
        String[] correctChoices1 = {"Luxemburg"};
        Question question1 = new Question(description1, choices1, correctChoices1);

        String description2 = "Welches Land hat die größte Bevölkerung?";
        String[] choices2 = {"China", "Indien", "USA", "Brasilien"};
        String[] correctChoices2 = {"China"};
        Question question2 = new Question(description2, choices2, correctChoices2);

        String description3 = "Welches dieser Länder liegen in Asien?";
        String[] choices3 = {"China", "Indien", "USA", "Brasilien"};
        String[] correctChoices3 = {"China", "Indien"};
        Question question3 = new Question(description3, choices3, correctChoices3);

        // Hinzufügen von Fragen zum Quiz
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);

        // Erstellen eines Benutzers
        User user = new User("Alice");

        // Durchführen des Quiz
        int correctAnswers = quiz.askQuestions(user);

        // Ausgabe der Ergebnisse
        System.out.println("Quiz abgeschlossen!");
        System.out.println("Benutzer: " + user.getUsername());
        System.out.println("Erzielte Punkte: " + user.getScore());
        System.out.println("Anzahl der richtigen Antworten: " + correctAnswers + " von " + quiz.getQuestions().size());
    }
}