package br.thelast.tntbattle.main;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import br.thelast.tntbattle.command.CreateCommand;
import br.thelast.tntbattle.events.BrickBreak;
import br.thelast.tntbattle.events.GlassBreak;
import br.thelast.tntbattle.utils.STATICS;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		new GlassBreak(this);
		new BrickBreak(this);
		new CreateCommand(this);
		
		
		STATICS.team1 = new ArrayList<Location>();
		STATICS.team2  = new ArrayList<Location>();
	}

	@Override
	public void onDisable() {

	}
}
