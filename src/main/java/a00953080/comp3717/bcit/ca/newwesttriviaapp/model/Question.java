package a00953080.comp3717.bcit.ca.newwesttriviaapp.model;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "QUESTION".
 */
@Entity
public class Question {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String question;

    @NotNull
    private String answer;

    @NotNull
    private String option1;

    @NotNull
    private String option2;

    @NotNull
    private String option3;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public Question() {
    }

    public Question(Long id) {
        this.id = id;
    }

    @Generated
    public Question(Long id, String question, String answer, String option1, String option2, String option3) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    public Long getId() {
        return id;
    }

    public Question setId(Long id) {
        this.id = id;
        return this;
    }

    @NotNull
    public String getQuestion() {
        return question;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public Question setQuestion(@NotNull String question) {
        this.question = question;
        return this;
    }

    @NotNull
    public String getAnswer() {
        return answer;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public Question setAnswer(@NotNull String answer) {
        this.answer = answer;
        return this;
    }

    @NotNull
    public String getOption1() {
        return option1;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public Question setOption1(@NotNull String option1) {
        this.option1 = option1;
        return this;
    }

    @NotNull
    public String getOption2() {
        return option2;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public Question setOption2(@NotNull String option2) {
        this.option2 = option2;
        return this;
    }

    @NotNull
    public String getOption3() {
        return option3;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public Question setOption3(@NotNull String option3) {
        this.option3 = option3;
        return this;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}