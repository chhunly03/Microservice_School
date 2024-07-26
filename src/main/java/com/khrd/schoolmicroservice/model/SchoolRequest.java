package com.khrd.schoolmicroservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SchoolRequest  {
    private String schoolName;
    private String location;
    private String principalName;
}