package com.feed_the_beast.ftbutilities.data;

import com.feed_the_beast.ftblib.lib.math.BlockDimPos;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TeleportLogTests
{
	@Test
	void TestCompareTo() {
		final TeleportLog earlier = new TeleportLog(TeleportType.HOME, new BlockDimPos(0,0,0,0), 100);
		final TeleportLog later = new TeleportLog(TeleportType.HOME, new BlockDimPos(0,0,0,0),200);
		TeleportLog[] list = new TeleportLog[]{later, earlier};
		Arrays.sort(list);
		assertArrayEquals(new TeleportLog[]{earlier, later}, list);
	}
}
