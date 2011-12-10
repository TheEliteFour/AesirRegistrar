package net.aesircraft.AesirRegistrar;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class LoginListener extends PlayerListener
{
	public static AesirRegistrar plugin;

	public LoginListener(AesirRegistrar instance)
	{
		plugin = instance;
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Check.run(event.getPlayer());
		event.getPlayer().sendMessage("no-z-cheat no-z-fly §2Welcome to SimplyAesir!");
		return;
	}
}
