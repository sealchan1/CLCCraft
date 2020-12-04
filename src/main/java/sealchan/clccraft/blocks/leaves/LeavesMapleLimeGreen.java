package sealchan.clccraft.blocks.leaves;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import sealchan.clccraft.blocks.ModLeaves;
import sealchan.clccraft.init.ModBlocks;

public class LeavesMapleLimeGreen extends ModLeaves
{

	public LeavesMapleLimeGreen(String name) 
	{
		super(name);
	}
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.SAPLING_MAPLE_LIMEGREEN);
    }

}
