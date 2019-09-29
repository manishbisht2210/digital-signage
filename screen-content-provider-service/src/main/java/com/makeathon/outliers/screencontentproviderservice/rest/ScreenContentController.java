package com.makeathon.outliers.screencontentproviderservice.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makeathon.outliers.screencontentproviderservice.service.ContentService;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ScreenContentController {


    @Autowired
    private ContentService contentService;

    private List<LinkedHashMap<String, Object>> list = initializeList();

    public ScreenContentController() throws IOException {
    }

    private List<LinkedHashMap<String, Object>> initializeList() throws IOException, IOException {
        String str = "[\n" +
                "   {\n" +
                "      \"id\":0,\n" +
                "      \"header\":\"Gluten-free Bicycle\",\n" +
                "      \"body\":\"Chillwave knausgaard chambray flannel tumblr, narwhal microdosing blog...\",\n" +
                "      \"colour\":\"#242846\",\n" +
                "      \"img\":\"https://s3-us-west-2.amazonaws.com/s.cdpn.io/735173/rvc1.jpg\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"id\":1,\n" +
                "      \"header\":\"Post-ironic Disrupt\",\n" +
                "      \"body\":\"Swag biodiesel disrupt retro fashion, salvia food truck kitsch wolf DIY...\",\n" +
                "      \"colour\":\"#ba9077\",\n" +
                "      \"img\":\"https://s3-us-west-2.amazonaws.com/s.cdpn.io/735173/rvc2.jpg\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"id\":2,\n" +
                "      \"header\":\"Lumber-Sexual Roof Party \",\n" +
                "      \"body\":\"Flexitarian 3 wolf moon cliche, migas scenester street art...\",\n" +
                "      \"colour\":\"#1ABC9C\",\n" +
                "      \"img\":\"https://advertise-content.s3.us-east-2.amazonaws.com/cadbury-dairy-milk-coffee.jpg\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"id\":3,\n" +
                "      \"header\":\"Vegan hoodie trust fund\",\n" +
                "      \"body\":\"Farm-to-table tousled try-hard, normcore ethical tilde iPhone...\",\n" +
                "      \"colour\":\"#C0392B\",\n" +
                "      \"img\":\"https://s3-us-west-2.amazonaws.com/s.cdpn.io/735173/rvc4.jpg\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"id\":4,\n" +
                "      \"header\":\"cliche craft beer\",\n" +
                "      \"body\":\"Tote bag flannel normcore polaro\",\n" +
                "      \"colour\":\"#513B56\",\n" +
                "      \"img\":\"https://s3-us-west-2.amazonaws.com/s.cdpn.io/735173/rvc5.jpg\"\n" +
                "   }\n" +
                "]";
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(str, List.class);
    }

    @GetMapping(path = "/stream-flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin(origins = "*")
    public Flux<String> streamFlux() {

        return contentService.streamFluxContent();
    }

    @GetMapping(path = "/stream-flu", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin(origins = "*")
    public Flux<LinkedHashMap<String, Object>> streamFlu() throws IOException {

        return Flux.fromIterable(initializeList());
    }
}
