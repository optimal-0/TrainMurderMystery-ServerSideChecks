package dev.doctor4t.trainmurdermystery.command;

import com.mojang.brigadier.CommandDispatcher;
import dev.doctor4t.trainmurdermystery.cca.GameWorldComponent;
import dev.doctor4t.trainmurdermystery.game.GameFunctions;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class StartLooseEndsCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("tmm:startLooseEnds")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                                    GameFunctions.startGame(context.getSource().getWorld(), GameWorldComponent.GameMode.LOOSE_ENDS);
                                    return 1;
                                }
                        )
        );
    }
}
