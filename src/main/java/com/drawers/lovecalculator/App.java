package com.drawers.lovecalculator;

import com.drawers.lib.DrawersBotString;
import com.drawers.lib.DrawersBotStringHelp;
import org.drawers.bot.DrawersClient;
import org.drawers.bot.dto.DrawersMessage;

/**
 * Initializing the bot.
 */
public class App extends DrawersClient {

    public App(String clientId, String password) {
        super(clientId, password);
    }

    static private LoveCalculator loveCalculator = new LoveCalculator();

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(DrawersBotStringHelp.getDrawersBotStringHelp().toJsonString());

        if(args.length != 2) {
            System.out.println("Usage: java DictionaryBot <clientId> <password>");
        } else {
            String clientId = args[0];
            String password = args[1];
            App client = new App(clientId, password);
            client.startBot();
        }
    }

    @Override
    public DrawersMessage processMessageAndReply(DrawersMessage message) {
        try {
            DrawersBotString drawersBotString = DrawersBotString.fromString(message.getMessage());
            return new DrawersMessage(message.getSender(), loveCalculator.operate(drawersBotString).toString());
        } catch (Exception ex) {
            return new DrawersMessage(message.getSender(), "Something went wrong: " + ex.getLocalizedMessage());
        }
    }
}