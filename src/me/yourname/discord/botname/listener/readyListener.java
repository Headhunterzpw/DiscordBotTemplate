package me.yourname.discord.botname.listener;

import me.yourname.discord.botname.util.STATIC;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class readyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event) {

        String out = "VERSION: %version%\nThis bot is running on following servers: \n".replace("%version%", STATIC.VERSION);

        for (Guild g : event.getJDA().getGuilds() ) {
            out += g.getName() + " (" + g.getId() + ") \n";
        }

        System.out.println(out);

    }
}

