package com.minol.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectMap {
    private String name;
    private List<MapNode> value=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MapNode> getValue() {
        return value;
    }

    public void setValue(List<MapNode> value) {
        this.value = value;
    }
}

