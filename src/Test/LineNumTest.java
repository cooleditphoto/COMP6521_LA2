package Test;

import Util.LineNum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LineNumTest {

    LineNum lineNum;

    @Before
    public void init(){
        lineNum = new LineNum();
    }

    @Test
    public void lineNumTest() throws IOException {
        int num  = lineNum.getLineNum("/Users/wujiaqi/IdeaProjects/COMP6521_LA2/bitmap.txt");
        Assert.assertEquals(0,num);
    }


}
