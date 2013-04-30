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
package com.sap.core.odata.core.edm;

import com.sap.core.odata.api.edm.EdmFacets;
import com.sap.core.odata.api.edm.EdmLiteralKind;
import com.sap.core.odata.api.edm.EdmSimpleType;
import com.sap.core.odata.api.edm.EdmSimpleTypeException;

/**
 * Implementation of the EDM simple type Int16.
 * @author SAP AG
 */
public class EdmInt16 extends AbstractSimpleType {

  private static final EdmInt16 instance = new EdmInt16();

  public static EdmInt16 getInstance() {
    return instance;
  }

  @Override
  public boolean isCompatible(final EdmSimpleType simpleType) {
    return simpleType instanceof Bit
        || simpleType instanceof Uint7
        || simpleType instanceof EdmByte
        || simpleType instanceof EdmSByte
        || simpleType instanceof EdmInt16;
  }

  @Override
  public Class<?> getDefaultType() {
    return Short.class;
  }

  @Override
  protected <T> T internalValueOfString(final String value, final EdmLiteralKind literalKind, final EdmFacets facets, final Class<T> returnType) throws EdmSimpleTypeException {
    Short valueShort;
    try {
      valueShort = Short.parseShort(value);
    } catch (final NumberFormatException e) {
      throw new EdmSimpleTypeException(EdmSimpleTypeException.LITERAL_ILLEGAL_CONTENT.addContent(value), e);
    }

    if (returnType.isAssignableFrom(Short.class)) {
      return returnType.cast(valueShort);
    } else if (returnType.isAssignableFrom(Byte.class)) {
      if (valueShort >= Byte.MIN_VALUE && valueShort <= Byte.MAX_VALUE) {
        return returnType.cast(valueShort.byteValue());
      } else {
        throw new EdmSimpleTypeException(EdmSimpleTypeException.LITERAL_UNCONVERTIBLE_TO_VALUE_TYPE.addContent(value, returnType));
      }
    } else if (returnType.isAssignableFrom(Integer.class)) {
      return returnType.cast(valueShort.intValue());
    } else if (returnType.isAssignableFrom(Long.class)) {
      return returnType.cast(valueShort.longValue());
    } else {
      throw new EdmSimpleTypeException(EdmSimpleTypeException.VALUE_TYPE_NOT_SUPPORTED.addContent(returnType));
    }
  }

  @Override
  protected <T> String internalValueToString(final T value, final EdmLiteralKind literalKind, final EdmFacets facets) throws EdmSimpleTypeException {
    if (value instanceof Byte || value instanceof Short) {
      return value.toString();
    } else if (value instanceof Integer || value instanceof Long) {
      if (((Number) value).longValue() >= Short.MIN_VALUE && ((Number) value).longValue() <= Short.MAX_VALUE) {
        return value.toString();
      } else {
        throw new EdmSimpleTypeException(EdmSimpleTypeException.VALUE_ILLEGAL_CONTENT.addContent(value));
      }
    } else {
      throw new EdmSimpleTypeException(EdmSimpleTypeException.VALUE_TYPE_NOT_SUPPORTED.addContent(value.getClass()));
    }
  }
}
