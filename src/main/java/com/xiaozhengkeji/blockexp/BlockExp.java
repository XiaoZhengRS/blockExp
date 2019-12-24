package com.xiaozhengkeji.blockexp;

import com.xiaozhengkeji.blockexp.config.Config;
import com.xiaozhengkeji.blockexp.listener.CoreListener;
import com.xiaozhengkeji.blockexp.utils.MsgUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public final class BlockExp extends JavaPlugin {
    public static FileConfiguration Config;
    public static Boolean debug;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        MsgUtils.logServer("加载中!");
        Config = getConfig();
        //注册监听器
        MsgUtils.logServer("注册监听完成!");
        getServer().getPluginManager().registerEvents(new CoreListener(), this);
        init();
        MsgUtils.logServer("加载完成!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MsgUtils.logServer("卸载完成!");
    }

    void init() {
        MsgUtils.logServer("方块数据初始化中!");
        debug = BlockExp.Config.getBoolean("debug");
        Set<String> Key = BlockExp.Config.getConfigurationSection("exp").getKeys(false);
        for (String k : Key) {
            Integer i = BlockExp.Config.getInt("exp." + k);
            com.xiaozhengkeji.blockexp.config.Config.blockexp.put(k, i);
            MsgUtils.logServer("方块数据[" + k + "]EXP--->[" + String.valueOf(i) + "]");
        }
    }
}
