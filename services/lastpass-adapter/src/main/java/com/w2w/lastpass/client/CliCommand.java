package com.w2w.lastpass.client;

enum CliCommand {

    LIST_ALL_ITEMS("lpass ls -l");

    private final String command;

    CliCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
