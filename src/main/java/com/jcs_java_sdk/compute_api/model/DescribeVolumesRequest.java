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

import java.util.ArrayList;
/// Class to handle describe snapshots request
/**
	This class manages the request for describe snapshots. User can create an object and and initialize the needed arguments.
*/
public class DescribeVolumesRequest
{
	private ArrayList<String>volumeIds;
	private int maxResults;
	private String nextToken;
	private boolean detail;
	
	/// Constructor
	public DescribeVolumesRequest()
	{
		nextToken = new String();
		volumeIds = new ArrayList<String>();
		maxResults = -1;
		detail = true;
	}
	/// Getter for the private variable volumeId
	/**
		@return ArrayList<String>
	*/
	public ArrayList<String> getVolumeIds() {
		return volumeIds;
	}
	/// Setter for the private variable volumeId
	/**
		@param volumes (optional): Array of volume ids
	*/
	public void setVolumeIds(ArrayList<String> volumeIds) {
		this.volumeIds = volumeIds;
	}
	/// Getter for the private variable maxResults
	/**
		@return int
	*/
	public int getMaxResults() {
		return maxResults;
	}
	/// Setter for the private variable maxResults
	/**
		@param maxResults (optional): Max number of results to be shown in response.
	*/
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	/// Getter for the private variable nextToken
	/**
		@return string
	*/
	public String getNextToken() {
		return nextToken;
	}
	/// Setter for the private variable nextToken
	/**
		@param nextToken (optional): NextToken - Id of last snapshot seen if max number of results is less than total snapshots
	*/
	public void setNextToken(String nextToken) {
		this.nextToken = nextToken;
	}
	/// Getter for the private variable detail
	/**
		@return bool
	*/
	public boolean isDetail() {
		return detail;
	}
	/// Setter for the private variable detail
	/**
		@param detail (optional): Detail - by default this is true. Set to false to will supress detailed response
	*/
	public void setDetail(boolean detail) {
		this.detail = detail;
	}
	
}