package com.polytech.tp;

public class CoursEnAnglais extends CoursDecorator {
    public CoursEnAnglais(ICours cours){
        super(cours);
    }

    public String getDescription() {
        return coursDecorated.getDescription() + " (En anglais)";
    }

    @Override
    public double getDuree() {
        return coursDecorated.getDuree();
    }
}