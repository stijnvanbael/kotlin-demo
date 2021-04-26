package java.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class GettersAndSetters {

    private static class Person {
        private LocalDate dateOfBirth;

        public Person(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getDateOfBirthAsIso8601() {
            return dateOfBirth.toString();
        }

        public void setDateOfBirthAsIso8601(String value) {
            dateOfBirth = LocalDate.parse(value);
        }

        public Long getDateOfBirthAsMillis() {
            return dateOfBirth.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000;
        }

        public void setDateOfBirthAsMillis(Long millis) {
            dateOfBirth = LocalDateTime.ofEpochSecond(millis / 1000, 0, ZoneOffset.UTC).toLocalDate();
        }
    }
}
