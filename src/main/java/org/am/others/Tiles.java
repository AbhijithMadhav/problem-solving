package org.am.others;

import java.util.LinkedList;
import java.util.List;

/**
 * Tiles
 * Tile has a color(RGB) and a number(0-9)
 * A set of cards has 30 tiles(r1-9, etc) and there are 4 such sets
 * A pattern is 3 same tiles(R1, R1, R1) or three tiles with the same color and sequential numbers(R1, R2, R3)
 * A winning hand is a set of twelve tiles with 4 valid patterns
 */
public class Tiles {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public boolean winningHand(Tile[] tiles) {

        if (tiles.length == 3)
            return isValidPattern(tiles[0], tiles[1], tiles[2]);
        for (int i = 0; i < tiles.length; i++) {
            for (int j = i + 1; j < tiles.length; j++) {
                for (int k = j + 1; k < tiles.length; k++) {
                    if (isValidPattern(tiles[i], tiles[j], tiles[k]) && winningHand(subset(tiles, i, j, k)))
                        return true;
                }
            }
        }
        return false;
    }


    private boolean isValidPattern(Tile a, Tile b, Tile c) {
        if (a.equals(b) && b.equals(c))
            return true;
        return false;
        //else return a.color.equals(b.color) && b.color.equals(c.color) && b.number == a.number + 1 && c.number = b.number + 1;
    }

    private Tile[] subset(Tile[] tiles, int excludeIndexA, int excludeIndexB, int excludeIndexC) {
        List<Tile> subset = new LinkedList<>();
        for (int i = 0; i < tiles.length; i++) {
            if (i != excludeIndexA && i != excludeIndexB && i != excludeIndexC)
                subset.add(tiles[i]);
        }
        return (Tile[]) subset.toArray();
    }

    class Tile {

        private int number;
        private RGB color;

    }

    enum RGB {
        R, G, B
    }

}

