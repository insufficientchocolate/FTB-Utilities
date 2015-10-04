package latmod.ftbu.mod.config;

import latmod.ftbu.api.config.*;
import latmod.ftbu.api.readme.ReadmeInfo;

public class FTBUConfigBackups
{
	public static final ConfigGroup group = new ConfigGroup("backups");
	
	@ReadmeInfo(info = "true enables backups", def = "false")
	public static final ConfigEntryBool enabled = new ConfigEntryBool("enabled", false);
	
	@ReadmeInfo(info = "The number of backup files to keep. 0 - Disabled. More backups = more space used.", def = "12")
	public static final ConfigEntryInt backupsToKeep = new ConfigEntryInt("backupsToKeep", new IntBounds(12, 0, 100));
	
	@ReadmeInfo(info = "Timer in hours. 1.0 - backups every hour, 6.0 - backups every 6 hours, 0.5 - backups every 30 minutes.", def = "2.0")
	private static final ConfigEntryFloat backupTimer = new ConfigEntryFloat("backupTimer", new FloatBounds(2F, 0.2F, 600F));
	
	//@ReadmeInfo(info = "Launches backup when server stops.", def = "false")
	//public Boolean backupOnShutdown;
	
	@ReadmeInfo(info = "0 - Disabled (output = folders), Min - 1 (Best speed), Max - 9 (Smallest file),", def = "1")
	public static final ConfigEntryInt compressionLevel = new ConfigEntryInt("compressionLevel", new IntBounds(1, 0, 9));
	
	@ReadmeInfo(info = "Absoute path to backups folder, blank means /latmod/backups/.", def = "Blank")
	public static final ConfigEntryString folder = new ConfigEntryString("folder", "");
	
	@ReadmeInfo(info = "Prints (current size | total size) when backup is done", def = "true")
	public static final ConfigEntryBool displayFileSize = new ConfigEntryBool("displayFileSize", true);
	
	@ReadmeInfo(info = "Same as running '/admin player @p saveinv' on logout", def = "false")
	public static final ConfigEntryBool autoExportInvOnLogout = new ConfigEntryBool("autoExportInvOnLogout", false);
	
	public static void load(ConfigFile f)
	{
		group.add(enabled);
		group.add(backupsToKeep);
		group.add(backupTimer);
		group.add(compressionLevel);
		group.add(folder);
		group.add(displayFileSize);
		group.add(autoExportInvOnLogout);
		f.add(group);
	}
	
	public static long backupTimerL()
	{ return (long)(backupTimer.get() * 3600D * 1000D); }
}