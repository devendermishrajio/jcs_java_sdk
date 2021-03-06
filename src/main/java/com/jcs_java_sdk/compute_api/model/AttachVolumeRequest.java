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
/// Class to handle attach volume request
	/**
		This class manages the request for attach volume. User can create an object and and initialize the needed arguments.
	*/
public class AttachVolumeRequest {
	private String instanceId;
	private String volumeId;
	private String device;
	
	public AttachVolumeRequest()
	{
		instanceId = new String();
		volumeId = new String();
		device = new String();

	}
	/// Getter for the private variable instanceId
	/**
		@return string
	*/ 	
	public String getInstanceId() 
	{
		return instanceId;
	}
	/// Setter for the private variable instanceId 
	/**
		@param instanceId : instance id  with which volume will be attached(unique for each instance)
	*/
	public void setInstanceId(String instanceId) 
	{
		this.instanceId = instanceId;
	}
	/// Getter for the private variable volumeId 
	/**
		@return string
	*/
	public String getVolumeId() 
	{
		return volumeId;
	}
	/// Setter for the private variable volumeId
	/**
		@param volumeId : volume id which will be attached(unique for each volume)
	*/
	public void setVolumeId(String volumeId) 
	{
		this.volumeId = volumeId;
	}
	/// Getter for the private variable device 
	/**
		@return string
	*/
	public String getDevice() 
	{
		return device;
	}
	/// Setter for the private variable device 
	/**
		@param device : device where the volume will be attached(/dev/vdb, /dev/vdc)
	*/
	public void setDevice(String device) 
	{
		this.device = device;
	}
	

		
}
