package br.com.ada.store.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;

    private String password;

//    private TypeUser type;

    @OneToOne(cascade = CascadeType.ALL)
    private Library library;

}
