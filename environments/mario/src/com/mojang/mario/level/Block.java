package com.mojang.mario.level;

public class Block {
	private double reward = 0.0;
	private String rewardType = "none";
	public int x ;
	public int y;
	public Block(int x, int y, String string) {
		x = x;
		y = y;
		rewardType = string;
	}
	public String getRewardType(){
		return rewardType;
	}
}
