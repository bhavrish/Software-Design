package sample;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

// container class
public class A5Shapes {
    // @XmlElement specifies that the respective XML element name is A5Shape for each element in the list
    @XmlElement(name="A5Shape")
    private List<A5Shape> a5ShapeList = new ArrayList<>();

    public List<A5Shape> getA5ShapeList() {
        return a5ShapeList;
    }
}
