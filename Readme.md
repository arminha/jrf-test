# Profiling using the Java Flight Recorder

## What is the Java (JDK) Flight Recorder?

* An **event based** tracing framework, build **into** the Java Runtime
* Extremely **low overhead (<%1)**, designed for use in production
* With APIs for
  * Producing application level events
  * Analysing events and event streams
* Events can be dumped into a file or streamed over JMX

### GUIs for analysis

* [JDK Mission Control](https://github.com/openjdk/jmc)
* [VisualVM](https://visualvm.github.io/)
* [Java JFR Profiler](https://plugins.jetbrains.com/plugin/20937-java-jfr-profiler) for IntelliJ

Profiles

### Where can I use it?

JFR requires OpenJDK 11+ or OpenJDK 8u262 ([release notes](https://mail.openjdk.org/pipermail/jdk8u-dev/2020-July/012143.html))

JMX streaming required OpenJDK 17+.

### How to use it?

There are lots of configuration knobs. Azul has a good [documentation](https://docs.azul.com/prime/Java-Flight-Recorder).

## Profiling

### Method profiling


### Allocations


Profiling -> Sampling not Tracing


TODO



## Streaming / Integration in APM tools

https://docs.newrelic.com/docs/apm/agents/java-agent/features/real-time-profiling-java-using-jfr-metrics/

https://devblogs.microsoft.com/java/microsoft-jfr-streaming/

## Resources

Blog posts / videos

* [Java Flight Recorder as an Observability Tool](https://www.infoq.com/presentations/jfr-observability/) - [Video](https://www.youtube.com/watch?v=MG6MQLg0zEE)
* [Java's Observability and Monitoring Framework - JFR](https://www.youtube.com/watch?v=XEKkUpPnf4Q)
* [Continuous Monitoring with JDK Flight Recorder](https://www.youtube.com/watch?v=plYESjZ12hM)
* [JDK Flight Recorder – a gem hidden in OpenJDK](https://bell-sw.com/announcements/2020/06/24/Java-Flight-Recorder-a-gem-hidden-in-OpenJDK/)

Tutorials

* [JDK Mission Control Tutorial](https://github.com/thegreystone/jmc-tutorial/)

Integration in APM tools

* [NewRelic](https://docs.newrelic.com/docs/apm/agents/java-agent/features/real-time-profiling-java-using-jfr-metrics/)
* [Azure Application Insights](https://learn.microsoft.com/en-us/azure/azure-monitor/app/java-standalone-profiler)
