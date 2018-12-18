package com.perficient.microservices.model;

public class Error {

	private String errorCd;
	private String errorMsg;

	public Error(String errCd, String errMsg) {
		this.errorCd = errCd;
		this.errorMsg = errMsg;
	}

	public Error() {

	}

	public String getErrorCd() {
		return errorCd;
	}

	public void setErrorCd(String errorCd) {
		this.errorCd = errorCd;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "\"error\":{\r\n" + "	\"errorCd\" : \"" + errorCd + "\",\r\n" + "	\"errorMsg\" : \"" + errorMsg
				+ "\"\r\n" + "  }";
	}

}
