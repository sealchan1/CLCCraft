package sealchan.clccraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sealchan.clccraft.init.ModItems;

public class SyzygemStoneOre extends ModBlock
{

	public SyzygemStoneOre() 
	{
		super("ore_syzygem_stone", Material.ROCK);
		
		setSoundType(SoundType.STONE);
		setHardness(1.5F);
		setResistance(6.0F);
		setHarvestLevel("pickaxe", 0);
	}
	
	@Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : RANDOM;

        EntityPlayer player = this.harvesters.get();
        if(player != null)
        {
        	ItemStack tool = player.getHeldItemMainhand();
        	if(tool.isItemEqualIgnoreDurability(new ItemStack(ModItems.SYZYGEM_STONE_PICKAXE)))
            {
        		// 1 in 81 chance
        		if(rand.nextInt(81) + 1 == 1)
        		{
        			drops.add(new ItemStack(Item.getItemFromBlock(Blocks.BEDROCK), 1, 0));
        			
        			// Reduce durability by 1/3
        			tool.setItemDamage(tool.getItemDamage() + ToolMaterial.STONE.getMaxUses());
        		}
        		// 1 in 9 chance
        		else if(rand.nextInt(9) + 1 == 1)
        		{
            		drops.add(new ItemStack(Item.getItemFromBlock(Blocks.STONE), 1, 0));
        		}
        		// 1 in 3 chance
        		else if(rand.nextInt(3) + 1 == 1)
        		{
        			drops.add(new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1, 0));
        			drops.add(new ItemStack(ModItems.SYZYGEM_STONE, this.quantityDropped(state, fortune, rand), 0));
        		}
        		else
        		{
        			drops.add(new ItemStack(ModItems.SYZYGEM_STONE, this.quantityDropped(state, fortune, rand) * 3, 0));
        		}
            }
            else
            {
            	drops.add(new ItemStack(
            			this.getItemDropped(state, rand, fortune), 
            			this.quantityDropped(state, fortune, rand), 
            			0
            			));
            }
        }
        else
        {
        	drops.add(new ItemStack(
        			this.getItemDropped(state, rand, fortune), 
        			this.quantityDropped(state, fortune, rand), 
        			0
        			));
        }
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return ModItems.SYZYGEM_STONE;
	}
	
	@Override
	public int quantityDropped(Random rand)
	{
		return rand.nextInt(2) + 1;
	}
}
