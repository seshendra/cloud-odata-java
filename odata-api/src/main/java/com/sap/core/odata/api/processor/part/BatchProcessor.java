package com.sap.core.odata.api.processor.part;

import java.io.InputStream;

import com.sap.core.odata.api.exception.ODataException;
import com.sap.core.odata.api.processor.ODataProcessor;
import com.sap.core.odata.api.processor.ODataResponse;

/**
 * Execute a OData batch request. 
 * 
 * @author SAP AG
 *
 */
public interface BatchProcessor extends ODataProcessor {

  /**
   * @param contentType 
   * @param content 
   * @return a {@link ODataResponse} object
   * @throws ODataException
   */
  ODataResponse executeBatch(String contentType, InputStream content) throws ODataException;
}
