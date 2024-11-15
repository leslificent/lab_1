package db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@AllArgsConstructor
@ToString
public class StudentDTO {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private String recordBookNumber;
}
