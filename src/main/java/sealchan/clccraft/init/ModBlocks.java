package sealchan.clccraft.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import sealchan.clccraft.blocks.BarkMulchBlock;
import sealchan.clccraft.blocks.FlintStone;
import sealchan.clccraft.blocks.ModBlock;
import sealchan.clccraft.blocks.SyzygemStoneOre;
import sealchan.clccraft.blocks.TestBlock;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BARKMULCH_ACACIA = new BarkMulchBlock("barkmulch_acacia");
	public static final Block BARKMULCH_BIRCH = new BarkMulchBlock("barkmulch_birch");
	public static final Block BARKMULCH_DARKOAK = new BarkMulchBlock("barkmulch_darkoak");
	public static final Block BARKMULCH_JUNGLE = new BarkMulchBlock("barkmulch_jungle");
	public static final Block BARKMULCH_OAK = new BarkMulchBlock("barkmulch_oak");
	public static final Block BARKMULCH_SPRUCE = new BarkMulchBlock("barkmulch_spruce");
	
	public static final Block ORE_SYZYGEM_STONE = new SyzygemStoneOre();
	public static final Block STONE_FLINT = new FlintStone();
	
	//public static final Block TEST_BLOCK = new TestBlock("test_block", Material.WOOD);
}
