package com.geeson.annotations;

import com.geeson.annotations.crap.JsonSerializationException;
import com.geeson.annotations.crap.ObjectToJsonConverter;
import com.geeson.annotations.crap.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AnnotationsApplicationTests {

    @Test
    public void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
        Person person = new Person("soufiane", "cheouati", "34");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.convertToJson(person);
        assertEquals(
                "{\"personAge\":\"34\",\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\"}",
                jsonString);
    }

}
