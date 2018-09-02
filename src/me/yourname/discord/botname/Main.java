package me.yourname.discord.botname;

import me.yourname.discord.botname.command.Ping;
import me.yourname.discord.botname.core.commandHandler;
import me.yourname.discord.botname.listener.commandListener;
import me.yourname.discord.botname.listener.readyListener;
import me.yourname.discord.botname.util.SECRETS;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class Main {
    public static JDABuilder builder;

    public static void main(String[] Args) {

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(SECRETS.TOKEN);
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.ONLINE);


        builder.setGame(Game.watching("Slapende poedels"));
        /**
         * Je kan bijvoorbeeld met Game. listening, watching en streaming doen..
         */

        addListeners();
        addCommands();
        try {
            builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void addCommands(){
        commandHandler.commands.put("ping", new Ping());

    }

    public static void addListeners(){
        builder.addEventListener(new commandListener());
        builder.addEventListener(new readyListener());
    }
}

