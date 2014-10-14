package net.novauniverse.novacheat.hack;

import net.novauniverse.novacheat.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class FastPlace implements Listener {

    ArrayList<String> fastPlace = new ArrayList<>();

    @EventHandler
    public void onFastPlace(BlockPlaceEvent e) {
        final Player p = e.getPlayer();

        if (fastPlace.contains(p.getName())) {
            e.setCancelled(true);
            p.sendMessage(Core.generateMessage("fast place"));
        } else if (!fastPlace.contains(p.getName())) {
            e.setCancelled(false);
            fastPlace.add(p.getName());

            Bukkit.getScheduler()
                    .runTaskLater(Core.plugin, new Runnable() {
                        @Override
                        public void run() {
                            fastPlace.remove(p.getName());
                        }
                    }, 4);
        }
    }
}
