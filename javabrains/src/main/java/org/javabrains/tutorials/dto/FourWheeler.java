package org.javabrains.tutorials.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: halyph
 * Date: 2/27/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("Car")
public class FourWheeler extends BasicVehicle {

    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
