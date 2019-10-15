/*
 * Copyright (c) 2019, Salesforce.com, Inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package com.salesforce.cantor.mysql;

import com.salesforce.cantor.*;

import javax.sql.DataSource;
import java.io.IOException;

public class CantorOnMysql implements Cantor {
    private final Objects objects;
    private final Sets sets;
    private final Events events;

    public CantorOnMysql(final String hostname, final int port, final String username, final String password)
            throws IOException {
        this.objects = new ObjectsOnMysql(hostname, port, username, password);
        this.sets = new SetsOnMysql(hostname, port, username, password);
        this.events = new EventsOnMysql(hostname, port, username, password);
    }

    public CantorOnMysql(final DataSource dataSource) throws IOException {
        this.objects = new ObjectsOnMysql(dataSource);
        this.sets = new SetsOnMysql(dataSource);
        this.events = new EventsOnMysql(dataSource);
    }

    @Override
    public Objects objects() {
        return this.objects;
    }

    @Override
    public Sets sets() {
        return this.sets;
    }

    @Override
    public Events events() {
        return this.events;
    }
}
