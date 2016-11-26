package net.shadowfacts.discordchat.core.command.impl.permissions;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.shadowfacts.discordchat.api.IDiscordChat;
import net.shadowfacts.discordchat.api.command.ICommand;
import net.shadowfacts.discordchat.api.command.exception.CommandException;
import net.shadowfacts.discordchat.api.permission.IPermissionManager;

/**
 * @author shadowfacts
 */
public class CommandPermission implements ICommand {

	private IDiscordChat discordChat;
	private IPermissionManager permissionManager;

	public CommandPermission(IDiscordChat discordChat) {
		this.discordChat = discordChat;
		permissionManager = discordChat.getPermissionManager();
	}

	@Override
	public String getName() {
		return "permission";
	}

	@Override
	public void execute(String[] args, User sender, TextChannel channel) throws CommandException {
		discordChat.sendMessage("Permission level for " + sender.getName() + ": " + permissionManager.get(sender, channel.getGuild()), channel);
	}

	@Override
	public String getDescription() {
		return "Retrieves the caller's permission";
	}

	@Override
	public String getUsage() {
		return "[user]";
	}

}
