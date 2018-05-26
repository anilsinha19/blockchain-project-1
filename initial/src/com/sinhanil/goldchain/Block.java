package com.sinhanil.goldchain;

import java.util.Date;

public class Block {

	public String hash;
	public String previousHash; 
	private String data; //lets keep a sample text as data for poc.
	private long timeStamp; 
	
	//Block Constructor.  
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();		
		this.hash = calculateHash();
	}
	
	//Calculate hash based on all parts of block
		public String calculateHash() {
			String calculatedhash = DigitalSignatureUtil.applySha256( 
					previousHash +
					Long.toString(timeStamp) +
					data 
					);
			return calculatedhash;
		}
						
}
