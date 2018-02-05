package com.hybrit.assessment.factory;

import com.hybrit.assessment.reader.Reader;

/**
 *
 * @author Tim
 */
public abstract class AccessorFactory {
        
        /**
        * The XML file type.
        */
       private static final String XML = "xml";

       /**
        * Create the concrete AccessorFactory depending on the path.
        * @param path The path pointing to a presentation file.
        * @return The concrete AccessorFactory.
        */
       public static AccessorFactory getFactory(String path) {
                AccessorFactory factory = null;

                int dotIndex = path.lastIndexOf(".") + 1;
                String fileExtension = path.substring(dotIndex);

                if(XML.equalsIgnoreCase(fileExtension)) {
                    factory = new XMLAccessorFactory();
                }

                return factory;
       }

       /**
        * Create the concrete Reader.
        * @return The concrete Reader.
        */
       public abstract Reader createReader();
}
