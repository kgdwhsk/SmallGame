package win.kanmodel.smallgame;

import org.bukkit.Color;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import win.kanmodel.smallgame.Listener.chat;
import win.kanmodel.smallgame.Listener.death;
import win.kanmodel.smallgame.Listener.logout;
import win.kanmodel.smallgame.Listener.search;

public final class SmallGame extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //this.getServer().getConsoleSender().sendMessage(GeneralPluginProvider.getNAME() + "SmallGame started!");
        setUpPlugin();
        this.getCommand("dgrp").setExecutor(new Command());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void setUpListener() {
        this.getServer().getPluginManager().registerEvents(new death(),this);
        this.getServer().getPluginManager().registerEvents(new chat(),this);
        this.getServer().getPluginManager().registerEvents(new logout(),this);
//        this.getServer().getPluginManager().registerEvents(new search(),this);
    }

    public void setUpSettingManager() {

    }

    public void setUpAPI() {
        GeneralPluginProvider.getInstance().setUpPluginGetter(this);
    }

    public void setUpPlugin() {
        setUpAPI();
        GeneralPluginProvider.getInstance().getPlugin().getServer().getConsoleSender().sendMessage(GeneralPluginProvider.getNAME() + "SmallGame started!");
        //GeneralPluginProvider.getInstance().getPlugin().getCommand("dgrp").setExecutor(new Command());
        setUpListener();
        setUpSettingManager();
    }
}
