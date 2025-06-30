package com.sysman.prueba_tecnica_sysman_backend.entity;

import com.sysman.prueba_tecnica_sysman_backend.constants.ColumnConstants;
import com.sysman.prueba_tecnica_sysman_backend.constants.TableConstants;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = TableConstants.USER)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = ColumnConstants.ROLE_ID, nullable = false)
    private Role role;
}
