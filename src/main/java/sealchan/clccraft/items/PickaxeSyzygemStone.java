package sealchan.clccraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import sealchan.clccraft.Main;
import sealchan.clccraft.init.ModItems;
import sealchan.clccraft.util.IHasModel;

public class PickaxeSyzygemStone extends ItemPickaxe implements IHasModel
{

	public PickaxeSyzygemStone(String name, ToolMaterial material) 
	{
		super(material);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		this.setMaxDamage(material.getMaxUses() * 3);  // Syzygems give 3x the durability
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this,  0,  "inventory");
	}
	
}
