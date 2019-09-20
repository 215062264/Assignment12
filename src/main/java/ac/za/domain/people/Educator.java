package ac.za.domain.people;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Educator {

    private String educatorId, educatorFirstName, educatorLastName;
    private int age;

    private Educator(){}

    private Educator(Builder builder) {
        this.educatorId = builder.educatorId;
        this.age = builder.age;
        this.educatorFirstName = builder.educatorFirstName;
        this.educatorLastName = builder.educatorLastName;
    }

    public String getEducatorId() {
        return educatorId;
    }

    public String getEducatorFirstName() {
        return educatorFirstName;
    }

    public String getEducatorLastName() {
        return educatorLastName;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {

        private String educatorId, educatorFirstName, educatorLastName;
        private int age;

        public Builder educatorId( String educatorId) {
            this.educatorId = educatorId;
            return this;
        }

        public Builder educatorFirstName( String educatorFirstName) {
            this.educatorFirstName = educatorFirstName;
            return this;
        }

        public Builder educatorLastName( String educatorLastName) {
            this.educatorLastName = educatorLastName;
            return this;
        }

        public Builder age( int age) {
            this.age = age;
            return this;
        }

        public Builder copy(Educator educator){
            this.educatorId = educator.educatorId;
            this.educatorFirstName = educator.educatorFirstName;
            return this;
        }

        public Educator build() {
            return new Educator(this);
        }

    }

    @Override
    public String toString() {
        return "Educator{" +
                "educatorId='" + educatorId + '\'' +
                ", EducatorFirstName='" + educatorFirstName + '\'' +
                ", EducatorLastName='" + educatorLastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Educator educator = (Educator) o;
        return educatorId.equals(educator.educatorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(educatorId);
    }

}
