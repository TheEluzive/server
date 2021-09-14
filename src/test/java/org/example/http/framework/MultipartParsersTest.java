package org.example.http.framework;

import org.junit.Assert;
import org.junit.Test;

public class MultipartParsersTest {
    final static String body =   "----------------------------443836377347050164488876\r\n" +
            "Content-Disposition: form-data; name=\"textField\"; filename=\"textoviyFIle.txt\"\r\n" +
            "Content-Type: text/plain\r\n" +
            "\r\n" +
            "abcdefgh12345xyz\r\n" +
            "----------------------------443836377347050164488876\r\n" +
            "Content-Disposition: form-data; name=\"key1field\"\r\n" +
            "\r\n" +
            "fdsfdsfds\r\n" +
            "----------------------------443836377347050164488876--\r\n";
    final static String header = "multipart/form-data; boundary=----------------------------443836377347050164488876";



    @Test
    public void testParseMultiPart(){
        int expectedSize = 2;
        Assert.assertEquals(expectedSize, Server.parseMultiPart(body.getBytes(), header).size());

    }
}
