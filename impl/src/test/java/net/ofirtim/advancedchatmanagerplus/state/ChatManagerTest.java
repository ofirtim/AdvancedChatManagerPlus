package net.ofirtim.advancedchatmanagerplus.state;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.ofirtim.advancedchatmanagerplus.ChatFilter;
import net.ofirtim.advancedchatmanagerplus.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChatManagerTest {

    ChatManager chatManager = new ChatManager();

    @Test
    void testResultCompressionAllowStressed() {
        Component component = MiniMessage.miniMessage().deserialize("H3ll0! W3lc0m3 t0 th!$ $ymb0l-@nd-num3r!c t3$t. 5*5 553344 G00d-luck @nd $tay 4w3$0me!!!");
        chatManager.activeFilters.putAll("global", List.of(chatManager.SYMBOL_FILTER, chatManager.NUMBER_FILTER));
        Response result = chatManager.checkMessage("global", component);

        assertEquals(ChatFilter.ActionResult.DENY, result.actionResult());
        assertEquals(23,result.violations().values().stream().mapToInt(Integer::intValue).sum());
    }

    @Test
    void testResultCompressionAllow() {
        String input = "Hello world! Th1s !s a nice test b!tch b!tch";
        Component component = MiniMessage.miniMessage().deserialize("<red>" + input + "</red>");

        chatManager.activeFilters.putAll("global", List.of(chatManager.NUMBER_FILTER, chatManager.SYMBOL_FILTER));
        Response result = chatManager.checkMessage("global", component);

        assertEquals(ChatFilter.ActionResult.ALLOW, result.actionResult());
        assertEquals(4,result.violations().values().stream().mapToInt(Integer::intValue).sum());
    }
}
