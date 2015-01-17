
package com.ardorcraft.generators;

import java.util.List;
import java.util.Random;

import com.ardor3d.math.MathUtils;
import com.ardorcraft.data.Pos;
import com.ardorcraft.util.ImprovedNoise;
import com.ardorcraft.world.BlockWorld;
import com.ardorcraft.world.WorldModifier;
import com.google.common.collect.Lists;

public class NiceDataGenerator implements DataGenerator {

	@Override
	public void generateChunk(final int xStart, final int zStart, final int xEnd, final int zEnd, final int spacing,
			final int height, final WorldModifier blockScene) {

		final List<Pos> treePositions = Lists.newArrayList();
		final List<Integer> treeHeights = Lists.newArrayList();
		final Random rand = new Random(xStart * 10000 + zStart);

			for (int x = xStart; x < xEnd; x += spacing) {
				for (int z = zStart; z < zEnd; z += spacing) {

					//if ((z==30) || (x==30) || (x== 0)|| (z== 0))
						if((z <= 10) && (x <= 10)&& (x > 0) && (z > 0))
							//generatePorte(x, z, 10, blockScene, xStart, zStart, xEnd, zEnd, treePositions, treeHeights, rand);
					//	else
							generateMur(x, z, 10, blockScene, xStart, zStart, xEnd, zEnd, treePositions, treeHeights, rand);
					else
						generateSol(x, z, 3, blockScene, xStart, zStart, xEnd, zEnd, treePositions, treeHeights, rand);
				}
			}
	}


	private void generateSol(final int x, final int z, final int height, final WorldModifier blockScene,
			final int xStart, final int zStart, final int xEnd, final int zEnd, final List<Pos> treePositions,
			final List<Integer> treeHeights, final Random rand) {


		int localHeight = 0;


		for (int y = localHeight; y < height; y++) {
			blockScene.setBlock(x, y, z, 2);
		}
	}

	private void generateMur(final int x, final int z, final int height, final WorldModifier blockScene,
			final int xStart, final int zStart, final int xEnd, final int zEnd, final List<Pos> treePositions,
			final List<Integer> treeHeights, final Random rand) {


		int localHeight = 0;


		for (int y = localHeight; y < height; y++) {
			blockScene.setBlock(x, y, z, 1);
		}
	}

	private void generatePorte(final int x, final int z, final int height, final WorldModifier blockScene,
			final int xStart, final int zStart, final int xEnd, final int zEnd, final List<Pos> treePositions,
			final List<Integer> treeHeights, final Random rand) {

		int localHeight = 0;

		for (int y = localHeight; y < 3; y++) {
			blockScene.setBlock(x, y, z, 2);
		}

		for (int y = 5; y < height; y++) {
			blockScene.setBlock(x, y, z, 1);
		}
	}
}


