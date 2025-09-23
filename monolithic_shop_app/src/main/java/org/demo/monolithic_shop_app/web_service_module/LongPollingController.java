package org.demo.monolithic_shop_app.web_service_module;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@RestController
public class LongPollingController {

    private final Queue<DeferredResult<String>> deferredResults = new ConcurrentLinkedQueue<>();

    @GetMapping("/poll")
    public DeferredResult<String> pollForUpdates() {
        DeferredResult<String> deferredResult = new DeferredResult<>(5000L, "No new updates within 5 seconds."); // Timeout after 5 seconds
        deferredResults.add(deferredResult);

        deferredResult.onCompletion(() -> deferredResults.remove(deferredResult));
        deferredResult.onTimeout(() -> deferredResults.remove(deferredResult));

        return deferredResult;
    }

    @GetMapping("/push")
    public String pushUpdate(@RequestParam(name = "message", required = true) String message) {
        for (DeferredResult<String> deferredResult : deferredResults) {
            deferredResult.setResult(message); // Set result to all waiting clients
        }
        return "Update pushed: " + message;
    }
}
