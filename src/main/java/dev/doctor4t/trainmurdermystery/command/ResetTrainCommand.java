package dev.doctor4t.trainmurdermystery.command;

import com.mojang.brigadier.CommandDispatcher;
import dev.doctor4t.trainmurdermystery.game.TMMGameLoop;
import net.minecraft.block.BlockState;
import net.minecraft.component.ComponentMap;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class ResetTrainCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("tmm:resetTrain")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            TMMGameLoop.resetTrain(context.getSource().getWorld());
                            return 1;
                        })
        );
    }
}
