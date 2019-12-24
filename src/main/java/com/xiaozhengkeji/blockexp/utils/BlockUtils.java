package com.xiaozhengkeji.blockexp.utils;

import com.xiaozhengkeji.blockexp.config.Config;
import org.bukkit.Material;

import java.util.Set;

public class BlockUtils {
    public static Boolean isBlockMaterial(String ma, Material m) {
        //Material a = Material.getMaterial(ma);
        if (m.name().equalsIgnoreCase(ma)) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean blockExpIsBlock(Material m) {
        Set<String> key = Config.blockexp.keySet();
        for (String ma : key) {
            if (isBlockMaterial(ma, m)) {
                return true;
            }
        }
        return false;
    }

    public static Integer getBlockExp(String ma) {
        return Config.blockexp.get(ma);
    }
}
