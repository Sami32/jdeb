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

import java.io.IOException;

import org.apache.commons.compress.archivers.ArchiveEntry;

/**
 * Callback used for inspecting an archive.
 */
public interface ArchiveVisitor<E extends ArchiveEntry> {

    void visit(E entry, byte[] content) throws IOException;
}
