package com.Jackiecrazi.aoatc.blocks;

import thaumcraft.common.tiles.TileResearchTable;

import com.Jackiecrazi.aoatc.AoATC;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAlmagamator extends Block{

	protected BlockAlmagamator() {
		super(Material.wood);
		setCreativeTab(AoATC.tabAT);
		setBlockName("blockAlmagamator");
		setHarvestLevel("axe", 2);
        isBlockContainer = true;
        setHardness(2);
	}
	public TileEntity createNewTileEntity(World world, int meta) {
        System.out.println("TE created");
        return new TileResearchTable();
    }

    @Override
    public void breakBlock(World world, int posX,int posY, int posZ, Block block, int idkwhatthisis) {
        super.breakBlock(world, posX,posY,posZ,block,idkwhatthisis);
        world.removeTileEntity(posX,posY,posZ);
        System.out.println("Te removed");
    }

    @Override
    public boolean onBlockEventReceived(World worldIn, int posX, int posY, int posZ, int eventID, int eventParam) {
        super.onBlockEventReceived(worldIn, posX, posY,posZ, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(posX,posY,posZ);
        return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
    }
	public boolean onBlockActivated(World worldIn, int posX, int posY, int posZ, EntityPlayer playerIn, int eventArguments, float hitX, float hitY, float hitZ){
		playerIn.openGui(AoATC.inst, 1, worldIn, posX, posY, posZ);
		return true;
	}

}
