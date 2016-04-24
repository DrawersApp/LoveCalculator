package com.drawers.lovecalculator;

import com.drawers.lib.*;
import retrofit.RestAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant.pathak on 24/04/16.
 */
public class LoveCalculator implements Operation {
    private static ILoveCalculator calculator;
    private static DrawersBotString love;

    private static List<BotStringElement> botStringElements = new ArrayList<>();

    @Override
    public Response operateInternal(DrawersBotString body) {
        return calculator.getLove(fName, sName);

    }

    @Override
    public boolean validateAndParse(DrawersBotString drawersBotString) {
        if (drawersBotString.getBotStringElements() == null ||
                drawersBotString.getBotStringElements().isEmpty()
                || drawersBotString.getBotStringElements().size() != love.getBotStringElements().size()) {
            return false;
        }
        if (drawersBotString.getBotStringElements().size() != 3) return false;
        fName = drawersBotString.getBotStringElements().get(0).getText();
        sName = drawersBotString.getBotStringElements().get(2).getText();

        return !(this.fName == null || this.sName == null);
    }

    private String fName = null;
    private String sName = null;

    private enum OperationFindLove {
        LOVE
    }

    static {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://love-calculator.p.mashape.com")
                .build();
        calculator = restAdapter.create(ILoveCalculator.class);
        botStringElements.add(new BotStringElement(BotStringType.S, "Bob", null));
        botStringElements.add(new BotStringElement(BotStringType.U, "loves"));
        botStringElements.add(new BotStringElement(BotStringType.S, "Alice", null));
        love = new DrawersBotString(botStringElements, OperationFindLove.LOVE.name());
        DrawersBotStringHelp.getDrawersBotStringHelp().getDrawersBotStrings().add(love);
        System.out.println("help added");
    }
}
