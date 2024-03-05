package br.com.spolador.consultasdinamicas.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Entity
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adress adress;

    @JsonManagedReference
    @OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Subject> subjects;


}
