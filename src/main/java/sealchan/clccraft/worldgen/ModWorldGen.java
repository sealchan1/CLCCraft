package sealchan.clccraft.worldgen;

import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import sealchan.clccraft.init.ModBlocks;

public class ModWorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) 
	{
		if(world.provider.getDimension() == 0) // Overworld
		{
			int oreSyzygemStoneChances = 80;  // Like Iron Ore @ 20 X 4 because 0 to 256 y level
			int oreCommonChances = 80; // Like Iron Ore @ 20 X 4 because 0 to 256 y level 
			generateOre(ModBlocks.ORE_SYZYGEM_STONE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 256, random.nextInt(7) + 4, 
					oreSyzygemStoneChances, BlockMatcher.forBlock(Blocks.STONE));
			generateOre(ModBlocks.STONE_FLINT.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 256, random.nextInt(7) + 4,
					oreCommonChances, BlockMatcher.forBlock(Blocks.GRAVEL));
		}
	}
	
	private void generateOre(IBlockState ore, World world, Random rand, int x, int z, int minY, int maxY, int size, int chances,
			Predicate<IBlockState> replace)
	{
		int deltaY = maxY - minY;
		for(int i = 0; i < chances; i++)
		{
			BlockPos pos = new BlockPos(x + rand.nextInt(16), minY + rand.nextInt(deltaY), z + rand.nextInt(16));
			WorldGenMinable generator = new WorldGenMinable(ore, size, (com.google.common.base.Predicate<IBlockState>) replace);
			generator.generate(world,  rand,  pos);
		}
	}
	
}
