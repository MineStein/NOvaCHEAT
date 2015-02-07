package net.novauniverse.novacheat.hack;

import net.novauniverse.novacheat.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Jesus implements Listener {

    ArrayList<String> jesus1 = new ArrayList<>();

    @EventHandler
    public void onHack(PlayerMoveEvent e) {
        if (e.getFrom().getPitch()!=e.getTo().getPitch()||e.getFrom().getYaw()!=e.getTo().getYaw()) return;

        if (e.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getType()== Material.WATER|| e.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getType()==Material.STATIONARY_WATER) {
            if (jesus1.contains(e.getPlayer().getName())) {
                final Player p = e.getPlayer();
                Bukkit.getScheduler().runTaskLater(Core.plugin, new Runnable() {
                    @Override
                    public void run() {
                        if (p.getLocation().subtract(0, 1, 0).getBlock().getType()==Material.WATER||p.getLocation().subtract(0, 1, 0).getBlock().getType()==Material.STATIONARY_WATER) {
                            p.sendMessage(Core.generateMessage("water walking"));
                            Bukkit.getLogger().warning(p.getName()+" is suspected of Water Walking hacks.");
                            p.teleport(p.getLocation().subtract(0, 1, 0));
                        }
                    }
                }, 25);
            } else {
                jesus1.add(e.getPlayer().getName());
            }
        }
    }
}
