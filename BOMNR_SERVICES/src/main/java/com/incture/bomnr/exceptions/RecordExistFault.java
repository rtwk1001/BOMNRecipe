package com.incture.bomnr.exceptions;

import com.incture.bomnr.dto.ResponseDto;

/**
 * <code>RecordExistFault</code> is to indicate application that the entity
 * already exists in the data source, main purpose is to avoid insertion of
 * records violating unique constraint(duplicate records) into data source.
 * 
 * @version 2.0, 21-June-2012
 * @since CR8313
 * @author VINU
 */
// @WebFault(name = "RecordExistFault", faultBean =
// "com.incture.u2k2.mmw.exception.MessageUIDto")
public class RecordExistFault extends Exception {
	private static final long serialVersionUID = 2680366978983580640L;
	/**
	 * Java type that goes as soapenv:Fault detail element.
	 */
	private ResponseDto faultInfo;

	public RecordExistFault() {
		// TODO Auto-generated constructor stub
	}

	public RecordExistFault(String faultMessage) {
		super("Record already exist ");
		faultInfo = new ResponseDto();
		faultInfo.setMessage(faultMessage);
	}

	public RecordExistFault(String message,ResponseDto faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	public RecordExistFault(String message, ResponseDto faultInfo,
			Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	public ResponseDto getFaultInfo() {
		return faultInfo;
	}

	// public RecordExistFault() {
	// super();
	// }
	//
	// private String msg;
	//
	// public RecordExistFault(MmwDto mmwDto) {
	// StringBuffer sb = new StringBuffer("Record already exist ");
	// if (mmwDto != null) {
	// // sb.append(mmwDto.getClass().getSimpleName());
	// // sb.append("#[");
	// sb.append(mmwDto.toString());
	// // sb.append(']');
	// }
	// msg = sb.toString();
	// }
	//
	// @Override
	// public String getMessage() {
	// return msg;
	// }
}