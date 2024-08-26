package me.gregzee.chatcolorplus.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.StringArgument;
import me.gregzee.chatcolorplus.ChatColorPlus;
import me.gregzee.chatcolorplus.manager.ConfigManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ChatColorCommand {

	private static final ConfigManager configManager = ChatColorPlus.getConfigManager();

	public static void register() {
		new CommandAPICommand("chatcolorplus")
				.withAliases("ccp", "chatcolor")
				.withArguments(new StringArgument("subcommand"))
				.executes((sender, args) -> {
					if (args.get("subcommand") == "reload") {
						if (sender instanceof Player player) {
							configManager.reload();
							player.sendMessage(Component.text("Configuration reloaded").color(NamedTextColor.GREEN));
						} else if (sender instanceof ConsoleCommandSender console) {
							configManager.reload();
							console.sendMessage("Configuration reloaded");
						}
					}
				}).register();

	}
}
