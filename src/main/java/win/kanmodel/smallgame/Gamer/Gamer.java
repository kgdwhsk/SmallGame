package win.kanmodel.smallgame.Gamer;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import win.kanmodel.smallgame.GeneralPluginProvider;
import win.kanmodel.smallgame.Chat.Channel;

public class Gamer {
	Player player = null;
	static Channel currentChannel = null;
	public static final int GAMER_JUDGE = 2;
	public static final int GAMER_KILLER = 1;
	public static final int GAMER_NORMAL = 0;
	int type = GAMER_NORMAL;
	boolean isDead = false;
	
	
	public Gamer(Player player,int type,Channel currentChannel,boolean isDead){
		this.player = player;
		this.type = type;
		this.currentChannel = currentChannel;
		this.isDead = isDead;
	}
	
	public Player getPlayer(){
		return this.player;
	}
	
	public Channel getCurrentChannel(){
		return this.currentChannel;
	}
	
	public void kill(){
		if(this.isDead)
			return;
		this.isDead = true;
		this.setNoclip(true);
		this.setChannel(Channel.getJudgeC());
	}
	
	public void setChannel(Channel channel){
		this.currentChannel.removePlayer(player);
		this.currentChannel = channel;
		this.currentChannel.addPlayer(player);
	}
	
	/*
	
	public void setChannel(Channel channel, int type){
		this.currentChannel.removePlayer(player);
		this.currentChannel = channel;
		this.currentChannel.addPlayer(player);
		this.type = type;
	}
	
	*/
	
	public void setType(int type){
		this.type = type;
	}
	
	public void setNoclip(boolean a){
		if(a){
			this.player.setGameMode(GameMode.SPECTATOR);
			return;
		} else {
			this.player.setGameMode(GameMode.SURVIVAL);
			return;
		}
	}

	public int getType() {
		return type;
	}
}
