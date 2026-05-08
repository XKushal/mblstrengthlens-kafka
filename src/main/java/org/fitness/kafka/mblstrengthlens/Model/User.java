package org.fitness.kafka.mblstrengthlens.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
