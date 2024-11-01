package net.ofirtim.advancedchatmanagerplus.api.models;

import net.ofirtim.advancedchatmanagerplus.api.structs.ChatChannel;
import net.ofirtim.advancedchatmanagerplus.api.structs.ChatPlayer;
import net.ofirtim.advancedchatmanagerplus.api.structs.Tag;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Class used to control and update player's information related to ACMP.
 * This class is the equivalent to Bukkit's main class caller.
 */
public interface PlayerManager {

    /**
     * Gets the {@link ChatPlayer} object with the information filled in as an optional.
     * This is the equivalent to Bukkit's player object to this plugin's information.
     * @param playerUniqueId the player's UniqueId, can be found on namemc.com or any other site that grabs skins & user info.
     * @return an {@link Optional} of {@link ChatPlayer}, if the ChatPlayer was found in database, the optional will not be empty (null).
     */
    Optional<ChatPlayer> getPlayer(UUID playerUniqueId);

    /**
     * Gets the {@link ChatPlayer}, object with the information filled as an optional.
     * This is the equivalent to Bukkit's player object to this plugin's information.
     * this command is identical to {@link PlayerManager#getPlayer(UUID)}, but allows getting a ChatPlayer object from its username and not unique id.
     * @param playerName the player's name.
     * @return an {@link Optional} of {@link ChatPlayer}, if the ChatPlayer was found in database, the optional will not be empty (null).
     */
    Optional<ChatPlayer> getPlayerFromName(String playerName);

    /**
     * This method does not return a direct Set to memory's online ChatPlayer's and is unmodifiable.
     * @return a set of online players, equivalent to bukkit's getOnlinePlayers only with ACMP's data.
     */
    Set<ChatPlayer> getOnlinePlayers();

    /**
     * Sets the player's chat channel in permanent context, until changed otherwise.
     * @param player The ChatPlayer reference object.
     * @param chatChannel The chat channel to assign to the player.
     */
    void setChatChannel(ChatPlayer player, ChatChannel chatChannel);

    /**
     *
     * @param player
     * @param tag
     */
    void addTag(ChatPlayer player, Tag tag);

    /**
     *
     * @param player
     * @param tag
     */
    void removeTag(ChatPlayer player, Tag tag);
}
