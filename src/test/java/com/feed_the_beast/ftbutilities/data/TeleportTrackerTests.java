package com.feed_the_beast.ftbutilities.data;

import com.feed_the_beast.ftblib.lib.math.BlockDimPos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeleportTrackerTests
{
	private TeleportTracker tracker;
	@BeforeEach
	void beforeEach() {
		tracker = new TeleportTracker();
	}
	@Test
	void TestGetLastLogs() {
		tracker.logTeleport(TeleportType.HOME, new BlockDimPos(0,0,0,0),200);
		tracker.logTeleport(TeleportType.RESPAWN, new BlockDimPos(1,1,1,0), 100);
		assertEquals(TeleportType.HOME, tracker.getLastLog().teleportType);
	}
}
