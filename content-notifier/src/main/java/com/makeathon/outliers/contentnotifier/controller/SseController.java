package com.makeathon.outliers.contentnotifier.controller;

import com.makeathon.outliers.contentnotifier.model.WeatherEvent;
import com.makeathon.outliers.contentnotifier.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SseController {

  private final WeatherService weatherService;

  @GetMapping(path = "/notifier/weather",
      produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<WeatherEvent> feed() {
    return weatherService.streamWeather();
  }
}
