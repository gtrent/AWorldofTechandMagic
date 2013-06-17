package ly.biz.gtrent.gbw;

import ly.biz.gtrent.gbw.lib.*;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;


@Mod( modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION) // //Gives Forge extra info about your mod

@NetworkMod(clientSideRequired=true,serverSideRequired=false, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"CLIENT_CHANNEL1" }, packetHandler = ClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {}, packetHandler = ServerPacketHandler.class)) //For serverside packet handling



public class GtrentsBigWorld { //The class file

    @Instance("INSTANCE") //The instance, this is very important later on
    public static GtrentsBigWorld instance = new GtrentsBigWorld();
    
    @SidedProxy(clientSide = "ly.biz.gtrent.gbw.ClientProxy", serverSide = "ly.biz.gtrent.gbw.CommonProxy") //Tells Forge the location of your proxies
    public static CommonProxy proxy;

    
    
    public static Block topazblock;
    public static Item topaz;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    //telling forge that I am making these
    
    //items
    
    
    topaz = new GemItems(2013).setUnlocalizedName("topaz");
   
    
    
    
    topazblock = new TopazBlock(3608, "Topaz Block").setUnlocalizedName("topazblock").setHardness(2.0F).setStepSound(Block.soundMetalFootstep).setResistance(10.0F);
    GameRegistry.registerBlock(topazblock, "Topaz Block");
    
    //names
    LanguageRegistry.addName(topaz, "Topaz Gem");
    LanguageRegistry.addName(topazblock, "Topaz Block");
    
    //crafting
    
    GameRegistry.addRecipe(new ItemStack(topazblock,1), new Object[]{
        "TTT","TTT","TTT",'T',topaz});
        
    GameRegistry.addShapelessRecipe(new ItemStack(topaz,9), new Object[]{
        topazblock, });
   
    NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data
    };
     
    @Init
    public void init(FMLInitializationEvent event) {
           
        GameRegistry.registerWorldGenerator(new WorldGenHandle());
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }  
    
   

    
}