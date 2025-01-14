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
package org.vafer.jdeb;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

import java.io.IOException;
import java.io.InputStream;

/**
 * A DataConsumer consumes Data produced from a producer.
 */
public interface DataConsumer {

    void onEachDir( TarArchiveEntry dirEntry ) throws IOException;

    void onEachFile( InputStream input, TarArchiveEntry fileEntry ) throws IOException;

    void onEachLink( TarArchiveEntry linkEntry ) throws IOException;

}
