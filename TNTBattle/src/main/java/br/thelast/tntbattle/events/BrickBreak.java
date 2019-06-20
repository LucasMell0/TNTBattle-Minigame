package br.thelast.tntbattle.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import br.thelast.tntbattle.main.Main;
import br.thelast.tntbattle.utils.ColorFormat;
import br.thelast.tntbattle.utils.PercentageOfTheWall;
import br.thelast.tntbattle.utils.STATICS;

public class BrickBreak implements Listener {
	private static Main plugin;

	public BrickBreak(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onWallBreak(EntityExplodeEvent event) {
		List<Block> blocks = event.blockList();

		int qntBlock = 0;
		boolean sendMessage = false;

		for (Block block : blocks) {
			if (block.getType().toString().equals("BRICKS")) {
				qntBlock++;
				sendMessage = true;
			}

		}

		if (sendMessage) {
			Bukkit.broadcastMessage(ColorFormat.formater(PercentageOfTheWall.percentage(qntBlock)));
			STATICS.wallBlockTotal -= qntBlock;

			qntBlock = 0;
		}
	}
}
