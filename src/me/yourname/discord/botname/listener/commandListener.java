package me.yourname.discord.botname.listener;

import me.yourname.discord.botname.core.commandHandler;
import me.yourname.discord.botname.util.STATIC;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class commandListener extends ListenerAdapter {
       public void onMessageReceived(MessageReceivedEvent event) {


        if (event.getAuthor().isBot()) return;

        if (event.isFromType(ChannelType.TEXT))
        {
            System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getAuthor(), event.getMessage().getContentDisplay());
            if (event.getMessage().getContentDisplay().startsWith(STATIC.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
                commandHandler.handleCommand(commandHandler.parse.parser(event.getMessage().getContentRaw(), event));
            }
        }


    }

    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        System.out.println("{PRIVATE} " + event.getAuthor().getName() + " : " + event.getMessage().getContentDisplay());
        //You can do something like sending an message that this bot won't work in private chats etc..
    }
}
