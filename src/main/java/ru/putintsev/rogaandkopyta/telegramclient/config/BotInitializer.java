package ru.putintsev.rogaandkopyta.telegramclient.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.putintsev.rogaandkopyta.telegramclient.bot.TelegramBot;

@Component
@RequiredArgsConstructor
public class BotInitializer {

    private final TelegramBot telegramBot;

    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        TelegramBotsApi telegramBotsApi;
        try {
            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBot.initBotCommands();
            telegramBotsApi.registerBot(telegramBot);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
