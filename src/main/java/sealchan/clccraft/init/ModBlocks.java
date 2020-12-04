package sealchan.clccraft.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import sealchan.clccraft.blocks.BarkMulchBlock;
import sealchan.clccraft.blocks.FlintStone;
import sealchan.clccraft.blocks.ModBlock;
import sealchan.clccraft.blocks.ModLeaves;
import sealchan.clccraft.blocks.ModLog;
import sealchan.clccraft.blocks.ModSapling;
import sealchan.clccraft.blocks.SyzygemStoneOre;
import sealchan.clccraft.blocks.TestBlock;
import sealchan.clccraft.blocks.leaves.LeavesMapleLimeGreen;
import sealchan.clccraft.worldgen.ModWorldGenBigTree;

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
	
	public static final Block PLANK_MAPLE_LIMEGREEN = new ModBlock("plank_maple_limegreen", Material.WOOD);
	public static final Block LOG_MAPLE_LIMEGREEN = new ModLog("log_maple_limegreen", ModItems.SAP_MAPLE_LIMEGREEN);
	public static final Block LEAVES_MAPLE_LIMEGREEN = new LeavesMapleLimeGreen("leaves_maple_limegreen");
	public static final Block SAPLING_MAPLE_LIMEGREEN = 
			new ModSapling("sapling_maple_limegreen", new ModWorldGenBigTree(false, LOG_MAPLE_LIMEGREEN, LEAVES_MAPLE_LIMEGREEN));

	//public static final Block TEST_BLOCK = new TestBlock("test_block", Material.WOOD);
}
