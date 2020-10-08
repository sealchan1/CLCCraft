package sealchan.clccraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import sealchan.clccraft.Main;
import sealchan.clccraft.init.ModItems;
import sealchan.clccraft.util.IHasModel;

public class ModItem extends Item implements IHasModel 
{
	public ModItem(String name, CreativeTabs tab)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		ModItems.ITEMS.add(this);		
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
