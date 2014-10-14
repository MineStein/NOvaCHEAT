package net.novauniverse.novacheat.hack;

import net.novauniverse.novacheat.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.ArrayList;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class FastBow implements Listener {

    ArrayList<String> speedArrow = new ArrayList<>();

    @EventHandler
    public void onSpeedArrow(ProjectileLaunchEvent e) {
        if (e.getEntity().getShooter() instanceof Player && e.getEntity() instanceof Arrow) {
            final Player p = (Player) e.getEntity().getShooter();

            if (speedArrow.contains(p.getName())) {
                e.setCancelled(true);
                p.sendMessage(Core.generateMessage("fast bow"));
            } else if (!speedArrow.contains(p.getName())) {
                e.setCancelled(false);
                speedArrow.add(p.getName());

                Bukkit.getScheduler()
                        .runTaskLater(Core.plugin, new Runnable() {
                            @Override
                            public void run() {
                                speedArrow.remove(p.getName());
                            }
                }, 12);
            }
        }
    }
}
