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
package eu.geoffhayward.pulse.business.building.boundary;

import eu.geoffhayward.pulse.business.building.entities.Building;
import java.util.Arrays;
import java.util.List;

/**
 * A mock Building's database entity manager
 * 
 * @author Geoff Hayward
 */
public class BuildingManger {

    private final List<Building> buildings = Arrays.asList(new Building[]{
        new Building(1000001, "Alexander Building", 4, 8, 16),
        new Building(1000002, "Amory Building", 4, 8, 16),
        new Building(1000003, "Building:One", 4, 8, 16),
        new Building(1000004, "Byrne House", 4, 8, 16),
        new Building(1000005, "Clayden", 4, 8, 16),
        new Building(1000006, "Clydesdale House", 4, 8, 16),
        new Building(1000007, "Combined Universities in Cornwall", 4, 8, 16),
        new Building(1000008, "Cornwall House", 4, 8, 16),
        new Building(1000009, "Devonshire House", 4, 8, 16),
    });
    
    public List<Building> listBuildings(){
        return this.buildings;
    }

}
