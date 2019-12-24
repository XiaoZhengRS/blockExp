package com.xiaozhengkeji.blockexp.listener;

import com.xiaozhengkeji.blockexp.BlockExp;
import com.xiaozhengkeji.blockexp.utils.BlockUtils;
import com.xiaozhengkeji.blockexp.utils.MsgUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;

public class CoreListener implements Listener {
    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block blockDamage = e.getBlock();
        Material material = blockDamage.getType();
        if (BlockExp.debug) {
            MsgUtils.logPlayer(p, "您当前挖取方块[" + material.name() + "]");
        }
        if (BlockUtils.blockExpIsBlock(material)) {
            Integer exp = BlockUtils.getBlockExp(material.name());
            p.giveExp(exp);
            if (BlockExp.debug) {
                MsgUtils.logPlayer(p, "您挖取指定方块[" + material.name() + "]获得指定经验[" + String.valueOf(exp) + "]");
            }
        }
    }
}
