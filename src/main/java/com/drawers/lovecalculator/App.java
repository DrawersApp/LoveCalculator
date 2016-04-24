package com.drawers.lovecalculator;

import org.drawers.bot.DrawersClient;
import org.drawers.bot.dto.DrawersMessage;

/**
 * Initializing the bot.
 */
public class App extends DrawersClient {

    public App(String clientId, String password) {
        super(clientId, password);
    }

    private LoveCalculator loveCalculator = new LoveCalculator();

    public static void main(String[] args) throws ClassNotFoundException {
        // Load all the classes which contains string.
//        Class.forName(MeaningOperations.class.getName());
 //       System.out.println(DrawersBotStringHelp.getDrawersBotStringHelp().toJsonString());

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
        String [] names = message.getMessage().split(" ");
        if (names.length != 2) {
            return new DrawersMessage(message.getSender(), "Please provide two names");
        }
        return new DrawersMessage(message.getSender(), loveCalculator.calculate(names[0], names[1]).toString());
    }
}