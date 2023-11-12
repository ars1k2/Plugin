package org.hakaton.besthakaton.commands;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MineCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player player = (Player)sender;
        Chunk chunk = player.getLocation().getChunk();
        World world = player.getWorld();

        int coal = 0, diamond = 0, copper = 0, emerald = 0, redstone = 0, gold = 0 , iron = 0;
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < world.getMaxHeight(); y++) {
                for (int z = 0; z < 16; z++) {
                    int blockX = chunk.getX() * 16 + x;
                    int blockY = y;
                    int blockZ = chunk.getZ() * 16 + z;

                    Block block = world.getBlockAt(blockX, blockY, blockZ);

                    Material blockType = block.getType();
                    if (blockType == Material.COAL_ORE || blockType == Material.DEEPSLATE_COAL_ORE || blockType == Material.DIAMOND_ORE ||  blockType == Material.DEEPSLATE_DIAMOND_ORE ||   blockType == Material.DEEPSLATE_COPPER_ORE || blockType == Material.COPPER_ORE ||
                            blockType == Material.EMERALD_ORE || blockType == Material.DEEPSLATE_EMERALD_ORE || blockType == Material.REDSTONE_ORE || blockType == Material.DEEPSLATE_REDSTONE_ORE ||blockType == Material.GOLD_ORE || blockType == Material.DEEPSLATE_GOLD_ORE ||
                            blockType == Material.IRON_ORE || blockType == Material.DEEPSLATE_IRON_ORE) {
                        player.sendMessage("Block at (" + blockX + ", " + blockY + ", " + blockZ + "): " + blockType);
                    }
                    if (blockType == Material.COAL_ORE || blockType == Material.DEEPSLATE_COAL_ORE) {
                        coal++;
                    }
                    if (blockType == Material.DIAMOND_ORE ||  blockType == Material.DEEPSLATE_DIAMOND_ORE) {
                        diamond++;
                    }
                    if (blockType == Material.DEEPSLATE_COPPER_ORE || blockType == Material.COPPER_ORE) {
                        copper++;
                    }
                    if (blockType == Material.EMERALD_ORE || blockType == Material.DEEPSLATE_EMERALD_ORE) {
                        emerald++;
                    }
                    if (blockType == Material.REDSTONE_ORE || blockType == Material.DEEPSLATE_REDSTONE_ORE) {
                        redstone++;
                    }
                    if (blockType == Material.GOLD_ORE || blockType == Material.DEEPSLATE_GOLD_ORE) {
                        gold++;
                    }
                    if (blockType == Material.IRON_ORE || blockType == Material.DEEPSLATE_IRON_ORE) {
                        iron++;
                    }


                }
            }
        }
        player.sendMessage("coal" + coal);
        player.sendMessage("diamond" + diamond);
        player.sendMessage("copper" + copper);
        player.sendMessage("emerald" + emerald );
        player.sendMessage("redstone" + redstone);
        player.sendMessage("gold" + gold);
        player.sendMessage("iron" + iron);

        return true;
    }
}