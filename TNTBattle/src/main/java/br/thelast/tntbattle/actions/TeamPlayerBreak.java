package br.thelast.tntbattle.actions;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;

import br.thelast.tntbattle.utils.ColorFormat;
import br.thelast.tntbattle.utils.STATICS;

public class TeamPlayerBreak {

	public static void blockBreak(Location location, BlockBreakEvent event) {
		List<Location> team1 = STATICS.team1;
		List<Location> team2 = STATICS.team2;
		
		//teste
		if(team1.contains(location)) {
			Bukkit.broadcastMessage(ColorFormat.formater("&6Um vidro do time &c&lVERMELHO &6foi quebrado!!!asdasdaskjdbasjiuhkdbasikdbki"));
			
			double y = location.getY() - 1;
			double x = location.getX();
			double z = location.getZ();

			Location localizacao = new Location(event.getPlayer().getWorld(), x, y, z);
			event.getPlayer().getWorld().strikeLightning(localizacao);
			localizacao.getBlock().setType(Material.RED_WOOL);
			
		} else if (team2.contains(location)) {
			Bukkit.broadcastMessage(ColorFormat.formater("&6Um vidro do time &b&lAZUL &6foi quebrado!!!"));
			
			double y = location.getY() - 1;
			double x = location.getX();
			double z = location.getZ();

			Location localizacao = new Location(event.getPlayer().getWorld(), x, y, z);
			event.getPlayer().getWorld().strikeLightning(localizacao);
			localizacao.getBlock().setType(Material.BLUE_WOOL);
		}
		
		
	}

}
