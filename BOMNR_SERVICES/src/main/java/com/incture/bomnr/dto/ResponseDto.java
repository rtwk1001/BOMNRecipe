package com.incture.bomnr.dto;

import com.incture.bomnr.exceptions.InvalidInputFault;
import com.incture.bomnr.util.BOMNROperation;

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
@Override
public void validate(BOMNROperation enOperation) throws InvalidInputFault {
	// TODO Auto-generated method stub
	
}

}
