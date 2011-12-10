package net.aesircraft.AesirRegistrar;
import java.net.InetAddress;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Check
{
	public static void run(Player player){
		if (AesirRegistrar.getStatic().permissionHandler.has((Player)player, "registrar.registered")&&!(Filer.exist(player)))
				{
					player.sendMessage("§eYou need to register on http://aesircraft.net, login, go to Profile, Select Memberships, and activate your account under SimplyAesir!");
					return;
				}
		if (AesirRegistrar.getStatic().permissionHandler.has((Player)player, "registrar.registered")&&Filer.exist(player))
				{
					Filer.failDelete(player);
					return;
				}
		if (Filer.exist(player)){
			InetAddress iAddress= player.getAddress().getAddress();
			String ip=iAddress.toString();
			String comp="/"+Filer.ip(player);
			if (!ip.equals(comp)){
				if (Filer.override(player)){
					
					
					CommandSender cs = AesirRegistrar.getStatic().getServer().getConsoleSender();
		AesirRegistrar.getStatic().getServer().dispatchCommand(cs, "permissions player setgroup "+player.getName()+" Member");
		player.sendMessage("§2You have been promoted to Member, WELCOME TO SimplyAesir!");
		Filer.failDelete(player);
		return;
					
					
				}
				else{
					Filer.failed(player);
					player.sendMessage("§4Ip doesnt match registration. Proxies are not allowed. You have been submitted for Staff Approval.");
					return;
				}
			}
			CommandSender cs = AesirRegistrar.getStatic().getServer().getConsoleSender();
		AesirRegistrar.getStatic().getServer().dispatchCommand(cs, "permissions player setgroup "+player.getName()+" Member");
		player.sendMessage("§2You have been promoted to Member, WELCOME TO SimplyAesir!");
		Filer.failDelete(player);
		return;
		}
		player.sendMessage("§4You need to register on http://aesircraft.net, login, go to Profile, Select Memberships, and activate your account under SimplyAesir in order to be able to play!");
	}
}
