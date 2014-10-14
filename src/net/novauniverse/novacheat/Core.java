package net.novauniverse.novacheat;

import net.novauniverse.novacheat.hack.*;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Core extends JavaPlugin {

    /*
     * ----------------------------------------
     * You are suspected of cheating by NovaU's
     * automated system. The system thinks you
     * are cheating because of the detected
     * <HackName>. If you are not cheating
     * do not fret. You probably have a
     * poor connection from the client to the
     * server.
     *
     * Disclaimer: Any hacked or modded
     * clients are not allowed. Exceptions
     * can be found at the URL included in the
     * description log.
     *
     * Hack Name: <HackName>
     * Suspected Client
     * Modification Exceptions
     *
     * Thank you, from the NovaUniverse staff.
     * ----------------------------------------
     */

    public static final String PREFIX = "§8[§5NOvaCHEAT§8] §f";
    public static Core plugin;

    public static String[] generateMessage(String hackName) {
        String[] message = new String[] {
            "§4§l§m---------------------------------------------",
            "§cYou are suspected of cheating by §5§lNova§6§lU§8'§cs",
            "§cautomated system. The system thinks you",
            "§care cheating because of the detected",
            "§e§l"+hackName.toUpperCase()+"§c. If you are not cheating",
            "§cdo not fret. You probably have a",
            "§cpoor connection from the client to the",
            "§cserver.",
            "",
            "§4§lDisclaimer§8: §cAny hacked or modded",
            "§cclients are not allowed. Exceptions",
            "§ccan be found at the URL included in the",
            "§cdescription log.",
            "",
            "§4§lHack Name§8: §e§l"+hackName.toUpperCase(),
            "§4§lSuspected Client§8: §e§lWEEPCRAFT 1.7",
            "§4§lModification Exceptions",
            "",
            "§cThank you, from the §5§lNova§6§lUniverse §cstaff.",
            "§4§l§m---------------------------------------------"
        };

        return message;
    }

    @Override
    public void onEnable() {
        plugin = this;

        getServer().getPluginManager().registerEvents(new Jesus(), this);
        getServer().getPluginManager().registerEvents(new FastBow(), this);
        getServer().getPluginManager().registerEvents(new FastPlace(), this);
        getServer().getPluginManager().registerEvents(new FastBreak(), this);
        getServer().getPluginManager().registerEvents(new FastPunch(), this);
    }
}
