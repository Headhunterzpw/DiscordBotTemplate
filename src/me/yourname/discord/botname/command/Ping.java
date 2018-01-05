package me.yourname.discord.botname.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Timer;
import java.util.TimerTask;

public class Ping implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendMessage("Pong!").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}