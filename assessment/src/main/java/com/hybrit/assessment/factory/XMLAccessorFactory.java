package com.hybrit.assessment.factory;

import com.hybrit.assessment.reader.Reader;
import com.hybrit.assessment.reader.format.XMLFormat;

/**
 *
 * @author Tim
 */
public class XMLAccessorFactory extends AccessorFactory {

        @Override
        public Reader createReader() {
                return new Reader(new XMLFormat());
        }
}
