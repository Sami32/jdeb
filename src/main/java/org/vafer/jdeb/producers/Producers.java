/*
 * Copyright 2007-2023 The jdeb developers.
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
package org.vafer.jdeb.producers;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

import org.apache.commons.io.IOUtils;
import org.vafer.jdeb.DataConsumer;

import java.io.IOException;
import java.io.InputStream;

/**
 * Package-private utility class with common producers functionality.
 */
class Producers {

    final static int ROOT_UID = 0;
    final static String ROOT_NAME = "root";

    private Producers() {}


    /**
     * Creates a tar file entry with defaults parameters.
     * @param fileName the entry name
     * @return file entry with reasonable defaults
     */
    static TarArchiveEntry defaultFileEntryWithName( final String fileName ) {
        TarArchiveEntry entry = new TarArchiveEntry(fileName, true);
        entry.setUserId(ROOT_UID);
        entry.setUserName(ROOT_NAME);
        entry.setGroupId(ROOT_UID);
        entry.setGroupName(ROOT_NAME);
        entry.setMode(TarArchiveEntry.DEFAULT_FILE_MODE);
        return entry;
    }

    /**
     * Creates a tar directory entry with defaults parameters.
     * @param dirName the directory name
     * @return dir entry with reasonable defaults
     */
    static TarArchiveEntry defaultDirEntryWithName( final String dirName ) {
        TarArchiveEntry entry = new TarArchiveEntry(dirName, true);
        entry.setUserId(ROOT_UID);
        entry.setUserName(ROOT_NAME);
        entry.setGroupId(ROOT_UID);
        entry.setGroupName(ROOT_NAME);
        entry.setMode(TarArchiveEntry.DEFAULT_DIR_MODE);
        return entry;
    }

    /**
     * Forwards tar archive entry entry to a consumer.
     * @param consumer the consumer
     * @param dirEntry the entry to pass
     * @throws IOException
     */
    static void produceDirEntry( final DataConsumer consumer,
                                 final TarArchiveEntry dirEntry ) throws IOException {
        consumer.onEachDir(dirEntry);
    }


    /**
     * Feeds input stream to data consumer using metadata from tar entry.
     * @param consumer the consumer
     * @param inputStream the stream to feed
     * @param entry the entry to use for metadata
     * @throws IOException on consume error
     */
    static void produceInputStreamWithEntry( final DataConsumer consumer,
                                             final InputStream inputStream,
                                             final TarArchiveEntry entry ) throws IOException {
        try {
            consumer.onEachFile(inputStream, entry);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

}
