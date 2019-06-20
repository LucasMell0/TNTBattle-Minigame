package br.thelast.tntbattle.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class CreateWall {
	public static void WallCreator(Player p, int TAMANHO, int DISTANCIA, int TAMANHO_PAREDE , int LARGURA ,double x, double y, double z, Material bloco) {
		for (int i = 0; i < LARGURA; i++) {
			for (int a = 0; a < TAMANHO_PAREDE; a++) {
				Location localizacao = new Location(p.getWorld(), x, y + a, z + i);
				localizacao.getBlock().setType(bloco);
				STATICS.wallBlockTotal++;
				STATICS.wallBlockTotalFinal++;
			}
		}
		for (int i = LARGURA; i > 0; i--) {
			for (int a = 0; a < TAMANHO_PAREDE; a++) {
				Location localizacao = new Location(p.getWorld(), x, y + a, z - i);
				localizacao.getBlock().setType(bloco);
				STATICS.wallBlockTotal++;
				STATICS.wallBlockTotalFinal++;
			}
		}

		for (int i = LARGURA; i > 0; i--) {
			for (int a = TAMANHO_PAREDE; a > 0; a--) {
				Location localizacao = new Location(p.getWorld(), x, y - a, z - i);
				localizacao.getBlock().setType(bloco);
				STATICS.wallBlockTotal++;
				STATICS.wallBlockTotalFinal++;
			}
		}
		for (int i = 0; i < LARGURA; i++) {
			for (int a = TAMANHO_PAREDE; a > 0; a--) {
				Location localizacao = new Location(p.getWorld(), x, y - a, z + i);
				localizacao.getBlock().setType(bloco);
				STATICS.wallBlockTotal++;
				STATICS.wallBlockTotalFinal++;
			}
		}

	}
}
