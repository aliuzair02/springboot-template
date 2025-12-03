package org.template.models;

import org.template.common.models.RequestObject;

public class TestRequestObject extends RequestObject {

    String x;
    String y;
    int z;

    public TestRequestObject(){

    }

    public TestRequestObject(String x, String y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
