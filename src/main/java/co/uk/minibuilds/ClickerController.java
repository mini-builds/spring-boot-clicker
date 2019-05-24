package co.uk.minibuilds;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ClickerController {

    private final AtomicLong clickCount = new AtomicLong();

    @GetMapping("/click")
    public Click clickCount() {
        return new Click(clickCount.get());
    }

    @PostMapping("/click")
    Click click() {
        return new Click(clickCount.incrementAndGet());
    }

    public static class Click {
        private final long clickCount;

        public Click(long clickCount) {
            this.clickCount = clickCount;
        }

        public long getClickCount() {
            return clickCount;
        }
    }
}