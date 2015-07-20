package com.ujoodha.common;

import java.io.Serializable;
import java.util.List;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(crlf = "UNIX", separator = ";")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1183735466951121988L;

	@DataField(pos = 1)
	private String nom;
	@DataField(pos = 2)
	private String prenom;
	@DataField(pos = 3)
	private int age;
	@DataField(pos = 4)
	private EnumSexe sexe;

	private CategoriePersonne cate;

	private List<Droit> listDroit;
	private UserKey key;

	public User() {
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setListDroit(List<Droit> listDroit) {
		this.listDroit = listDroit;
	}

	public List<Droit> getListDroit() {
		return listDroit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	/**
	 * @return the key
	 */
	public UserKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(UserKey key) {
		this.key = key;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [nom=").append(nom).append(", prenom=")
				.append(prenom).append(", age=").append(age).append("]");
		return builder.toString();
	}

	/**
	 * @return the sexe
	 */
	public EnumSexe getSexe() {
		return sexe;
	}

	/**
	 * @param sexe
	 *            the sexe to set
	 */
	public void setSexe(EnumSexe sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the cate
	 */
	public CategoriePersonne getCate() {
		return cate;
	}

	/**
	 * @param cate
	 *            the cate to set
	 */
	public void setCate(CategoriePersonne cate) {
		this.cate = cate;
	}

}
