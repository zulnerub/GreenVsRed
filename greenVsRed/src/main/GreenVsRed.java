package main;


import main.entity.GenerationEntity;
import main.entity.PositionEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreenVsRed {
    private static int x;
    private static int y;
    private static GenerationEntity generation;

    public static void main(String[] args) throws IOException {
//        App initialisation - Reading Input and Creating Zero generation

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String[] input = rd.readLine().split(",");

        x = Integer.parseInt(input[0].trim());
        y = Integer.parseInt(input[1].trim());

        generation = new GenerationEntity(new PositionEntity[x][y]);

        for (int row = 0; row < x; row++) {
            String rowInput = rd.readLine().trim();
            for (int col = 0; col < rowInput.length(); col++) {
                generation.getGeneration()[row][col] =
                        new PositionEntity(Integer.parseInt(rowInput.charAt(col) + ""));
            }
        }

        input = rd.readLine().split(",");

        int[] resultEntity = new int[2];
        resultEntity[0] = Integer.parseInt(input[0].trim());
        resultEntity[1] = Integer.parseInt(input[1].trim());

        int lastGeneration = Integer.parseInt(input[2].trim());

//        /App initialisation - Reading Input and Creating Zero generation

//        Iteration through the generations and printing the result

        int result = 0;

        for (int i = 0; i <= lastGeneration; i++) {
            if (generation.getGeneration()[resultEntity[0]][resultEntity[1]].getColor() == 1) {
                result++;
            }
            nextGeneration(generation);
        }

        System.out.println(result);

//        /Iteration through the generations

    }

//    Creating the new generation and populating it with PositionEntities
    private static void nextGeneration(GenerationEntity prevGeneration) {
        GenerationEntity nextGeneration = initNewGeneration();

        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {

                int greenNeighbours = countNeighboursByColor(row, col);
                PositionEntity newPositionEntity = nextGeneration.getGeneration()[row][col];

                if (prevGeneration.getGeneration()[row][col].getColor() == 0) {
                    if (greenNeighbours == 3 || greenNeighbours == 6){
                        newPositionEntity.setColor(1);
                        nextGeneration.getGeneration()[row][col] = newPositionEntity;
                    }
                } else {
                    if (greenNeighbours != 2 && greenNeighbours != 3 && greenNeighbours != 6) {
                        newPositionEntity.setColor(0);
                    }else {
                        newPositionEntity.setColor(1);
                    }
                    nextGeneration.getGeneration()[row][col] = newPositionEntity;
                }
            }
        }

        generation = nextGeneration;

    }
//        /Creating the new generation and populating it with PositionEntities


//        /Initialising the next generation
    private static GenerationEntity initNewGeneration() {
        GenerationEntity newGeneration = new GenerationEntity(new PositionEntity[x][y]);
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
                newGeneration.getGeneration()[row][col] = new PositionEntity(0);
            }
        }
        return newGeneration;
    }

//     /Initialising the next generation

//    Counting the adjacent green PositionEntities
    private static int countNeighboursByColor(int row, int col) {
        int result = 0;


        if (inRange(row - 1, col) &&
                generation.getGeneration()[row - 1][col].getColor() == 1) {
            result++;
        }

        if (inRange(row - 1, col + 1) &&
                generation.getGeneration()[row - 1][col + 1].getColor() == 1) {
            result++;
        }

        if (inRange(row, col + 1) &&
                generation.getGeneration()[row][col + 1].getColor() == 1) {
            result++;
        }

        if (inRange(row + 1, col + 1) &&
                generation.getGeneration()[row + 1][col + 1].getColor() == 1) {
            result++;
        }

        if (inRange(row + 1, col) &&
                generation.getGeneration()[row + 1][col].getColor() == 1) {
            result++;
        }

        if (inRange(row + 1, col - 1) &&
                generation.getGeneration()[row + 1][col - 1].getColor() == 1) {
            result++;
        }

        if (inRange(row, col - 1) &&
                generation.getGeneration()[row][col - 1].getColor() == 1) {
            result++;
        }

        if (inRange(row - 1, col - 1) &&
                generation.getGeneration()[row - 1][col - 1].getColor() == 1) {
            result++;
        }


        return result;
    }
//    /Counting the adjacent green PositionEntities

//    Checking if the cell is in the boundaries of the matrix

    private static boolean inRange(int row, int col) {
        return row >= 0 && row < x && col >= 0 && col < y;
    }
//    /Checking if the cell is in the boundaries of the matrix

}
