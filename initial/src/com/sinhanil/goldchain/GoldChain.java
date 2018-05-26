package com.sinhanil.goldchain;

public class GoldChain {
	
	public static void main(String[] args) {	
		
		Block genesisBlock = new Block("first block data", "0");
		System.out.println("Hash for block 1 : " + genesisBlock.hash);
		
		Block secondBlock = new Block("2nd block data",genesisBlock.hash);
		System.out.println("Hash for block 2 : " + secondBlock.hash);
		
		Block thirdBlock = new Block("3rd block data",secondBlock.hash);
		System.out.println("Hash for block 3 : " + thirdBlock.hash);
	
	}
		
}
