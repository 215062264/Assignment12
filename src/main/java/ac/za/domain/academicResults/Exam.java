package ac.za.domain.academicResults;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Exam {

    private String examNum, studentNum;
    private double mark;

    private Exam(){}

    private Exam(Exam.Builder builder) {
        this.examNum = builder.examNum;
        this.studentNum = builder.studentNum;
        this.mark = builder.mark;
    }

    public String getExamNum() {
        return examNum;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public double getExamMark() {
        return mark;
    }


    public static class Builder {

        private String examNum, studentNum;
        private double mark;

        public Exam.Builder examNum(String examNum) {
            this.examNum = examNum;
            return this;
        }

        public Exam.Builder studentNum(String studentNum) {
            this.studentNum = studentNum;
            return this;
        }

        public Exam.Builder mark(double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(Exam exam){
            this.studentNum = exam.studentNum;
            this.examNum = exam.examNum;
            return this;
        }

        public Exam build() {
            return new Exam(this);
        }

    }

    @Override
    public String toString() {
        return "Exam{" +
                "examNum='" + examNum + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", Mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return studentNum.equals(exam.studentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNum);
    }

}
