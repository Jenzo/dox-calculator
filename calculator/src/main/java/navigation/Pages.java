package navigation;

public class Pages
{
    private static final String ROOT = "/secure/";

    private Pages()
    {
    }

    public static String getTestPath()
    {
        return ROOT + "test.xhtml";
    }

    public static String getIndexPath()
    {
        return ROOT + "index.xhtml";
    }

}
