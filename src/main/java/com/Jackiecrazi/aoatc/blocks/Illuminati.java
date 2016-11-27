package com.Jackiecrazi.aoatc.blocks;

import java.util.Random;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class Illuminati extends Block{
	public boolean blockade;
	protected Illuminati(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
		this.blockade=false;
	}

	public boolean renderAsNormalBlock()
    {
        return false;
    }
	public boolean isOpaqueCube()
    {
        return false;
    }
	public Block setquarantine(boolean j){
		this.blockade=j;
		return this;
	}
}
