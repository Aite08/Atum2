package com.teammetallurgy.atum.blocks.stone.limestone;

import net.minecraft.block.BlockGravel;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class BlockLimestoneGravel extends BlockGravel {

    public BlockLimestoneGravel() {
        super();
        this.setHardness(0.6F);
        this.setSoundType(SoundType.GROUND);
    }

    @Override
    public boolean canSustainPlant(@Nonnull IBlockState state, @Nonnull IBlockAccess world, BlockPos pos, @Nonnull EnumFacing facing, IPlantable plantable) {
        EnumPlantType plantType = plantable.getPlantType(world, pos.offset(facing));
        return plantType == EnumPlantType.Desert;
    }

    @Override
    @Nonnull
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return MapColor.SAND;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getDustColor(IBlockState state) {
        return -2370656;
    }
}