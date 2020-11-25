package sealchan.clccraft.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import sealchan.clccraft.init.ModBlocks;
import sealchan.clccraft.init.ModItems;
import sealchan.clccraft.util.IHasModel;
import sealchan.clccraft.worldgen.ModWorldGen;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item: ModItems.ITEMS)
		{
			if (item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block: ModBlocks.BLOCKS)
		{
			if (block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	

	public static void registerOreDictionaryEntries()
    {
        OreDictionary.registerOre("logWood", ModBlocks.LOG_MAPLE_LIMEGREEN);
        
        OreDictionary.registerOre("slimeball", ModItems.SAP_MAPLE_LIMEGREEN);
        
        OreDictionary.registerOre("listAllwater", ModItems.BUCKET_WOOD_OAK_WATER);
    }

	
	public static void otherRegisters()
	{
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
	}
}
