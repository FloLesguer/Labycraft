
package com.ardorcraft.generators;

import java.util.List;
import java.util.Random;

import com.ardor3d.math.MathUtils;
import com.ardorcraft.data.Pos;
import com.ardorcraft.util.ImprovedNoise;
import com.ardorcraft.world.BlockWorld;
import com.ardorcraft.world.WorldModifier;
import com.google.common.collect.Lists;

/**
 * Some nice terrain with trees.
 */
public class GenerateurLabyrinthe implements DataGenerator {
    private final int waterHeight = 0;

    @Override
    public void generateChunk(final int xStart, final int zStart, final int xEnd, final int zEnd, final int spacing,
            final int height, final WorldModifier blockScene) {

        final List<Pos> treePositions = Lists.newArrayList();
        final List<Integer> treeHeights = Lists.newArrayList();
        final Random rand = new Random(xStart * 10000 + zStart);

        for (int x = xStart; x < xEnd; x += spacing) {
            for (int z = zStart; z < zEnd; z += spacing) {
                generateColumn(x, z, height, blockScene, xStart, zStart, xEnd, zEnd, treePositions, treeHeights, rand);
            }
        }
   
    }


    private void generateColumn(final int x, final int z, final int height, final WorldModifier blockScene,
            final int xStart, final int zStart, final int xEnd, final int zEnd, final List<Pos> treePositions,
            final List<Integer> treeHeights, final Random rand) {

    	//Premier niveau terre
        for (int y = 0; y < 2; y++) {
            blockScene.setBlock(x, y, z, 3);
        }
        
        //Deuxième niveau herbe
        for (int y = 2; y < 3; y++) {
            blockScene.setBlock(x, y, z, 2);
        }
    }
}
