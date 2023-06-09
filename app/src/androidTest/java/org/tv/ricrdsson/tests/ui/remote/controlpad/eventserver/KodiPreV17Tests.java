/*
 * Copyright 2017 Martijn Brekhof. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tv.ricrdsson.tests.ui.remote.controlpad.eventserver;

import android.content.Context;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.tv.ricrdsson.R;
import org.tv.ricrdsson.host.HostInfo;
import org.tv.ricrdsson.jsonrpc.method.Input;
import org.tv.ricrdsson.testhelpers.Utils;
import org.tv.ricrdsson.tests.ui.AbstractTestClass;
import org.tv.ricrdsson.testutils.eventserver.MockEventServer;
import org.tv.ricrdsson.ui.sections.remote.RemoteActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertTrue;

public class KodiPreV17Tests extends AbstractTestClass<RemoteActivity> {
    private static MockEventServer mockEventServer;

    @Rule
    public ActivityTestRule<RemoteActivity> remoteActivityActivityTestRule =
            new ActivityTestRule<>(RemoteActivity.class);

    @Override
    protected ActivityTestRule<RemoteActivity> getActivityTestRule() {
        return remoteActivityActivityTestRule;
    }

    @Override
    protected void setSharedPreferences(Context context) {
        Utils.setUseEventServerPreference(context, true);
    }

    @BeforeClass
    public static void setupEventServer() {
        mockEventServer = new MockEventServer();
        mockEventServer.setListenPort(HostInfo.DEFAULT_EVENT_SERVER_PORT);
        mockEventServer.start();
    }

    @Override
    public void setUp() throws Throwable {
        setKodiMajorVersion(HostInfo.KODI_V16_JARVIS);
        super.setUp();
    }

    @After
    public void resetState() {
        mockEventServer.reset();
    }

    @AfterClass
    public static void cleanup() {
        mockEventServer.shutdown();
    }

    @Test
    public void infoControlPadButtonLongClickTest() {
        onView(withId(R.id.info)).perform(longClick());

        String actionReceived = getInputHandler().getAction();
        assertTrue(actionReceived != null);
        assertTrue(actionReceived.contentEquals(Input.ExecuteAction.CODECINFO));
    }
}
