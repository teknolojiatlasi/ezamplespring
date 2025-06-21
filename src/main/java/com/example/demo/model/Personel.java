package com.example.demo.model;



import jakarta.persistence.*;

@Entity
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    private String ad;

    private String soyad;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "adres_id", referencedColumnName = "id")
    private Adres adres;

    @ManyToOne
    @JoinColumn(name = "birim_id")
    private PersonelBirim birim;

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

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public PersonelBirim getBirim() {
		return birim;
	}

	public void setBirim(PersonelBirim birim) {
		this.birim = birim;
	}

    // Getter ve Setter
}

