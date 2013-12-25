package pl.dyrtcraft.christmas;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.plugin.java.JavaPlugin;

public class Christmas extends JavaPlugin implements Listener {
	
	private String message;
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		
		message = "§6\n= = = = = = = = = = = = = = = = = = = = = = = = = =\n" +
				"§2Wesolych Swiat oraz szczesliwego Nowego Roku!\n" +
				"§6= = = = = = = = = = = = = = = = = = = = = = = = = =\n\n" +
				"§4Miej zycie! Nie siedz przed kompem w czasie wigilii!";
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) {
		if(e.getPlayer().isOp()) {
			e.allow();
		} else {
			e.disallow(Result.KICK_WHITELIST, message);
		}
	}
	
}
