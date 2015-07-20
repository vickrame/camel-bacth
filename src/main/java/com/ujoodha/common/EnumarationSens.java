package com.ujoodha.common;

public enum EnumarationSens {

	EGAL("="), INF("<"), SUP(">");

	private String code;

	private EnumarationSens(String code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
