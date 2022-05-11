import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * A collection of quiz objects
 * @author @pavlidvg
 */
public class Quiz {
     private String title;
    private  Question[] questions;

    public Question[] getQuestions()
    {
        return questions;
    }


    public Quiz(){
        this.title = "testing quiz title";
        System.out.println("made an item");
        questions = new Question[3];
        questions[0] = new Question("q1","q1 desc");
        questions[1] = new Question("q1","q1 desc");


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
