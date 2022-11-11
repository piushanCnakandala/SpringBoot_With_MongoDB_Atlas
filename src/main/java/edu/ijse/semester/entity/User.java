package edu.ijse.semester.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

@Document(collection = "user")
public class User {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String address;
    @Field
    private String salary;

}
