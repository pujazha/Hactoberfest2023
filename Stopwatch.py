import time

class Stopwatch:
    def __init__(self, precision=2):
        self.precision = precision
        self.start_time = None
        self.end_time = None

    def start(self):
        if self.start_time is not None:
            raise ValueError("Stopwatch is already running. Use restart() to reset and start again.")
        self.start_time = time.perf_counter()

    def stop(self):
        if self.start_time is None:
            raise ValueError("Stopwatch is not running. Use start() to begin.")
        self.end_time = time.perf_counter()

    def reset(self):
        self.start_time = None
        self.end_time = None

    def restart(self):
        self.reset()
        self.start()

    @property
    def running(self):
        return self.start_time is not None and self.end_time is None

    @property
    def duration(self):
        if self.start_time is None:
            return 0.0
        if self.end_time is None:
            return time.perf_counter() - self.start_time
        return self.end_time - self.start_time

    def __str__(self):
        duration = self.duration
        formatted_duration = f"{duration:.{self.precision}f}"
        return formatted_duration

# Example usage:
stopwatch = Stopwatch(2)
stopwatch.start()

# Simulate some work
time.sleep(2.5)

stopwatch.stop()
print("Duration:", stopwatch)  # Print the formatted duration
