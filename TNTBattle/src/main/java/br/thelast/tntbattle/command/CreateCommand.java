package br.thelast.tntbattle.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.thelast.tntbattle.main.Main;
import br.thelast.tntbattle.utils.CreateBase;
import br.thelast.tntbattle.utils.CreateWall;

public class CreateCommand implements CommandExecutor {
	private final int TAMANHO = 20;
	private final int DISTANCIA = 35;
	private final int TAMANHO_PAREDE = 35;
	private final int LARGURA = 30;

	public Main PLUGIN;

	public CreateCommand(Main plugin) {
		this.PLUGIN = plugin;
		plugin.getCommand("criar").setExecutor(this);
	}
	//TEIBASDIUBASUIDB
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Comando apenas para jogadores");
			return true;
		}

		Player p = (Player) sender;

		int x = (int) p.getLocation().getX();
		int y = (int)p.getLocation().getY() - 1;
		int z = (int)p.getLocation().getZ();

		CreateWall.WallCreator(p, TAMANHO, DISTANCIA, TAMANHO_PAREDE, LARGURA ,  x, y, z, Material.BRICKS);
		CreateWall.WallCreator(p, TAMANHO, DISTANCIA, TAMANHO_PAREDE, LARGURA , x - 1, y, z, Material.BRICKS);

		CreateWall.WallCreator(p, TAMANHO, DISTANCIA, TAMANHO_PAREDE, LARGURA, x + 1, y, z, Material.BRICKS);
		CreateWall.WallCreator(p, TAMANHO, DISTANCIA, TAMANHO_PAREDE, LARGURA , x - 2, y, z, Material.BRICKS);

		CreateBase.BaseCreator(p, TAMANHO, DISTANCIA, x, y, z, Material.BEDROCK);
		CreateBase.BaseCreator(p, TAMANHO, DISTANCIA, x, y + 20, z, Material.GLASS);

		return true;

	}
}

// test