package com.khrd.schoolmicroservice.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "school")
public class School {

    @Id
    private int id;
    private String schoolName;
    private String location;
    private String principalName;
}