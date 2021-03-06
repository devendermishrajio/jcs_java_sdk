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
package com.jcs_java_sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
public class Authorization 
{
	private AuthVar data;
	
	public Authorization(final AuthVar data)
	{
		this.data = data;
		
		if(data.path != null || !data.path.isEmpty())
		{
			this.data.path = "/";
		}
		
		this.data.protocol = Utils.getProtocol(data.url);
		
		if(!this.data.protocol.equals("http") && !this.data.protocol.equals("https"))
		{
			System.out.println("Unsupported Protocol in the given url");
		}
		
		this.data.host = Utils.getHost(data.url);
		this.data.port = "None";
		//If port present in URL
		if(this.data.host.contains(":"))
		{
			String[] parts = this.data.host.split(":");
			this.data.host = parts[0];
			this.data.port = parts[1];
		}
		
	}
	
	private void addParams(TreeMap<String, String> params)
	{
		params.put("JCSAccessKeyId", this.data.accessKey);
		params.put("SignatureVersion","2");
		params.put("SignatureMethod", "HmacSHA256");
		//Time
		Date dNow = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		formatDate.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		params.put("Timestamp", formatDate.format(dNow));
	}
	private String sortParams(TreeMap<String, String> params)
	{	
		StringBuilder qs = new StringBuilder();
		//join the params using & delimiter
		
		for(Entry<String, String> entry: params.entrySet())
		{
			//url and utf-8
			try 
			{
				qs.append(entry.getKey()+"="+URLEncoder.encode(entry.getValue(),"UTF-8")+"&");
			} catch (UnsupportedEncodingException e) 
			{	
				e.printStackTrace();
			}		
		}
		
		
		return qs.substring(0,qs.length()-1);
	}
	
	private String stringToSign(TreeMap<String, String> params)
	{
		StringBuilder ss = new StringBuilder(data.verb + "\n" + this.data.host);
		if(!this.data.port.equals("None"))
		{
			ss.append(this.data.port);
		}
		ss.append("\n"+ this.data.path + "\n");
		this.addParams(params);
		ss.append(sortParams(params));
		return ss.toString();
	}
	
	public void addAuthorization(TreeMap<String, String> params)
	{
		    String secret = this.data.secretKey;
		    String canonicalString = stringToSign(params);
		     		     
		    Mac sha256_HMAC;
			try 
			{
				sha256_HMAC = Mac.getInstance("HmacSHA256");
				 SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
			     sha256_HMAC.init(secret_key);
			     
			     @SuppressWarnings("restriction")
				 String hmacSignature = DatatypeConverter.printBase64Binary(sha256_HMAC.doFinal(canonicalString.getBytes()));
			     
			     
			     params.put("Signature", hmacSignature);
			}
			catch (NoSuchAlgorithmException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (InvalidKeyException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    		    

	}

}
