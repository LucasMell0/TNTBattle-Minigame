package br.thelast.tntbattle.actions;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityExplodeEvent;

import br.thelast.tntbattle.utils.STATICS;

public class TNTExplosionBreak {
	public static void blockBreak(Location location, EntityExplodeEvent e) {
		List<Location> team1 = STATICS.team1;
		List<Location> team2 = STATICS.team2;

		if (team1.contains(location)) {

			double y = location.getY() - 1;
			double x = location.getX();
			double z = location.getZ();

			Location localizacao = new Location(e.getEntity().getWorld(), x, y, z);
			e.getEntity().getWorld().strikeLightning(localizacao);
			localizacao.getBlock().setType(Material.RED_WOOL);

		} else if (team2.contains(location)) {

			double y = location.getY() - 1;
			double x = location.getX();
			double z = location.getZ();

			Location localizacao = new Location(e.getEntity().getWorld(), x, y, z);
			e.getEntity().getWorld().strikeLightning(localizacao);
			localizacao.getBlock().setType(Material.BLUE_WOOL);
		}

	}
}
