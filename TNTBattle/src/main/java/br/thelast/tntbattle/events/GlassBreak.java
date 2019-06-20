package br.thelast.tntbattle.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import br.thelast.tntbattle.actions.TNTExplosionBreak;
import br.thelast.tntbattle.actions.TeamPlayerBreak;
import br.thelast.tntbattle.main.Main;
import br.thelast.tntbattle.utils.ColorFormat;
import br.thelast.tntbattle.utils.STATICS;

public class GlassBreak implements Listener {

	private static Main plugin;

	public GlassBreak(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	/*
	 * Event to register affects block from explosion
	 */
	@EventHandler
	public void onGlassBreak(EntityExplodeEvent event) {
		List<Block> a = event.blockList();

		int qntBlock = 0;
		boolean sendMessage = false;

		for (Block block : a) {

			if (block.getType().toString().equals("GLASS")) {
				Location location = block.getLocation();

				TNTExplosionBreak.blockBreak(location, event);

				qntBlock++;
				sendMessage = true;

			}

		}

		if (sendMessage) {
			Bukkit.broadcastMessage(ColorFormat.formater("&cFoi quebrado um total de : &1" + qntBlock));
			qntBlock = 0;
		}
	}

	@EventHandler
	public void onGlassBreakPlayer(BlockBreakEvent event) {
		if (event.getBlock().getType().toString().equals("GLASS")) {
			String namePlayer = event.getPlayer().getName();

			Location location = event.getBlock().getLocation();
			TeamPlayerBreak.blockBreak(location, event);

		}

	}

}
