package com.jcs_java_sdk.compute_api.model;

public class CreateKeyPairRequest
{
	private String keyName;
	
	public CreateKeyPairRequest()
	{
		keyName = new String();
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	
	
}