package net.shadowfacts.discordchat.api;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.shadowfacts.discordchat.api.command.ICommandManager;
import net.shadowfacts.discordchat.api.permission.IPermissionManager;

/**
 * @author shadowfacts
 */
public interface IDiscordChat {

	ILogger getLogger();

	IConfig getConfig();

	ICommandManager getCommandManager();

	IPermissionManager getPermissionManager();

	JDA getJDA();

	IMinecraftAdapter getMinecraftAdapter();

	void sendMessage(String message, MessageChannel channel);

	default void sendMessage(String message) {
		sendMessage(message, getJDA().getTextChannelById(getConfig().getChannelID()));
	}

}
