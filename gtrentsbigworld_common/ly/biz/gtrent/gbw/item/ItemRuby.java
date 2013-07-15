package ly.biz.gtrent.gbw.item;

import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;
import ly.biz.gtrent.gbw.GtrentsBigWorld;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.texture.IconRegister;

//public class ItemRuby extends Item {

//public ItemRuby(int par1) {
//super(par1); //Returns super constructor: par1 is ID


public final class ItemRuby extends Item{
private final String texture = "/textures/item/ruby.png"; // This is the path to the icon, please fill it with whatever you want as the icon
public ItemRuby(int par1){ // This is the constructor of the Item class it doesn't require the param of an integer but it is recomended
super(par1); // Call the super constructor, and passoff the integer param, this is required
this.setUnlocalizedName("ItemRuby"); // Sets the unlocalized name of the item, this is required
this.setCreativeTab(CreativeTabs.tabMisc); // Sets the creative tab of the item, this is not required




    //setTextureFile("/textures/item/ruby.png"); //Sets the item texture file

    //setItemName("GtrentItemRuby"); //Sets the incode name of the item, make sure it doesn't clash with other items, weird stuff happens

    //setCreativeTab(CreativeTabs.tabMaterials); //Tells the game what creative mode tab it goes in
    }

    @SideOnly(Side.CLIENT) //Marks a method as client side only, typically for graphics and rendering
    public int getItemIconFromDamage(int i){
    return 0; //The first icon on the spritesheet
    }

	@Override
    public void registerIcons(IconRegister register){ // This is the register icons method, this is overrrided from Item.java, this has a param of IconRegister
    this.itemIcon = register.registerIcon(this.texture); // This is where you set the Icon of the class using the String texture, see above
    }
}