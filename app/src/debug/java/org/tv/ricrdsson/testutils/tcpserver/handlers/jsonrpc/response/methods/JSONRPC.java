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

package org.tv.ricrdsson.testutils.tcpserver.handlers.jsonrpc.response.methods;

import org.tv.ricrdsson.testutils.tcpserver.handlers.jsonrpc.JsonResponse;

/**
 * Serverside JSON RPC responses in Application.*
 */
public class JSONRPC {

    public static class Ping extends JsonResponse {
        public final static String METHOD_NAME = "JSONRPC.Ping";

        public Ping(int id) {
            super(id);
            setResultToResponse("pong");
        }
    }
}
