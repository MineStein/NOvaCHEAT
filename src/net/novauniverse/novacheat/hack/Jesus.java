package net.novauniverse.novacheat.hack;

import net.novauniverse.novacheat.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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
                while (e.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getType().equals(Material.WATER) || e.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getType().equals(Material.STATIONARY_WATER)) {
                    e.getPlayer().teleport(e.getPlayer().getLocation().subtract(0, 1, 0));
                }

                e.getPlayer().sendMessage(Core.generateMessage("water walking"));
                Bukkit.getLogger().warning(e.getPlayer().getName()+" is suspected of Water Walking hacks.");
                jesus1.remove(e.getPlayer().getName());
            } else {
                jesus1.add(e.getPlayer().getName());
            }
        }
    }
}
