package com.sinhanil.goldchain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;

public class GoldChain {
	
	private static List<Block> blockchain = new ArrayList<>();
	public static int difficultyLevel = 5;
	
	public static void main(String[] args) {	
		
		System.out.println("Welcome to your blockchain : GoldChain !!!");
		Block genesisBlock = new Block("first block data", "0");
		addBlock(genesisBlock);
		
		Block secondBlock = new Block("2nd block data",genesisBlock.hash);
		addBlock(secondBlock);		
		
		Block thirdBlock = new Block("3rd block data",secondBlock.hash);
		addBlock(thirdBlock);
		


		System.out.println("Blockchain is Valid: " + isChainValid());
		
		// print it in json form
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(blockchainJson);				
		
	}
		
	public static Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash from DATA:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		}
		return true;
	}
	
	public static void addBlock(Block newBlock) {
		newBlock.mineBlock(difficultyLevel);
		blockchain.add(newBlock);
	}
}
