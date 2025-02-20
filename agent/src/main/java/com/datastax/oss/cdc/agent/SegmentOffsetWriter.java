/**
 * Copyright DataStax, Inc 2021.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datastax.oss.cdc.agent;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

/**
 * Periodically persist the last sent offset to recover from that checkpoint.
 */
public interface SegmentOffsetWriter {

    /**
     * Get the current offset.
     * @return
     */
    int position(Optional<UUID> nodeId, long segmentId);

    /**
     * Set the current offset for a segment
     * @return
     */
    void position(Optional<UUID> nodeId, long segmentId, int position);

    /**
     * Persist the offset for a segment
     * @throws IOException
     */
    void flush(Optional<UUID> nodeId, long segmentId) throws IOException;

    /**
     * Remove the offset for a segment
     * @param nodeId
     * @param segmentId
     */
    void remove(Optional<UUID> nodeId, long segmentId);

    /**
     * Remove all offset for the provided nodeId.
     * @param nodeId
     */
    void remove(Optional<UUID> nodeId);
}
