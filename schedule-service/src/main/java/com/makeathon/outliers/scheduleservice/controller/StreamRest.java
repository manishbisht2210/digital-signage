package com.makeathon.outliers.scheduleservice.controller;

import com.makeathon.outliers.scheduleservice.dto.Content;
import com.makeathon.outliers.scheduleservice.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class StreamRest {

  private final ContentService contentService;

  @GetMapping(path = "/stream-flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  @CrossOrigin(origins = "*")
  public Flux<Content> streamFlux() {

    return contentService.streamFluxContent();
  }
}
