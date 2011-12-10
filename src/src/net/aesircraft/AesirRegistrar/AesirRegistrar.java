package net.aesircraft.AesirRegistrar;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class AesirRegistrar extends JavaPlugin
{
	private static AesirRegistrar instance = null;
	private final LoginListener LoginListener = new LoginListener(this);
	public static final Logger logger = Logger.getLogger("Minecraft");
	public PermissionHandler permissionHandler;
	private final playerListener playerListener = new playerListener(this);
	public static AesirRegistrar getStatic()
    
			
	{
		return instance;
	}
	private void setStatic()
	{
		instance = this;
	}
	private void setupPermissions()
	{
		Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");

		if (this.permissionHandler == null)
		{
			if (permissionsPlugin != null)
			{
				this.permissionHandler = ((Permissions)permissionsPlugin).getHandler();
			}
			else
			{
				logger.log(Level.SEVERE, "AesirRegistrar - Permission system not detected!");
			}
		}
	}

	@Override
	public void onDisable()
	{
		logger.info("AesirRegistrar is INACTIVE!");
	}

	@Override
	public void onEnable()
	{
		setStatic();
		setupPermissions();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_JOIN, LoginListener, Event.Priority.Highest, this);
		pm.registerEvent(Event.Type.PLAYER_CHAT, this.playerListener, Event.Priority.Lowest, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Event.Priority.Lowest, this);
		logger.info("AesirRegistrar is ACTIVE!");
	}
	
}
