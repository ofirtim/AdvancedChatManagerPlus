package net.ofirtim.advancedchatmanagerplus.filtration;

import net.ofirtim.advancedchatmanagerplus.ChatFilter;

class NumberObfuscationChatFilterTest implements ChatFilterTest {

    @Override
    public ChatFilter getFilter() {
        return getChatManager().NUMBER_FILTER;
    }

    @Override
    public String getInput() {
        return "Hell0 m47e how are you";
    }

    @Override
    public String getExpectedOutput() {
        return "Hello mate how are you";
    }

    @Override
    public int getExpectedViolations() {
        return 3;
    }
}
