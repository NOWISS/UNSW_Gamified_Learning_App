package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "qs_sys")
public class Quesstion {
    @Column(name = "id", isId = true, autoGen = true, property = "NOT NULL")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "answer")
    private String answer;
    //四个选项
    @Column(name = "answer1")
    private String answer1;
    @Column(name = "answer2")
    private String answer2;
    @Column(name = "answer3")
    private String answer3;
    @Column(name = "answer4")
    private String answer4;

    @Column(name = "status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
