package com.sysman.prueba_tecnica_sysman_backend.entity;

import com.sysman.prueba_tecnica_sysman_backend.constants.NumericConstants;
import com.sysman.prueba_tecnica_sysman_backend.constants.TableConstants;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = TableConstants.ROLE)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = NumericConstants.ROLE_NAME_MAX_LENGTH)
    private String name;
}
