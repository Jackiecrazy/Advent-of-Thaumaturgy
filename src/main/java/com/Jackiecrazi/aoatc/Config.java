package com.Jackiecrazi.aoatc;

import java.io.File;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.common.config.Configuration;

public class Config {
	public static int mendingID,shieldingID,medicID,corporealID,imbueID,noxiousID,toxicID,evolvedID,fusedID,gustID,galeID,tornadoID,hurricaneID,pathogenID,guID,fungusID,sporeID,blackmagicID,gongtauID,curseID,voodooID,lightID,quarantineID,blazeID,hellfireID,bubbleID,imprisonID,drownID,krakenID;
	public static int sporePotID,blazePotID,drownPotID,imprisonPotID,fearPotID;
	public static void CreatioExNihilo(File dumdum){
		Configuration c=new Configuration(dumdum);
		try{
			c.load();
			
			int uc =22;
			mendingID=c.get("focus upgrade ids", "mending", uc ).getInt (uc++);
			LogManager.getLogger("AoATC").info("assigned an id, I think.");
			shieldingID=c.get("focus upgrade ids", "shielding", uc ).getInt (uc++);
			medicID=c.get("focus upgrade ids", "medic", uc ).getInt (uc++);
			corporealID=c.get("focus upgrade ids", "corporeal", uc ).getInt (uc++);
			imbueID=c.get("focus upgrade ids", "imbue", uc ).getInt (uc++);
			noxiousID=c.get("focus upgrade ids", "noxious", uc ).getInt (uc++);
			toxicID=c.get("focus upgrade ids", "toxic", uc ).getInt (uc++);
			evolvedID=c.get("focus upgrade ids", "evolved", uc ).getInt (uc++);
			fusedID=c.get("focus upgrade ids", "fused", uc ).getInt (uc++);
			gustID=c.get("focus upgrade ids", "gust", uc ).getInt (uc++);
			galeID=c.get("focus upgrade ids", "gale", uc ).getInt (uc++);
			tornadoID=c.get("focus upgrade ids", "tornado", uc ).getInt (uc++);
			hurricaneID=c.get("focus upgrade ids", "hurricane", uc ).getInt (uc++);
			pathogenID=c.get("focus upgrade ids", "pathogen", uc ).getInt (uc++);
			guID=c.get("focus upgrade ids", "gu", uc ).getInt (uc++);
			fungusID=c.get("focus upgrade ids", "fungus", uc ).getInt (uc++);
			sporeID=c.get("focus upgrade ids", "spore", uc ).getInt (uc++);
			blackmagicID=c.get("focus upgrade ids", "blackmagic", uc ).getInt (uc++);
			gongtauID=c.get("focus upgrade ids", "gongtau", uc ).getInt (uc++);
			curseID=c.get("focus upgrade ids", "curse", uc ).getInt (uc++);
			voodooID=c.get("focus upgrade ids", "voodoo", uc ).getInt (uc++);
			lightID=c.get("focus upgrade ids", "light", uc ).getInt (uc++);
			quarantineID=c.get("focus upgrade ids", "quarantine", uc ).getInt (uc++);
			blazeID=c.get("focus upgrade ids", "blaze", uc ).getInt (uc++);
			hellfireID=c.get("focus upgrade ids", "hellfire", uc ).getInt (uc++);
			bubbleID=c.get("focus upgrade ids", "bubble", uc ).getInt (uc++);
			imprisonID=c.get("focus upgrade ids", "imprison", uc ).getInt (uc++);
			drownID=c.get("focus upgrade ids", "drown", uc ).getInt (uc++);
			krakenID=c.get("focus upgrade ids", "kraken", uc ).getInt (uc++);
			int potion =22;
			sporePotID=c.get("Potion IDs", "Spore", potion).getInt(potion++);
			blazePotID=c.get("Potion IDs", "Blaze", potion).getInt(potion++);
			drownPotID=c.get("Potion IDs", "Drown", potion).getInt(potion++);
			imprisonPotID=c.get("Potion IDs", "Imprison", potion).getInt(potion++);
			fearPotID=c.get("Potion IDs", "Fear", potion).getInt(potion++);
		}
		catch(Exception er){
			LogManager.getLogger("AoATC").fatal("Failed to initialize the config. Here's an error.");
			er.printStackTrace();
		}
		finally{
			c.save();
		}
	}
}
