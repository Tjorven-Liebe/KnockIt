package eu.cericx.seruxmc;

import de.cericx.coreapi.util.logger.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Handler;

public class KnockIt extends JavaPlugin {

    @Override
    public void onLoad() {
        Logger.info("Load Knockit", " ...Register Classes");
    }

    @Override
    public void onEnable() {

        Logger.info("KnockIt by Cericx_ §estarted.");
    }

    @Override
    public void onDisable() {
        Logger.info("KnockIt by Cericx_ §cdisabled");
    }

}
