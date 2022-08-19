package com.github.iunius118.testapimod.api;

import com.mojang.logging.LogUtils;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * A test API
 */
public class TestAPI {
    protected static final List<Consumer<PlayerEvent.PlayerLoggedInEvent>> methods = new ArrayList<>();
    private static final Logger LOGGER = LogUtils.getLogger();

    /**
     * Register a method to be called on {@link net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent}.
     * @param method The method to register.
     */
    public static void registerMethod(@Nonnull Consumer<PlayerEvent.PlayerLoggedInEvent> method) {
        synchronized (methods) {
            methods.add(method);
        }

        LOGGER.debug("Registered method: {}", method.getClass().toString());
    }
}
