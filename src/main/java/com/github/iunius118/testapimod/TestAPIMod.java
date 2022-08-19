package com.github.iunius118.testapimod;

import com.github.iunius118.testapimod.api.TestAPI;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Mod(TestAPIMod.MOD_ID)
public class TestAPIMod extends TestAPI {
    public static final String MOD_ID = "testapimod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestAPIMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        List<Consumer<PlayerEvent.PlayerLoggedInEvent>> copy;

        synchronized (TestAPI.methods) {
            copy = new ArrayList<>(TestAPI.methods);
        }

        // Call registered methods
        copy.forEach(method -> method.accept(event));
    }
}
