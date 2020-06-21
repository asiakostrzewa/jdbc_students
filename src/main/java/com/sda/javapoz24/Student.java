package com.sda.javapoz24;

import lombok.*;

/*@Getter
@Setter //jeśli wpiszemy gettery, settery nad klasą to będą się odnosić do wszystkich pól wewnątrz klasy, a jeśli nad np. private String firstName; to będzie się odnosić tylko do pola firstName
@ToString
@EqualsAndHashCode*/

//Data = @Getter, @Setter, @ToString, @EqualsAndHashCode razem
@Data
@Builder //wzorzec projektowy
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    //POJO
    private Long id;

    private String firstName;
    private String lastName;
    private int age;

    private boolean awarded;

    private Gender gender;
}
