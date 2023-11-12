package org.hakaton.besthakaton;

import org.bukkit.plugin.java.JavaPlugin;
import org.hakaton.besthakaton.commands.MineCommand;

public final class BestHakaton extends JavaPlugin {

    @Override
    public void onEnable() {
        MineCommand mineCommand = new MineCommand();
        getCommand("mine").setExecutor(mineCommand);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
