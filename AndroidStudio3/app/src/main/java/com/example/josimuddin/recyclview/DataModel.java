package com.example.josimuddin.recyclview;

/**
 * Created by JosimUddin on 20/10/2017.
 */

public class DataModel {
    String name, version;
    int id, image;

    public DataModel(String name, String version, int id, int image) {
        this.name = name;
        this.version = version;
        this.id = id;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

}
