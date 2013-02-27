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
public class TwoWheeler extends BasicVehicle {

    private String steeringHandle;

    public String getSteeringHandle() {
        return steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }
}
