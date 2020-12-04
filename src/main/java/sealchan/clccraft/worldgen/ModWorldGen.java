package sealchan.clccraft.worldgen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import sealchan.clccraft.init.ModBlocks;
import sealchan.clccraft.blocks.ModSapling;

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
			
			// The lower the value the more likely that these large trees will cause cascading worldgen lag
			int treeMapleLimeGreenChances = 99;  
			// Caused by: java.lang.NullPointerException at sealchan.clccraft.worldgen.ModWorldGenBigTree.crosSection(ModWorldGenBigTree.java:122) ~[ModWorldGenBigTree.class:?]
			generateTree(((ModSapling)ModBlocks.SAPLING_MAPLE_LIMEGREEN).getGenerator(), world, random, chunkX, chunkZ, 
					treeMapleLimeGreenChances, Blocks.GRASS, Biomes.FOREST.getClass());
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
	
	private void generateTree(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, 
			Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + random.nextInt(15);
		int z = (chunkZ * 16) + random.nextInt(15);
		int y = calculateGenerationHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x, y, z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(random.nextInt(chance) == 0)
				{
					generator.generate(world, random, pos);
				}
			}
		}
	}
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
	{
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0)
		{
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = block == topBlock;
		}
		
		return y;
	}
	
}
