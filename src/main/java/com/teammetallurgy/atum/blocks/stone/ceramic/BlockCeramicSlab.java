package com.teammetallurgy.atum.blocks.stone.ceramic;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.teammetallurgy.atum.blocks.base.BlockAtumSlab;
import com.teammetallurgy.atum.items.ItemAtumSlab;
import com.teammetallurgy.atum.utils.AtumRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;
import java.util.Map;

public class BlockCeramicSlab extends BlockAtumSlab {
    private static final Map<EnumDyeColor, Block> CERAMIC_SLAB = Maps.newEnumMap(EnumDyeColor.class);

    public BlockCeramicSlab() {
        super(Material.ROCK);
        this.setHardness(2.0F);
        this.setSoundType(SoundType.STONE);
        this.useNeighborBrightness = true;
    }

    public static void registerSlabs() {
        for (EnumDyeColor color : EnumDyeColor.values()) {
            BlockAtumSlab ceramicSlab = new BlockCeramicSlab();
            CERAMIC_SLAB.put(color, ceramicSlab);
            AtumRegistry.registerBlock(ceramicSlab, new ItemAtumSlab(ceramicSlab, ceramicSlab), "ceramic_slab_" + color.getName());
        }
    }

    public static Block getSlab(EnumDyeColor color) {
        return CERAMIC_SLAB.get(color);
    }

    @Override
    @Nonnull
    public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
        return MapColor.getBlockColor(EnumDyeColor.valueOf(getColorString().toUpperCase()));
    }

    private String getColorString() {
        Preconditions.checkNotNull(this.getRegistryName(), "registryName");
        return this.getRegistryName().getPath().replace("ceramic_", "").replace("_slab", "");
    }
}