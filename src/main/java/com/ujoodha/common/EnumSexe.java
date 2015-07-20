package com.ujoodha.common;

public enum EnumSexe {

	MASCULIN("M"), FEMININ("F");

	private String code;

	private EnumSexe(String code) {
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
