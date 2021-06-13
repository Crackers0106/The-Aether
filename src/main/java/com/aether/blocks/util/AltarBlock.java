package com.aether.blocks.util;

//import java.util.Random;

//import com.aether.entities.block.AltarBlockEntity;

//import net.minecraft.block.AbstractFurnaceBlock;
//import net.minecraft.block.BlockState;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.screen.NamedScreenHandlerFactory;
//import net.minecraft.particles.ParticleTypes;
//import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.BlockView;
//import net.minecraft.world.World;

//import net.minecraft.block.AbstractBlock;

public class AltarBlock //extends AbstractFurnaceBlock
{
//	public AltarBlock(AbstractBlock.Properties settings) {
//		super(settings);
//	}
	
//	@Override
//	public BlockEntity createBlockEntity(BlockView world) {
//		return new AltarTileEntity();
//	}
	
//	@Override
//	protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
//		if (!world.ClientSided) { 
//			BlockEntity blockentity = world.getBlockEntity(pos);
//			if (tileentity instanceof AltarTileEntity) {
//				player.openMenu((NamedScreenHandlerFactory) blockentity);
//			}
//		}
//	}
	
//	@Override
//	public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
//		if (state.getValue(LIT)) {
//			double x = pos.getX() + 0.5;
//			double y = pos.getY() + 1.0 + (random.nextFloat() * 6.0) / 16.0;
//			double z = pos.getZ() + 0.5;
			
//			world.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0, 0.0, 0.0);
//			world.addParticle(ParticleTypes.FLAME, x, y, z, 0.0, 0.0, 0.0);
			
//			}
//		}
//	}
}