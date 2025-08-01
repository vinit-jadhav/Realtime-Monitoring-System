Real-Time Monitoring System with Spring Boot, Kafka, Prometheus, and Grafana
This project implements a real-time monitoring system to track user interactions on a web application. It utilizes Spring Boot for backend services, Apache Kafka for event streaming, Prometheus for monitoring, and Grafana for visualization.

Project Overview
The system is composed of four main components:

Event Producer Service (Spring Boot)

Event Consumer Service (Spring Boot)

Prometheus Monitoring

Grafana Visualization

Together, these components enable real-time capture, processing, and visualization of user interaction events such as button clicks.

Project Workflow
1. Event Producer Service
A Spring Boot application captures user actions (e.g., button clicks) from the web interface.

Events are sent to a Kafka topic in real time.

2. Event Consumer Service
A separate Spring Boot service subscribes to the Kafka topic.

It processes incoming events and exposes metrics at the /metrics endpoint (port 8082) in a format compatible with Prometheus.

3. Prometheus Monitoring
Prometheus is configured to scrape metrics from the consumer service every second.

This enables near real-time collection and monitoring of event metrics.

4. Grafana Visualization
Grafana connects to Prometheus as a data source.

Dashboards are created in Grafana to visualize metrics such as "Enroll Now" and "Buy Now" button clicks in real time.

Key Components
Event Producer Service
Captures front-end user interactions.

Sends structured events to a Kafka topic.

Ensures real-time logging of user behavior.

Event Consumer Service
Listens to the Kafka topic and processes incoming events.

Exposes metrics via /metrics endpoint using Micrometer/Prometheus format.

Prometheus Configuration
Polls the consumer service's /metrics endpoint every second.

Collects and stores time-series data related to user interaction events.

Grafana Dashboards
Visualizes collected metrics from Prometheus.

Displays real-time analytics for specific user actions such as:

"Enroll Now" button clicks

"Buy Now" button clicks

Technologies Used
Java 17

Spring Boot 3

Apache Kafka

Prometheus

Grafana

Docker (optional, for deployment)

Getting Started
To run the project locally, you will need:

Java and Maven installed

Kafka broker running (local or containerized)

Prometheus and Grafana instances (can be run via Docker)

You can then:

Start the Event Producer and Consumer Spring Boot services.

Configure Prometheus to scrape from the consumer service.

Connect Grafana to Prometheus and import your dashboards.
