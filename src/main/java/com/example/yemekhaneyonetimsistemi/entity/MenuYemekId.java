package com.example.yemekhaneyonetimsistemi.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable //Başka bir entitye gömülebilir olduğunu belirtir.
@Getter
@Setter
@EqualsAndHashCode // Hibernate JPA nın anahtarları karşılaştırılması için gereklidir.
public class MenuYemekId implements Serializable {

    private int menuId;

    private int yemekId;

}
