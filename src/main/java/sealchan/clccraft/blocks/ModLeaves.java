package sealchan.clccraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sealchan.clccraft.Main;
import sealchan.clccraft.init.ModBlocks;
import sealchan.clccraft.init.ModItems;
import sealchan.clccraft.util.IHasModel;

import net.minecraft.init.Blocks;

public class ModLeaves extends BlockLeaves implements IHasModel 
{
	private String name;
	
	public ModLeaves(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.PLANT);
		setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		this.name = name;
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	

	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		if(!((Boolean)state.getValue(DECAYABLE)).booleanValue())
		{
			i |=2;
		}
		
		if(!((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
		{
			i |=4;
		}
		
		return i;
	}
	
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state)
	{
		return new ItemStack(this);
	}
	
	@Override
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) { return; }
	
	
	@Override
	public EnumType getWoodType(int meta) { return null; }
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
	{
		return NonNullList.withSize(1, new ItemStack(this));
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { DECAYABLE, CHECK_DECAY });
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) { return false; }
	
	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
		//return Blocks.LEAVES.getBlockLayer();
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        //return Blocks.LEAVES.shouldSideBeRendered(state, world, pos, side);
		return true;
    }

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
