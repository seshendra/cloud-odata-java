/*******************************************************************************
 * Copyright 2013 SAP AG
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.sap.core.odata.api.commons;

/**
 * Constants for <code>Http Content Type</code> definitions as specified in 
 * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html">RFC 2616 Section 14</a>.
 * @author SAP AG
 */
public interface HttpContentType {

  String APPLICATION_XML = "application/xml";
  String APPLICATION_XML_UTF8 = APPLICATION_XML + "; charset=utf-8";

  String APPLICATION_ATOM_XML = "application/atom+xml";
  String APPLICATION_ATOM_XML_UTF8 = APPLICATION_ATOM_XML + "; charset=utf-8";
  String APPLICATION_ATOM_XML_ENTRY = APPLICATION_ATOM_XML + "; type=entry";
  String APPLICATION_ATOM_XML_ENTRY_UTF8 = APPLICATION_ATOM_XML_ENTRY + "; charset=utf-8";
  String APPLICATION_ATOM_XML_FEED = APPLICATION_ATOM_XML + "; type=feed";
  String APPLICATION_ATOM_XML_FEED_UTF8 = APPLICATION_ATOM_XML_FEED + "; charset=utf-8";
  String APPLICATION_ATOM_SVC = "application/atomsvc+xml";
  String APPLICATION_ATOM_SVC_UTF8 = APPLICATION_ATOM_SVC + "; charset=utf-8";

  String APPLICATION_JSON = "application/json";
  String APPLICATION_JSON_UTF8 = APPLICATION_JSON + "; charset=utf-8";

  String TEXT_PLAIN = "text/plain";
  String TEXT_PLAIN_UTF8 = TEXT_PLAIN + "; charset=utf-8";

  String APPLICATION_OCTET_STREAM = "application/octet-stream";

  String MULTIPART_MIXED = "multipart/mixed";

  String WILDCARD = "*/*";
}
