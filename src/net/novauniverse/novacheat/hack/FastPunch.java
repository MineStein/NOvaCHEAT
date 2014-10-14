package net.novauniverse.novacheat.hack;

import net.novauniverse.novacheat.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;

public class FastPunch implements Listener {

    ArrayList<String> fastPunch = new ArrayList<>();

    @EventHandler
    public void onPunch(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            final Player p = (Player) e.getDamager();

            if (fastPunch.contains(p.getName())) {
                e.setCancelled(true);
                p.sendMessage(Core.generateMessage("fast hit"));
            } else if (!fastPunch.contains(p.getName())) {
                e.setCancelled(false);
                fastPunch.add(p.getName());

                Bukkit.getScheduler()
                        .runTaskLater(Core.plugin, new Runnable() {
                            @Override
                            public void run() {
                                fastPunch.remove(p.getName());
                            }
                        }, 4);
            }
        }
    }
}