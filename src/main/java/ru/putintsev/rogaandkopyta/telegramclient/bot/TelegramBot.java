package ru.putintsev.rogaandkopyta.telegramclient.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.putintsev.rogaandkopyta.telegramclient.config.BotConfiguration;
import ru.putintsev.rogaandkopyta.telegramclient.service.BotCommandService;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfiguration botConfiguration;
    private final BotCommandService botCommandService;

    @Override
    public String getBotUsername() {
        return botConfiguration.botName();
    }

    @Override
    public String getBotToken() {
        return botConfiguration.botToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
    }

    public void initBotCommands() {
        try {
            //TODO
            List<BotCommand> menuCommands = botCommandService.getMenuCommands();
            execute(new SetMyCommands(menuCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("Error at create and setting bot`s command: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
