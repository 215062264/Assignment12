package ac.za.domain.academicResults;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Quiz {

    private String dueDate, studentNum;
    private double mark;

    private Quiz(){}

    private Quiz(Quiz.Builder builder) {
        this.dueDate = builder.dueDate;
        this.studentNum = builder.studentNum;
        this.mark = builder.mark;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public double getQuizMark() {
        return mark;
    }


    public static class Builder {

        private String dueDate, studentNum;
        private double mark;

        public Quiz.Builder dueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Quiz.Builder studentNum(String studentNum) {
            this.studentNum = studentNum;
            return this;
        }

        public Quiz.Builder mark(double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(Quiz quiz){
            this.studentNum = quiz.studentNum;
            this.mark = quiz.mark;
            return this;
        }

        public Quiz build() {
            return new Quiz(this);
        }

    }

    @Override
    public String toString() {
        return "Quiz{" +
                "dueDate='" + dueDate + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", Mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return studentNum.equals(quiz.studentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNum);
    }

}
