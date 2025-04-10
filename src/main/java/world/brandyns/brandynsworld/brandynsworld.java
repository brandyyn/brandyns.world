package world.brandyns.brandynsworld;

import cpw.mods.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

import net.minecraft.item.Item;

@Mod(modid = "brandynsworld", version = "1.0", name = "Brandyn's World", acceptedMinecraftVersions = "[1.7.10]")
public class brandynsworld {

    public static final Logger LOG = LogManager.getLogger();
    public static Item axolotl_bucket;
    public static Item banana;

    @SidedProxy(clientSide = "world.brandyns.brandynsworld.ClientProxy", serverSide = "world.brandyns.brandynsworld.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        axolotl_bucket = new axolotl_bucket().setUnlocalizedName("axolotl_bucket").setTextureName("brandynsworld:axolotl_bucket");
        GameRegistry.registerItem(axolotl_bucket, axolotl_bucket.getUnlocalizedName().substring(5));

        banana = new banana().setUnlocalizedName("banana").setTextureName("brandynsworld:banana");
        GameRegistry.registerItem(banana, banana.getUnlocalizedName().substring(5));
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
