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

package org.tv.ricrdsson.testutils.tcpserver.handlers.jsonrpc.response.methods;

import org.tv.ricrdsson.testutils.tcpserver.handlers.jsonrpc.JsonResponse;

import java.io.IOException;

/**
 * Serverside JSON RPC responses in Addons.*
 */
public class Addons {

    /**
     * JSON response for Addons.GetAddons request
     *
     * @return JSON string
     */
    public static class GetAddons extends JsonResponse {
        public final static String METHOD_NAME = "Addons.GetAddons";

        public GetAddons(int id, String jsonString) throws IOException {
            super(id, jsonString);
        }
    }
}
