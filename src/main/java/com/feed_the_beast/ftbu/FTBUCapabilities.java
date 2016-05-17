package com.feed_the_beast.ftbu;

import com.feed_the_beast.ftbu.world.FTBUPlayerData;
import com.feed_the_beast.ftbu.world.FTBUPlayerDataMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

/**
 * Created by LatvianModder on 15.05.2016.
 */
public class FTBUCapabilities
{
	private static boolean enabled = false;
	
	@CapabilityInject(FTBUPlayerData.class)
	public static Capability<FTBUPlayerData> FTBU_PLAYER_DATA = null;
	
	public static void enable()
	{
		if(enabled)
		{
			return;
		}
		
		enabled = true;
		
		CapabilityManager.INSTANCE.register(FTBUPlayerData.class, new Capability.IStorage<FTBUPlayerData>()
		{
			@Override
			public NBTBase writeNBT(Capability<FTBUPlayerData> capability, FTBUPlayerData instance, EnumFacing side)
			{
				return ((FTBUPlayerDataMP) instance).serializeNBT();
			}
			
			@Override
			public void readNBT(Capability<FTBUPlayerData> capability, FTBUPlayerData instance, EnumFacing side, NBTBase base)
			{
				((FTBUPlayerDataMP) instance).deserializeNBT((NBTTagCompound) base);
			}
		}, () -> null);
	}
}