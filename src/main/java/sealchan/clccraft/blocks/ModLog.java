package sealchan.clccraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sealchan.clccraft.Main;
import sealchan.clccraft.init.ModBlocks;
import sealchan.clccraft.init.ModItems;
import sealchan.clccraft.items.ModItem;
import sealchan.clccraft.util.IHasModel;

public class ModLog extends BlockLog implements IHasModel
{
	private boolean hasSap = false;
	private Item sapType = new Item();
	
	public ModLog(String name) 
	{
		super();
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));
		setSoundType(SoundType.WOOD);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public ModLog(String name, Item sap)
	{
		this(name);
		
		sapType = sap;
		hasSap = true;
	}
	
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = this.getDefaultState();

        switch (meta & 12)
        {
            case 0:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 4:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 8:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return state;
    }
	
    @Override
    @SuppressWarnings("incomplete-switch")
    public int getMetaFromState(IBlockState state)
    {
        int meta = 0;

        switch (state.getValue(LOG_AXIS))
        {
            case X:
                meta |= 4;
                break;
            case Z:
                meta |= 8;
                break;
            case NONE:
                meta |= 12;
        }

        return meta;
    }
    
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }
	
    
    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : RANDOM;

        int count = quantityDropped(state, fortune, rand);
        for (int i = 0; i < count; i++)
        {
            Item item = this.getItemDropped(state, rand, fortune);
            if (item != Items.AIR)
            {
                drops.add(new ItemStack(item, 1, this.damageDropped(state)));
            }
            
    		// 1 in 9 chance
    		if(hasSap && rand.nextInt(9) + 1 == 1)
    		{
    			drops.add(new ItemStack(this.sapType, 1, 0));
    		}
        }
        
    }
    
    
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
