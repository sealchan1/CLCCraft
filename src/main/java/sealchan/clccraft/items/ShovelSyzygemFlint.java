package sealchan.clccraft.items;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;
import sealchan.clccraft.Main;
import sealchan.clccraft.init.ModItems;
import sealchan.clccraft.util.IHasModel;

public class ShovelSyzygemFlint extends ItemSpade implements IHasModel
{

	public ShovelSyzygemFlint(String name) 
	{
		super(ToolMaterial.STONE);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		this.setMaxDamage(ToolMaterial.STONE.getMaxUses() * 3);  // Syzygems give 3x the durability
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}

