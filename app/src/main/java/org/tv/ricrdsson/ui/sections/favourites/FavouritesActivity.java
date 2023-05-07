/*
 * Copyright 2017 XBMC Foundation. All rights reserved.
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
package org.tv.ricrdsson.ui.sections.favourites;

import androidx.fragment.app.Fragment;

import org.tv.ricrdsson.R;
import org.tv.ricrdsson.ui.BaseMediaActivity;

public class FavouritesActivity extends BaseMediaActivity {

    @Override
    protected String getActionBarTitle() {
        return getString(R.string.favourites);
    }

    @Override
    protected Fragment createFragment() {
        return new FavouritesListFragment();
    }
}
