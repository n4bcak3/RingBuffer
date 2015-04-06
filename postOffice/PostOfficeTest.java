package postOffice;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PostOfficeTest extends TestCase {

    public void testPostOffice() throws Exception{
        CircBuffer test = new CircBuffer(3);
        PostOffice office = new PostOffice("UA",test);

        Assert.assertEquals("letter000001UA", office.getLetterName());
    }
}