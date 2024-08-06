import java.util.*;

public class Quiz {
    private List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public int askQuestions(User user) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        for (Question question : questions) {
            System.out.println(question.getDescription());
            System.out.println(Arrays.toString(question.getChoices()));
            System.out.println("Bitte wählen Sie Ihre Antworten(geben Sie die Nummern (1-4) durch Kommas getrennt ein):");
            String inputUser = scanner.nextLine();
            String[] indices = inputUser.split("\\s*,\\s*");
            String[] chosen = new String[indices.length];

            for (int i = 0; i < indices.length; i++) {
                int index = Integer.parseInt(indices[i].trim()) - 1;
                if (index >= 0 && index < question.getChoices().length) {
                    chosen[i] = question.getChoices()[index];
                }
            }
           if (question.answerQuestion(chosen)) {
               count++;
               user.incrementScore();
               System.out.println("Ihre Antworten:" + Arrays.toString(chosen));
               System.out.println("Correct!");
           }else {
               System.out.println("Ihre Antworten:" + Arrays.toString(chosen));
               System.out.println("Wrong!");
           }
        }
        return count;
    }

    public List<Question> getQuestions() {
        return questions;
    }


}
