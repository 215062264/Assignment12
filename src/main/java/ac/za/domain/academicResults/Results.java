package ac.za.domain.academicResults;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Results {

    private String studentNum;
    private double mark;

    private Results(){}

    private Results(Results.Builder builder) {
        this.studentNum = builder.studentNum;
        this.mark = builder.mark;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public double getFinalMark() {
        return mark;
    }


    public static class Builder {

        private String studentNum;
        private double mark;

        public Results.Builder studentNum(String studentNum) {
            this.studentNum = studentNum;
            return this;
        }

        public Results.Builder mark(double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(Results results){
            this.studentNum = results.studentNum;
            this.mark = results.mark;
            return this;
        }

        public Results build() {
            return new Results(this);
        }

    }

    @Override
    public String toString() {
        return "Results{" +
                ", studentNum='" + studentNum + '\'' +
                ", Mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results = (Results) o;
        return studentNum.equals(results.studentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNum);
    }

}
