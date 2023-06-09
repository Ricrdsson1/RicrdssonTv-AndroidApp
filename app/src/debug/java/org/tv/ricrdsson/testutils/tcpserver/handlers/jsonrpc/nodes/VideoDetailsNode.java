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

package org.tv.ricrdsson.testutils.tcpserver.handlers.jsonrpc.nodes;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.tv.ricrdsson.testutils.tcpserver.handlers.jsonrpc.JsonResponse;

public class VideoDetailsNode extends JsonResponse {

    private VideoDetailsNode() {};

    public VideoDetailsNode(int width, int height, float aspect, String code, int duration) {
        ObjectNode node = (ObjectNode) getResultNode(TYPE.OBJECT);
        node.put("width", width);
        node.put("height", height);
        node.put("aspect", aspect);
        node.put("code", code);
        node.put("duration", duration);
    }
}
