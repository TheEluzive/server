package org.example.http.framework;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryParseTestWWWForm {
    private static String URL = "/courses?paramNumber1=porometr";
    private static Map<String, List<String>> query = new HashMap<>();

    private static void setMap(){
        ArrayList<String> arrayListFirst = new ArrayList<>();
        arrayListFirst.add("porometr");
        query.put("paramNumber1", arrayListFirst);

    }

    @Test
    public void queryParseTestWWWForm(){
        setMap(); // pre
        Map<String, List<String>> testForm = Server.parseParameters(URL);

        Assert.assertEquals(query.size(), testForm.size());
        Assert.assertArrayEquals(
                query.get("paramNumber1").toArray(),
                testForm.get("paramNumber1").toArray()
        );
    }
}
