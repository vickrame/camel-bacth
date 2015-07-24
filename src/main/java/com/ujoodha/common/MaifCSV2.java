package com.ujoodha.common;

import java.io.Serializable;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(crlf = "UNIX", separator = ";", skipFirstLine = true)
public class MaifCSV2 implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = -1183735466951121988L;

	@DataField(pos = 1)
	private String IDPLANB_DM;

	@DataField(pos = 2)
	private String NEMP;

	@DataField(pos = 3)
	private String LPRNEMP;

	// @DataField(pos = 4)
	// private String LNOMEMP;

	// @DataField(pos = 5)
	// private String CEMP;

	// @DataField(pos = 6)
	// private String LEMP;

	// @DataField(pos = 7)
	// private String CTPCNT;

	// @DataField(pos = 8)
	// private String LTYPCNT;

	// @DataField(pos = 9)
	// private String CUTR;
	// @DataField(pos = 10)
	// private String LUTR;
	// @DataField(pos = 11)
	// private String CEQP;
	// @DataField(pos = 12)
	// private String LEQP;
	// @DataField(pos = 13)
	// private String CSEC;
	// @DataField(pos = 14)
	// private String LSEC;
	// @DataField(pos = 15)
	// private String CENT;
	// @DataField(pos = 16)
	// private String LENT;
	// @DataField(pos = 17)
	// private String NEMPMGRENT;
	// @DataField(pos = 18)
	// private String CTYPENT;
	// @DataField(pos = 19)
	// private String LTYPENT;
	// @DataField(pos = 20)
	// private String CREG;
	// @DataField(pos = 21)
	// private String LREG;
	// @DataField(pos = 22)
	// private String CFIL;
	// @DataField(pos = 23)
	// private String LFIL;
	// @DataField(pos = 24)
	// private String DDEBVAL;
	// @DataField(pos = 25)
	// private String DFINVAL;
	// @DataField(pos = 26)
	// private String DMAJENR;
	// @DataField(pos = 27)
	// private String HMAJENR;
	// @DataField(pos = 28)
	// private String CFLUAUD;
	// @DataField(pos = 29)
	// private String DFINCNT;

	/**
	 * @return the iDPLANB_DM
	 */
	public String getIDPLANB_DM() {
		return IDPLANB_DM;
	}

	/**
	 * @param iDPLANB_DM
	 *            the iDPLANB_DM to set
	 */
	public void setIDPLANB_DM(String iDPLANB_DM) {
		IDPLANB_DM = iDPLANB_DM;
	}

	/**
	 * @return the nEMP
	 */
	public String getNEMP() {
		return NEMP;
	}

	/**
	 * @param nEMP
	 *            the nEMP to set
	 */
	public void setNEMP(String nEMP) {
		NEMP = nEMP;
	}

	/**
	 * @return the lPRNEMP
	 */
	public String getLPRNEMP() {
		return LPRNEMP;
	}

	/**
	 * @param lPRNEMP
	 *            the lPRNEMP to set
	 */
	public void setLPRNEMP(String lPRNEMP) {
		LPRNEMP = lPRNEMP;
	}
	//
	// /**
	// * @return the lNOMEMP
	// */
	// public String getLNOMEMP() {
	// return LNOMEMP;
	// }
	//
	// /**
	// * @param lNOMEMP
	// * the lNOMEMP to set
	// */
	// public void setLNOMEMP(String lNOMEMP) {
	// LNOMEMP = lNOMEMP;
	// }
	//
	// /**
	// * @return the cEMP
	// */
	// public String getCEMP() {
	// return CEMP;
	// }
	//
	// /**
	// * @param cEMP
	// * the cEMP to set
	// */
	// public void setCEMP(String cEMP) {
	// CEMP = cEMP;
	// }
	//
	// /**
	// * @return the lEMP
	// */
	// public String getLEMP() {
	// return LEMP;
	// }
	//
	// /**
	// * @param lEMP
	// * the lEMP to set
	// */
	// public void setLEMP(String lEMP) {
	// LEMP = lEMP;
	// }
	//
	// /**
	// * @return the cTPCNT
	// */
	// public String getCTPCNT() {
	// return CTPCNT;
	// }
	//
	// /**
	// * @param cTPCNT
	// * the cTPCNT to set
	// */
	// public void setCTPCNT(String cTPCNT) {
	// CTPCNT = cTPCNT;
	// }
	//
	// /**
	// * @return the lTYPCNT
	// */
	// public String getLTYPCNT() {
	// return LTYPCNT;
	// }
	//
	// /**
	// * @param lTYPCNT
	// * the lTYPCNT to set
	// */
	// public void setLTYPCNT(String lTYPCNT) {
	// LTYPCNT = lTYPCNT;
	// }
	//
	// /**
	// * @return the cUTR
	// */
	// public String getCUTR() {
	// return CUTR;
	// }
	//
	// /**
	// * @param cUTR
	// * the cUTR to set
	// */
	// public void setCUTR(String cUTR) {
	// CUTR = cUTR;
	// }
	//
	// /**
	// * @return the lUTR
	// */
	// public String getLUTR() {
	// return LUTR;
	// }
	//
	// /**
	// * @param lUTR
	// * the lUTR to set
	// */
	// public void setLUTR(String lUTR) {
	// LUTR = lUTR;
	// }
	//
	// /**
	// * @return the cEQP
	// */
	// public String getCEQP() {
	// return CEQP;
	// }
	//
	// /**
	// * @param cEQP
	// * the cEQP to set
	// */
	// public void setCEQP(String cEQP) {
	// CEQP = cEQP;
	// }
	//
	// /**
	// * @return the lEQP
	// */
	// public String getLEQP() {
	// return LEQP;
	// }
	//
	// /**
	// * @param lEQP
	// * the lEQP to set
	// */
	// public void setLEQP(String lEQP) {
	// LEQP = lEQP;
	// }
	//
	// /**
	// * @return the cSEC
	// */
	// public String getCSEC() {
	// return CSEC;
	// }
	//
	// /**
	// * @param cSEC
	// * the cSEC to set
	// */
	// public void setCSEC(String cSEC) {
	// CSEC = cSEC;
	// }
	//
	// /**
	// * @return the lSEC
	// */
	// public String getLSEC() {
	// return LSEC;
	// }
	//
	// /**
	// * @param lSEC
	// * the lSEC to set
	// */
	// public void setLSEC(String lSEC) {
	// LSEC = lSEC;
	// }
	//
	// /**
	// * @return the cENT
	// */
	// public String getCENT() {
	// return CENT;
	// }
	//
	// /**
	// * @param cENT
	// * the cENT to set
	// */
	// public void setCENT(String cENT) {
	// CENT = cENT;
	// }
	//
	// /**
	// * @return the lENT
	// */
	// public String getLENT() {
	// return LENT;
	// }
	//
	// /**
	// * @param lENT
	// * the lENT to set
	// */
	// public void setLENT(String lENT) {
	// LENT = lENT;
	// }
	//
	// /**
	// * @return the nEMPMGRENT
	// */
	// public String getNEMPMGRENT() {
	// return NEMPMGRENT;
	// }
	//
	// /**
	// * @param nEMPMGRENT
	// * the nEMPMGRENT to set
	// */
	// public void setNEMPMGRENT(String nEMPMGRENT) {
	// NEMPMGRENT = nEMPMGRENT;
	// }
	//
	// /**
	// * @return the cTYPENT
	// */
	// public String getCTYPENT() {
	// return CTYPENT;
	// }
	//
	// /**
	// * @param cTYPENT
	// * the cTYPENT to set
	// */
	// public void setCTYPENT(String cTYPENT) {
	// CTYPENT = cTYPENT;
	// }
	//
	// /**
	// * @return the lTYPENT
	// */
	// public String getLTYPENT() {
	// return LTYPENT;
	// }
	//
	// /**
	// * @param lTYPENT
	// * the lTYPENT to set
	// */
	// public void setLTYPENT(String lTYPENT) {
	// LTYPENT = lTYPENT;
	// }
	//
	// /**
	// * @return the cREG
	// */
	// public String getCREG() {
	// return CREG;
	// }
	//
	// /**
	// * @param cREG
	// * the cREG to set
	// */
	// public void setCREG(String cREG) {
	// CREG = cREG;
	// }
	//
	// /**
	// * @return the lREG
	// */
	// public String getLREG() {
	// return LREG;
	// }
	//
	// /**
	// * @param lREG
	// * the lREG to set
	// */
	// public void setLREG(String lREG) {
	// LREG = lREG;
	// }
	//
	// /**
	// * @return the cFIL
	// */
	// public String getCFIL() {
	// return CFIL;
	// }
	//
	// /**
	// * @param cFIL
	// * the cFIL to set
	// */
	// public void setCFIL(String cFIL) {
	// CFIL = cFIL;
	// }
	//
	// /**
	// * @return the lFIL
	// */
	// public String getLFIL() {
	// return LFIL;
	// }
	//
	// /**
	// * @param lFIL
	// * the lFIL to set
	// */
	// public void setLFIL(String lFIL) {
	// LFIL = lFIL;
	// }
	//
	// /**
	// * @return the dDEBVAL
	// */
	// public String getDDEBVAL() {
	// return DDEBVAL;
	// }
	//
	// /**
	// * @param dDEBVAL
	// * the dDEBVAL to set
	// */
	// public void setDDEBVAL(String dDEBVAL) {
	// DDEBVAL = dDEBVAL;
	// }
	//
	// /**
	// * @return the dFINVAL
	// */
	// public String getDFINVAL() {
	// return DFINVAL;
	// }
	//
	// /**
	// * @param dFINVAL
	// * the dFINVAL to set
	// */
	// public void setDFINVAL(String dFINVAL) {
	// DFINVAL = dFINVAL;
	// }
	//
	// /**
	// * @return the dMAJENR
	// */
	// public String getDMAJENR() {
	// return DMAJENR;
	// }
	//
	// /**
	// * @param dMAJENR
	// * the dMAJENR to set
	// */
	// public void setDMAJENR(String dMAJENR) {
	// DMAJENR = dMAJENR;
	// }
	//
	// /**
	// * @return the hMAJENR
	// */
	// public String getHMAJENR() {
	// return HMAJENR;
	// }
	//
	// /**
	// * @param hMAJENR
	// * the hMAJENR to set
	// */
	// public void setHMAJENR(String hMAJENR) {
	// HMAJENR = hMAJENR;
	// }
	//
	// /**
	// * @return the cFLUAUD
	// */
	// public String getCFLUAUD() {
	// return CFLUAUD;
	// }
	//
	// /**
	// * @param cFLUAUD
	// * the cFLUAUD to set
	// */
	// public void setCFLUAUD(String cFLUAUD) {
	// CFLUAUD = cFLUAUD;
	// }
	//
	// /**
	// * @return the dFINCNT
	// */
	// public String getDFINCNT() {
	// return DFINCNT;
	// }
	//
	// /**
	// * @param dFINCNT
	// * the dFINCNT to set
	// */
	// public void setDFINCNT(String dFINCNT) {
	// DFINCNT = dFINCNT;
	// }

}
