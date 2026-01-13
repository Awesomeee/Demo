package org.demo.monolithic_shop_app.web_service_module;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

@RestController
public class ServerSentEventsController {
	
	@CrossOrigin(origins = "http://your-frontend-domain:port")
	@GetMapping(path = "/stream-events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter streamEvents() {
	    SseEmitter emitter = new SseEmitter();
	    // Logic to send events to the emitter in a separate thread
	    ExecutorService sseMvcExecutor = Executors.newSingleThreadExecutor();
	    sseMvcExecutor.execute(() -> {
	        try {
	            for (int i = 0; true; i++) {
	                SseEventBuilder event = SseEmitter.event()
	                  .data("SSE MVC - " + LocalTime.now().toString())
	                  .id(String.valueOf(i))
	                  .name("sse event - mvc");
	                emitter.send(event);
	                Thread.sleep(1000);
	            }
	        } catch (Exception ex) {
	            emitter.completeWithError(ex);
	        }
	    });
	    return emitter;
	}

}
