package study.javamapstruct.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private Long id;
    private String email;
    private String name;
    private Integer age;
    private Address address;

}
