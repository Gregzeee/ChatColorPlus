package me.gregzee.chatcolorplus.manager;

import de.exlll.configlib.ConfigLib;
import de.exlll.configlib.YamlConfigurationProperties;
import de.exlll.configlib.YamlConfigurations;
import lombok.Getter;
import me.gregzee.chatcolorplus.ChatColorPlus;
import me.gregzee.chatcolorplus.config.Settings;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Getter
public class ConfigManager {

    private final ChatColorPlus plugin;
    private Settings settings;

    public ConfigManager(ChatColorPlus plugin) {
        this.plugin = plugin;
    }

    @NotNull
    public Optional<Throwable> loadConfig() {
        final YamlConfigurationProperties properties = ConfigLib.BUKKIT_DEFAULT_PROPERTIES.toBuilder()
                .charset(StandardCharsets.UTF_8)
                .outputNulls(true)
                .inputNulls(false)
                .build();
        final File settingsFile = new File(plugin.getDataFolder(), "config.yml");

        try {
            settings = YamlConfigurations.update(
                    settingsFile.toPath(),
                    Settings.class,
                    properties
            );
            return Optional.empty();
        } catch (Exception e) {
            return Optional.of(e);
        }
    }

    public void reload() {
        final YamlConfigurationProperties properties = ConfigLib.BUKKIT_DEFAULT_PROPERTIES.toBuilder()
                .charset(StandardCharsets.UTF_8)
                .outputNulls(true)
                .inputNulls(false)
                .build();
        settings = YamlConfigurations.load(new File(plugin.getDataFolder(), "config.yml").toPath(), Settings.class, properties);
    }
}
