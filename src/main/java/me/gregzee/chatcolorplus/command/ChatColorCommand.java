package me.gregzee.chatcolorplus.command;

import dev.jorel.commandapi.CommandAPICommand;

public class ChatColorCommand {

	public static void register() {
		new CommandAPICommand("chatcolorplus")
				.withAliases("ccp", "chatcolor")
				.executes(commandExecutor -> {

				}).register();

	}
}
