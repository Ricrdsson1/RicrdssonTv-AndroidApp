/*
 * Copyright 2016 Martijn Brekhof. All rights reserved.
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

package org.tv.ricrdsson.testutils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    public static String readFile(Context context, String filename) throws IOException {
        InputStream is = context.getAssets().open(filename);

        int size = is.available();

        byte[] buffer = new byte[size];

        is.read(buffer);

        is.close();

        return new String(buffer, "UTF-8");
    }
}
