package sealchan.clccraft.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import sealchan.clccraft.items.BucketWoodOak;
import sealchan.clccraft.blocks.ModLog;
import sealchan.clccraft.init.ModBlocks;
import sealchan.clccraft.items.ModItem;
import sealchan.clccraft.items.PickaxeSyzygemStone;
import sealchan.clccraft.items.ShovelSyzygemFlint;
import sealchan.clccraft.items.UBucketWoodOak;

public class ModItems 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item BUCKET_WOOD_OAK = new BucketWoodOak("bucket_wood_oak", CreativeTabs.MISC);
	public static final Item BUCKET_WOOD_OAK_WATER = 
			new BucketWoodOak("bucket_wood_oak_water", CreativeTabs.MISC, Blocks.FLOWING_WATER);
	//public static final Item UBUCKET_WOOD_OAK = new UBucketWoodOak("bucket_wood_oak", CreativeTabs.MISC);
	
	public static final Item SYZYGEM_STONE = new ModItem("syzygem_stone", CreativeTabs.MISC);
	public static final Item SYZYGEM_FLINT = new ModItem("syzygem_flint", CreativeTabs.MISC);
	
	public static final PickaxeSyzygemStone SYZYGEM_STONE_PICKAXE = new PickaxeSyzygemStone("pickaxe_syzygem_stone", ToolMaterial.STONE);
	public static final ShovelSyzygemFlint SHOVEL_SYZYGEM_FLINT = new ShovelSyzygemFlint("shovel_syzygem_flint");
	

	public static final Item SAP_MAPLE_LIMEGREEN = new ModItem("sap_maple_limegreen", CreativeTabs.MISC);
}
