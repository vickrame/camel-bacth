package com.ujoodha.common;

public enum CategoriePersonne {

	BEBE("B"), ENFANT("E"), ADO("ADO"), ADULTE("ADULTE"), RETRAITE("RETRAITE");

	private String code;

	private CategoriePersonne(String code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
