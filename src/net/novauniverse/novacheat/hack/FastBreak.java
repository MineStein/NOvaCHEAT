package net.novauniverse.novacheat.hack;

import net.novauniverse.novacheat.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class FastBreak implements Listener {

    ArrayList<String> fastBreak = new ArrayList<>();

    @EventHandler
    public void onFastBreak(BlockBreakEvent e) {
        final Player p = e.getPlayer();

        if (fastBreak.contains(p.getName())) {
            e.setCancelled(true);
            p.sendMessage(Core.generateMessage("fast break"));
        } else if (!fastBreak.contains(p.getName())) {
            e.setCancelled(false);
            fastBreak.add(p.getName());

            Bukkit.getScheduler()
                    .runTaskLater(Core.plugin, new Runnable() {
                        @Override
                        public void run() {
                            fastBreak.remove(p.getName());
                        }
                    }, 3);
        }
    }
}
