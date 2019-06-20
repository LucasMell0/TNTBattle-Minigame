package br.thelast.tntbattle.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class CreateBase {
	public static void BaseCreator(Player p, int TAMANHO, int DISTANCIA, double x, double y, double z, Material bloco) {

		double x1Plataforma = x + DISTANCIA;
		double x2Plataforma = x - DISTANCIA;

		for (int i = 0; i < TAMANHO; i++) {
			for (int a = 0; a < TAMANHO; a++) {
				Location localizacao = new Location(p.getWorld(), x1Plataforma + a, y, z + i);
				STATICS.team1.add(localizacao);
				localizacao.getBlock().setType(bloco);
			}
		}

		for (int i = TAMANHO; i > 0; i--) {
			for (int a = TAMANHO; a > 0; a--) {
				Location localizacao = new Location(p.getWorld(), x1Plataforma + a - 1, y, z - i);
				STATICS.team1.add(localizacao);
				localizacao.getBlock().setType(bloco);
			}
		}

		for (int i = TAMANHO; i > 0; i--) {
			for (int a = TAMANHO; a > 0; a--) {
				Location localizacao = new Location(p.getWorld(), x2Plataforma - a, y, z - i);
				STATICS.team2.add(localizacao);
				localizacao.getBlock().setType(bloco);
			}
		}

		for (int i = 0; i < TAMANHO; i++) {
			for (int a = TAMANHO; a > 0; a--) {
				Location localizacao = new Location(p.getWorld(), x2Plataforma - a, y, z + i);
				STATICS.team2.add(localizacao);
				localizacao.getBlock().setType(bloco);
			}
		}

	}
}
