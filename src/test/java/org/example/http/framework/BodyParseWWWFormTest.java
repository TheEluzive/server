package org.example.http.framework;




import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BodyParseWWWFormTest {
    private static String body = "myKey1FromBody=fdsfsd&myKey2=asvcxfds";
    private static Map<String, List<String>> form = new HashMap<>();


    private final static void setMap(){
        ArrayList<String> arrayListFirst = new ArrayList<>();
        arrayListFirst.add("fdsfsd");
        ArrayList<String> arrayListSecond = new ArrayList<>();
        arrayListSecond.add("asvcxfds");

        form.put("myKey1FromBody", arrayListFirst);
        form.put("myKey2", arrayListSecond);
    }

    @Test
    public void bodyParseTestWWWForm(){
        setMap(); // pre
        Map<String, List<String>> testForm = Server.parseBody(body);


        Assert.assertEquals(form.size(), testForm.size());

        Assert.assertArrayEquals(
                form.get("myKey1FromBody").toArray(),
                testForm.get("myKey1FromBody").toArray()
        );

        Assert.assertArrayEquals(
                form.get("myKey2").toArray(),
                testForm.get("myKey2").toArray()

        );

    }
}
