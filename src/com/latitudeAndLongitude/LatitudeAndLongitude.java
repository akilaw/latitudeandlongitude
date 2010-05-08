package com.latitudeAndLongitude;

import com.sun.star.container.XStringKeyMap;
import com.sun.star.uno.XComponentContext;
import com.sun.star.lib.uno.helper.Factory;
import com.sun.star.lang.XSingleComponentFactory;
import com.sun.star.registry.XRegistryKey;
import com.sun.star.lib.uno.helper.WeakBase;
import com.sun.star.text.TextMarkupType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class LatitudeAndLongitude extends WeakBase
   implements com.sun.star.lang.XServiceInfo,
              com.sun.star.smarttags.XSmartTagRecognizer
{
    private final XComponentContext m_xContext;
    private static final String m_SmartTagType = "mynamespace#latlon";
    private static final String m_implementationName = LatitudeAndLongitude.class.getName();
    private static final String[] m_serviceNames = {
        "com.sun.star.smarttags.SmartTagRecognizer" };


    public LatitudeAndLongitude( XComponentContext context )
    {
        m_xContext = context;
    };

    public static XSingleComponentFactory __getComponentFactory( String sImplementationName ) {
        XSingleComponentFactory xFactory = null;

        if ( sImplementationName.equals( m_implementationName ) )
            xFactory = Factory.createComponentFactory(LatitudeAndLongitude.class, m_serviceNames);
        return xFactory;
    }

    public static boolean __writeRegistryServiceInfo( XRegistryKey xRegistryKey ) {
        return Factory.writeRegistryServiceInfo(m_implementationName,
                                                m_serviceNames,
                                                xRegistryKey);
    }

    // com.sun.star.lang.XServiceInfo:
    public String getImplementationName() {
         return m_implementationName;
    }

    public boolean supportsService( String sService ) {
        int len = m_serviceNames.length;

        for( int i=0; i < len; i++) {
            if (sService.equals(m_serviceNames[i]))
                return true;
        }
        return false;
    }

    public String[] getSupportedServiceNames() {
        return m_serviceNames;
    }

    // com.sun.star.lang.XInitialization:
    public void initialize(Object[] aArguments) throws com.sun.star.uno.Exception
    {
        // TODO: Insert your implementation for "initialize" here.
    }

    // com.sun.star.smarttags.XSmartTagRecognizer:
    public int getSmartTagCount()
    {
        return 1;
    }

    public String getName(com.sun.star.lang.Locale aLocale)
    {
        // TODO: Exchange the default return implementation for "getName" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return new String("Latitude and Longitude");
    }

    public String getDescription(com.sun.star.lang.Locale aLocale)
    {
        // TODO: Exchange the default return implementation for "getDescription" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return new String();
    }

    public String getSmartTagName(int nSmartTagIndex) throws com.sun.star.lang.IndexOutOfBoundsException
    {
        // TODO: Exchange the default return implementation for "getSmartTagName" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return m_SmartTagType;
    }

    public String getSmartTagDownloadURL(int nSmartTagIndex) throws com.sun.star.lang.IndexOutOfBoundsException
    {
        // TODO: Exchange the default return implementation for "getSmartTagDownloadURL" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return new String();
    }

    public void recognize(String aText, int nStart, int nLength, com.sun.star.smarttags.SmartTagRecognizerMode eDataType, com.sun.star.lang.Locale aLocale, com.sun.star.text.XTextMarkup xTextMarkup, String aApplicationName, com.sun.star.frame.XController xController, com.sun.star.i18n.XBreakIterator xTokenizer)
    {
        // TODO: Insert your implementation for "recognize" here.
        final int nEndPos = nStart + nLength;
        boolean addressStart=false, address=false;
        Pattern pattern = Pattern.compile("((([1]?\\d{1,2}°)\\s*([0-6]?\\d\')?\\s*([0-6]?\\d(\\.\\d+)?(\'{2}|\"))?\\s*[NEWS][,\\:\\;\\s]*){2})|" +
                "((([1]?\\d{1,2}°)\\s*([0-6]?\\d(\\.\\d+)?\')?\\s*[NEWS][,\\:\\;\\s]*){2})|" +
                "((([1]?\\d{1,2}\\.\\d+°)\\s*[NEWS][,\\:\\;\\s]*){2})|" +
                "(([\\+\\-]([1]?\\d{1,2}\\.\\d+°)[,\\:\\;\\s]*){2})");
        Matcher matcher = pattern.matcher(aText);
        int start=0,end=0;
        System.out.println("txt "+aText);
        while (matcher.find()) {
            start = matcher.start();
            end = matcher.end();
            address = true;
            System.out.println("addressStart "+matcher.group());
            if (address) {
                XStringKeyMap xProps = null;
                xTextMarkup.commitTextMarkup(TextMarkupType.SMARTTAG,
                        m_SmartTagType,
                        start,
                        end - start,
                        xProps);
            }
        }
    }

    public boolean hasPropertyPage(int nSmartTagIndex, com.sun.star.lang.Locale aLocale) throws com.sun.star.lang.IndexOutOfBoundsException
    {
        // TODO: Exchange the default return implementation for "hasPropertyPage" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return false;
    }

    public void displayPropertyPage(int nSmartTagIndex, com.sun.star.lang.Locale aLocale) throws com.sun.star.lang.IndexOutOfBoundsException
    {
        // TODO: Insert your implementation for "displayPropertyPage" here.
    }

}
