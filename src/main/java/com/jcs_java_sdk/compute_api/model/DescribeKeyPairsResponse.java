/*******************************************************************************
 * Copyright (c) 2016 Jiocloud.com, Inc. or its affiliates.  All Rights Reserved
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, dis-
 * tribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the fol-
 * lowing conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABIL-
 * ITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT
 * SHALL THE AUTHOR BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 *******************************************************************************/
package com.jcs_java_sdk.compute_api.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DescribeKeyPairsResponse")
/// Class to handle Describe Key Pairs Request Respones
	/**
		This Response Class has member functions that returns the description of Key Pairs that are created by the user.  
	*/
public class DescribeKeyPairsResponse {
	@XmlElement
	private String requestId;
	
	@XmlElementWrapper(name = "keySet")
	@XmlElement(name = "item")
	private List<KeyPair> keys;

	public final String getRequestId() {
		return requestId;
	}
	///Getter for the Description of Key Pairs created by the authentic user.
		/**
			@return final vector<model::key_pair>  
			A vector of objects of class key_pair
		*/
	public final List<KeyPair> getKeys() {
		return keys;
	}
	///Getter for the Unique Request ID
		/**
			@return final string
		*/
	void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	void setKeys(List<KeyPair> keys) {
		this.keys = keys;
	}
	
	
	
}
