package com.incture.bomnr.dto;

public class ResponseDto extends BaseDto {
private boolean status;
private String Message;
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public String getMessage() {
	return Message;
}
public void setMessage(String message) {
	Message = message;
}

}
