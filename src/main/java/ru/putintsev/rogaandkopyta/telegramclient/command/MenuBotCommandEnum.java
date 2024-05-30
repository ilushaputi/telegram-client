package ru.putintsev.rogaandkopyta.telegramclient.command;

public enum MenuBotCommandEnum {

    START {
        public String getDescription() {
            return "СТАРТ";
        }
    }, HELP {
        public String getDescription() {
            return "ПОМОЩЬ";
        }
    };


    @SuppressWarnings("all")
    public String getDescription() {
        return this.getDescription();
    }

}
