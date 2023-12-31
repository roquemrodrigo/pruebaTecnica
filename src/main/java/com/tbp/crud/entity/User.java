package com.tbp.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
@Id	
@GeneratedValue
private int codigoUnico;
private String nombres;
private String apellidos;
private String tipoDocumento;
private String numeroDocumento;
}
