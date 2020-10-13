/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.documentation.html;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Assert;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * A helper class to validate xml documents.
 *
 *
 */
public class XmlValidator {

    /**
     * Asserts a failure if the provided XML is not valid. <strong>This method does
     * not use the "safe" {@link DocumentBuilderFactory} from
     * {@code XmlUtils#createSafeDocumentBuilder(Schema, boolean)} because it checks
     * generated documentation which contains a doctype. </strong>
     *
     * @param xml the XML to validate
     */
    public static void assertXmlValid(String xml) {
        try {
            final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            dbf.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
        } catch (SAXException | IOException | ParserConfigurationException e) {
            Assert.fail(e.getMessage());
        }
    }

    public static void assertContains(String original, String subword) {
        Assert.assertTrue(original + " did not contain: " + subword, original.contains(subword));
    }

    public static void assertNotContains(String original, String subword) {
        Assert.assertFalse(original + " did contain: " + subword, original.contains(subword));
    }
}
