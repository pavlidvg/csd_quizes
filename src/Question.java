import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;

/**
 * main class that handles Question storing and also helps create an XML file with the contents of the question. Each question object is supposed to store
 * everything the question needs to be displayed properly, but only in form that can be passed in the XML. That means that some fields might need additional
 * parsing or decompression (for example we only store a binary encoding of a picture if the question has a relevant image, not the picture itself)
 *
 * The class follows the rules and conventions of a Java Bean.
 * @author  pavlidvg
 */
public class Question {
    public String title;
    public String desc;

    Question(String title, String desc)
    {
        this.title = title;
        this.desc = desc;
    }
    public Question()
    {
       this.title = "default title";
       this.desc = "default description";
    }


    public boolean writeToXML(FileOutputStream f)
    {
        try
        {


            XMLEncoder encoder = new XMLEncoder(f);
            encoder.writeObject(this);
            encoder.close();
            f.close();
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }

    //getters and setters
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
