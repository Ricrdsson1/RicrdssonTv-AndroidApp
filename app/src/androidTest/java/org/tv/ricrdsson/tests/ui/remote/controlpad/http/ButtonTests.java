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

package org.tv.ricrdsson.tests.ui.remote.controlpad.http;

import android.content.Context;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.tv.ricrdsson.R;
import org.tv.ricrdsson.host.HostInfo;
import org.tv.ricrdsson.host.HostManager;
import org.tv.ricrdsson.jsonrpc.method.Input;
import org.tv.ricrdsson.testhelpers.TestUtils;
import org.tv.ricrdsson.testhelpers.Utils;
import org.tv.ricrdsson.tests.ui.AbstractTestClass;
import org.tv.ricrdsson.ui.sections.remote.RemoteActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


public class ButtonTests extends AbstractTestClass<RemoteActivity> {
    @Rule
    public ActivityTestRule<RemoteActivity> remoteActivityActivityTestRule =
            new ActivityTestRule<>(RemoteActivity.class);

    @Override
    protected ActivityTestRule<RemoteActivity> getActivityTestRule() {
        return remoteActivityActivityTestRule;
    }

    @Override
    protected void setSharedPreferences(Context context) {
        Utils.setUseEventServerPreference(context, false);
    }

    @Override
    public void setUp() throws Throwable {
        setKodiMajorVersion(HostInfo.KODI_V17_KRYPTON);
        super.setUp();
    }

    @Test
    public void leftControlPadButtonTest() {
        onView(withId(R.id.left)).perform(click());

        TestUtils.testHTTPEvent(Input.Left.METHOD_NAME, null);
    }

    @Test
    public void rightControlPadButtonTest() {
        onView(withId(R.id.right)).perform(click());

        TestUtils.testHTTPEvent(Input.Right.METHOD_NAME, null);
    }

    @Test
    public void upControlPadButtonTest() {
        onView(withId(R.id.up)).perform(click());

        TestUtils.testHTTPEvent(Input.Up.METHOD_NAME, null);
    }

    @Test
    public void downControlPadButtonTest() {
        onView(withId(R.id.down)).perform(click());

        TestUtils.testHTTPEvent(Input.Down.METHOD_NAME, null);
    }

    @Test
    public void selectPadButtonTest() {
        onView(withId(R.id.select)).perform(click());

        TestUtils.testHTTPEvent(Input.Select.METHOD_NAME, null);
    }

    @Test
    public void contextControlPadButtonTest() {
        onView(withId(R.id.context)).perform(click());

        TestUtils.testHTTPEvent(Input.ExecuteAction.METHOD_NAME, Input.ExecuteAction.CONTEXTMENU);
    }

    @Test
    public void infoControlPadButtonTest() {
        HostManager.getInstance(getActivity()).getHostInfo().setKodiVersionMajor(17);

        onView(withId(R.id.info)).perform(click());

        TestUtils.testHTTPEvent(Input.ExecuteAction.METHOD_NAME, Input.ExecuteAction.INFO);
    }

    @Test
    public void infoControlPadButtonLongClickTest() {
        onView(withId(R.id.info)).perform(longClick());

        TestUtils.testHTTPEvent(Input.ExecuteAction.METHOD_NAME, Input.ExecuteAction.PLAYERPROCESSINFO);
    }

    @Test
    public void osdControlPadButtonTest() {
        onView(withId(R.id.osd)).perform(click());

        TestUtils.testHTTPEvent(Input.ExecuteAction.METHOD_NAME, Input.ExecuteAction.OSD);
    }

    @Test
    public void backControlPadButtonTest() {
        onView(withId(R.id.back)).perform(click());

        TestUtils.testHTTPEvent(Input.Back.METHOD_NAME, null);
    }
}
