package calculator.ui.messages;

public class Icons
{

    private Icons()
    {
    }

    public static String getSmileO()
    {
        return getIconClass("fa fa-smile-o");
    }

    public static String getMehO()
    {
        return getIconClass("fa fa-meh-o");
    }

    private static String getIconClass(final String icon)
    {
        return String.format("<i class=\"%s\"></i> ", icon);
    }

}
