package ru.putintsev.rogaandkopyta.telegramclient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import ru.putintsev.rogaandkopyta.telegramclient.command.MenuBotCommandEnum;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BotCommandService {

    public List<BotCommand> getMenuCommands(){
        log.info("Build dot commands");
        List<BotCommand> menuCommands = new ArrayList<>();

        for (MenuBotCommandEnum commandEnum : MenuBotCommandEnum.values()){
            String command = "/" + commandEnum.name().toLowerCase();
            menuCommands.add(new BotCommand(command, commandEnum.getDescription()));
        }
        return menuCommands;
    }
}
