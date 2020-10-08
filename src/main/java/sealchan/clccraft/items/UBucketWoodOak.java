package sealchan.clccraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.UniversalBucket;
import sealchan.clccraft.Main;
import sealchan.clccraft.init.ModItems;
import sealchan.clccraft.util.IHasModel;

public class UBucketWoodOak extends UniversalBucket implements IHasModel
{
	private final ItemStack empty = new ItemStack(this);
	
	public UBucketWoodOak(String name, CreativeTabs tab)
	{
		super(Fluid.BUCKET_VOLUME, ItemStack.EMPTY, true);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		ModItems.ITEMS.add(this);
	}

	public UBucketWoodOak(int bucketVolume) 
	{
		super(bucketVolume, ItemStack.EMPTY, true);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
