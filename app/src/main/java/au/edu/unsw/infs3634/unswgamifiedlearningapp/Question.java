package au.edu.unsw.infs3634.unswgamifiedlearningapp;


import java.util.ArrayList;

public class Question {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answerNr;

    public Question() {
    }

    public Question(String question, String option1, String option2, String option3, String option4, String answerNr) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
    }

     String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getOption1() {
        return option1;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption2() {
        return option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption3() {
        return option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public String getOption4() {
        return option4;
    }
    public void setOption4(String option4) {
        this.option4 = option4;
    }
    public String getAnswerNr() { return answerNr; }
    public void setAnswerNr(String answerNr) {
        this.answerNr = answerNr;
    }

    public static ArrayList<Question> getEQuestions(){
        ArrayList list = new ArrayList();
        list.add(new Question("How can climate change impact the environment?","Rising of sea levels","Increase chance of bushfires","More extreme weather events","all of the above","all of the above"));
        list.add(new Question("Why are too many greenhouse gases in the atmosphere dangerous?", "They trap excess heat on Earth","They help plants grow","Sea levels may lower","None of the above","They trap excess heat on Earth"));
        list.add(new Question("How can we tackle the issue of climate change?", "Avoid using renewable energy","Minimise the use of fossil fuels","Release more greenhouse gases","Burn excess woodlands","Minimise the use of fossil fuels"));
        list.add(new Question("What is the contribution of transportation toward greenhouse gas emissions?","100%","1%","14%","50%","14%"));
        list.add(new Question("Which of these countries currently emit the most carbon dioxide?","Australia","Germany","China","America","China"));
        list.add(new Question("How is the greenhouse effect caused?","Excess heat in the atmosphere","Greenhouse gases in the atmosphere","Excess solar radiation","None of the above","Greenhouse gases in the atmosphere"));
        return list;
    }
}
