package net.aesircraft.AesirRegistrar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


public class Filer
{
	public static boolean exist(Player player){
		File file = new File(AesirRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
		if (file.exists()){
			return true;
		}
		return false;
	}
	public static boolean failExist(Player player){
		File file = new File(AesirRegistrar.getStatic().getDataFolder().toString() + File.separator + "fails" +File.separator +player.getName().toLowerCase()+".yml");
		if (file.exists()){
			return true;
		}
		return false;
	}
	public static void failDelete(Player player){
		File file = new File(AesirRegistrar.getStatic().getDataFolder().toString() + File.separator + "fails" +File.separator +player.getName().toLowerCase()+".yml");
		if (!file.exists()){
			return;
		}
		file.delete();
		return;
	}
	public static void failed(Player player){
		File file = new File(AesirRegistrar.getStatic().getDataFolder().toString() + File.separator + "fails" +File.separator +player.getName().toLowerCase()+".yml");
        try
		{
			file.createNewFile();
			FileWriter fileWriter = null;
				BufferedWriter bufferWriter = null;
				fileWriter = new FileWriter(file);
				bufferWriter = new BufferedWriter(fileWriter);
				bufferWriter.append("---");
				bufferWriter.newLine();
				bufferWriter.append("failed: proxy-simplyaesir");
				bufferWriter.flush();
				bufferWriter.close();
				fileWriter.close();
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirRegistrar - Issue writing fails file for "+player.getName(), ex);
		}
		return;
	}
	public static boolean override(Player player){
		File file = new File(AesirRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		int val=config.getInt("override", 0);
		if (val==1)
			return true;
		return false;
	}
	public static String ip(Player player){
		File file = new File(AesirRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		String val=config.getString("ip");
		return val;
	}
}
