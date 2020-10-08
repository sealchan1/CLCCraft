package sealchan.clccraft.blocks;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import sealchan.clccraft.Main;
import sealchan.clccraft.init.ModBlocks;
import sealchan.clccraft.init.ModItems;
import sealchan.clccraft.util.IHasModel;

public class BarkMulchBlock extends BlockFalling implements IHasModel
{
	public BarkMulchBlock(String name) 
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		//setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		setHardness(0.5F);
		setHarvestLevel("shovel", 0);
		this.setResistance(0.5F);
		this.setSoundType(SoundType.GROUND);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
