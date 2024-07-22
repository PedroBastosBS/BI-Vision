package com.aline_do_bi.vison_bi.user.domain.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @NotBlank(message="O nome é obrigatorio")
    private String name;
    @Email(message="O campo deve conter um email válido")
    private String email;
    @Pattern(regexp="^\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}\\-[0-9]{4}$", message="O campo informado é inválido!")
    private String phone;
    @Pattern(regexp="([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})", 
        message="O campo informado é inválido!")
    private String document;
    @NotBlank(message="A senha é obrigatoria")
    private String password;
    @NotBlank(message="O campo é obrigatorio")
    private String systemProduction;   
}
