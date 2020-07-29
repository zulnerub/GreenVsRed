package main.entity;

// Entity to represent the generation - 2D Array with PositionEntities
public class GenerationEntity {

    private PositionEntity[][] generation;

    public GenerationEntity(PositionEntity[][] generation) {
        this.generation = generation;
    }

    public PositionEntity[][] getGeneration() {
        return generation;
    }
//
    public GenerationEntity setGeneration(PositionEntity[][] generation) {
        this.generation = generation;
        return this;
    }
}
