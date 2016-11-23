/*
 * The MIT License
 *
 * Copyright 2016 Geoff Hayward (www.geoffhayward.eu).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.geoffhayward.pulse.business.building.controller;

import eu.geoffhayward.pulse.business.building.boundary.BuildingManger;
import eu.geoffhayward.pulse.business.building.entities.Building;
import java.util.Random;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * A mock data feed.
 * 
 * @author Geoff Hayward
 */
@Stateless
public class BuildingMockDataFeed {

    @Inject
    private Event<Building> buildingEvent;
    @Inject
    private BuildingManger bm;
    private final Random random = new Random();

    @Schedule(hour = "*", minute = "*", second = "*")
    public void randomRunner() {
        this.randomData();
        this.randomData();
        this.randomData();
    }
    
    public void randomData() {
        Building randomBuilding = this.getRandomList();
        randomBuilding.setGas(random.nextInt(30));
        randomBuilding.setElectric(random.nextInt(30));
        randomBuilding.setWater(random.nextInt(30));
        buildingEvent.fire(randomBuilding);
    }

    private Building getRandomList() {
        int index = random.nextInt(bm.listBuildings().size());
        return bm.listBuildings().get(index);
    }

}
