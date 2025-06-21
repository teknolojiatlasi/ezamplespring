package com.example.demo.model;



import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PersonelBirim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;

    @OneToMany(mappedBy = "birim")
    @JsonIgnore
    private List<Personel> personeller;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public List<Personel> getPersoneller() {
		return personeller;
	}

	public void setPersoneller(List<Personel> personeller) {
		this.personeller = personeller;
	}

    // Getter ve Setter
}
