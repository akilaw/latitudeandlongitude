package com.latitudeAndLongitude;

import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.uno.XComponentContext;
import com.sun.star.lib.uno.helper.Factory;
import com.sun.star.lang.XSingleComponentFactory;
import com.sun.star.registry.XRegistryKey;
import com.sun.star.lib.uno.helper.WeakBase;
import com.sun.star.system.XSystemShellExecute;
import com.sun.star.uno.UnoRuntime;


public final class LatitudeAndLongitudeAction extends WeakBase
   implements com.sun.star.lang.XServiceInfo,
              com.sun.star.smarttags.XSmartTagAction
{
    private final XComponentContext m_xContext;
    private static final String m_implementationName = LatitudeAndLongitudeAction.class.getName();
    private static final String[] m_serviceNames = {
        "com.sun.star.smarttags.SmartTagAction" };


    public LatitudeAndLongitudeAction( XComponentContext context )
    {
        m_xContext = context;
    };

    public static XSingleComponentFactory __getComponentFactory( String sImplementationName ) {
        XSingleComponentFactory xFactory = null;

        if ( sImplementationName.equals( m_implementationName ) )
            xFactory = Factory.createComponentFactory(LatitudeAndLongitudeAction.class, m_serviceNames);
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

    // com.sun.star.smarttags.XSmartTagAction:
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
        return new String();
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
        return new String("mynamespace#latlon");
    }

    public String getSmartTagCaption(int nSmartTagIndex, com.sun.star.lang.Locale aLocale) throws com.sun.star.lang.IndexOutOfBoundsException
    {
        // TODO: Exchange the default return implementation for "getSmartTagCaption" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return new String("Latitude and Longitude");
    }

    public int getActionCount(String aSmartTagName, com.sun.star.frame.XController xController)
    {
        // TODO: Exchange the default return implementation for "getActionCount" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return 1;
    }

    public int getActionID(String aSmartTagName, int nActionIndex, com.sun.star.frame.XController xController) throws com.sun.star.lang.IllegalArgumentException
    {
        // TODO: Exchange the default return implementation for "getActionID" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return 500 + nActionIndex;
    }

    public String getActionCaptionFromID(int nActionID, String aApplicationName, com.sun.star.lang.Locale aLocale, com.sun.star.container.XStringKeyMap xProperties, String aText, String aXML, com.sun.star.frame.XController xController, com.sun.star.text.XTextRange xTarget) throws com.sun.star.lang.IllegalArgumentException
    {
        // TODO: Exchange the default return implementation for "getActionCaptionFromID" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return new String("Search for "+aText +" in google maps");
    }

    public String getActionNameFromID(int nActionID, com.sun.star.frame.XController xController) throws com.sun.star.lang.IllegalArgumentException
    {
        // TODO: Exchange the default return implementation for "getActionNameFromID" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return new String();
    }

    public void invokeAction(int nActionID, String aApplicationName, com.sun.star.frame.XController xController, com.sun.star.text.XTextRange xTarget, com.sun.star.container.XStringKeyMap xProperties, String aText, String aXML, com.sun.star.lang.Locale aLocale) throws com.sun.star.lang.IllegalArgumentException
    {
        // TODO: Insert your implementation for "invokeAction" here.
        try {
                final XMultiComponentFactory xFact = m_xContext.getServiceManager();
                final Object xObject = xFact.createInstanceWithContext("com.sun.star.system.SystemShellExecute", m_xContext);
                final XSystemShellExecute xSystemShellExecute = (XSystemShellExecute) UnoRuntime.queryInterface(XSystemShellExecute.class, xObject);
                final String aURLString = "http://maps.google.com/maps?q=" + aText;
                xSystemShellExecute.execute( aURLString, "", com.sun.star.system.SystemShellExecuteFlags.DEFAULTS );
            } catch( com.sun.star.uno.Exception ex) {
                ex.printStackTrace();
            }
    }

    public boolean isCaptionDynamic(int nActionID, String aApplicationName, com.sun.star.frame.XController xController, com.sun.star.lang.Locale aLocale) throws com.sun.star.lang.IllegalArgumentException
    {
        // TODO: Exchange the default return implementation for "isCaptionDynamic" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return false;
    }

    public boolean isShowSmartTagIndicator(int nActionID, String aApplicationName, com.sun.star.frame.XController xController, com.sun.star.lang.Locale aLocale) throws com.sun.star.lang.IllegalArgumentException
    {
        // TODO: Exchange the default return implementation for "isShowSmartTagIndicator" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return false;
    }

}
