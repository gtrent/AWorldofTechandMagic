package ly.biz.gtrent.gbw;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;



public class Crafting {

     GameRegistry.addRecipe(new ItemStack(topazblock,1), new Object[]{
	        "TTT","TTT","TTT",'T',topaz});
	        
	 GameRegistry.addShapelessRecipe(new ItemStack(topaz,9), new Object[]{
	        topazblock, });
}
