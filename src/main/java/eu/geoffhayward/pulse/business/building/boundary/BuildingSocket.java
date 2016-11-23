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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.json.Json;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * The Building's WebSocket service.
 * 
 * @author Geoff Hayward
 */
@Singleton
@ServerEndpoint("/building-socket")
public class BuildingSocket {

    private final List<Session> sessions = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        this.sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        this.sessions.remove(session);
    }

    @Asynchronous
    public void notifyAll(@Observes Building building) {
        this.sessions
                .stream()
                .forEach(session -> this.notifyOne(session, building));
    }

    private void notifyOne(Session session, Building building) {
        session.getAsyncRemote().sendObject(
            Json.createObjectBuilder()
                .add("id", building.getId())
                .add("gas", building.getGas())
                .add("electric", building.getElectric())
                .add("water", building.getWater())
                .build());
    }

}
