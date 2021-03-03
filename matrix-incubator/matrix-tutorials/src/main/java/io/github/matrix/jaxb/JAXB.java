package io.github.matrix.jaxb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author Bing D. Yee
 * @since v1.0.0 2021/02/27
 */
public class JAXB {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlRootElement
    @ToString
    static class Example {
        private String title;
        private String abbr;
        private Integer year;
    }

    public static String obj2xml(Object obj) throws Exception {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        // //编码格式
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        // 是否格式化生成的xml串
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // 是否省略xm头声明信息
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        return writer.toString();
    }

    public static<T> T xml2obj(String xml, Class<T> clazz) throws JAXBException {
        return (T) JAXBContext
                .newInstance(clazz)
                .createUnmarshaller()
                .unmarshal(new StringReader(xml));
    }


    public static void main(String[] args) throws Exception {
        Example obj = new Example("Hello World", "abbr11111", 2010);
        String xml = obj2xml(obj);
        Example e = xml2obj(xml, Example.class);
        System.err.println(xml);
        System.err.println(e);
    }

}
