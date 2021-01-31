package com.waracle.cakemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Cake {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long cakeId;
    private String title;
    private String desc;
    private String image;

    public Cake(String title, String desc, String image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public Cake(){}

    @Override
    public String toString() {
        return "Cake{" + "id=" + cakeId + ", title=" + title + ", desc=" + desc + ", image=" + image + "'}";
    }
}
