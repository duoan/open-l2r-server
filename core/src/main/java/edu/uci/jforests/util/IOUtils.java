/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.uci.jforests.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Yasser Ganjisaffar <ganjisaffar at gmail dot com>
 */
@Slf4j
public class IOUtils {

    public InputStream getInputStream(String uri) {
        try {
            return new FileInputStream(new File(uri));
        } catch (FileNotFoundException e) {
            log.error("Error while opening: " + uri);
            e.printStackTrace();
        }
        return null;
    }

    public boolean exists(String uri) {
        return new File(uri).exists();
    }
}
