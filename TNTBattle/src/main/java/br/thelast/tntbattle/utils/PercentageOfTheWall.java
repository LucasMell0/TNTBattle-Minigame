package br.thelast.tntbattle.utils;

public class PercentageOfTheWall {
	public static String percentage(int qnt) {
		int wallBlocks = STATICS.wallBlockTotal;
		int blocks = STATICS.wallBlockTotal - qnt;
		int total = (blocks*100)/wallBlocks;
		int totalFinal = (wallBlocks*100)/STATICS.wallBlockTotalFinal;
		
		String msg = "&6Foi causado um dano de &b" + (100 - total) 
				+ "&3% \n&6Quabrando um total de : " + qnt 
				+ " &bBlocos &6de um total de: " + STATICS.wallBlockTotalFinal + " &bBlocos" 
				+ "&6\nRestando apenas: &b" + totalFinal + "&3% &6da parede";
		
		return msg;
	}
}
