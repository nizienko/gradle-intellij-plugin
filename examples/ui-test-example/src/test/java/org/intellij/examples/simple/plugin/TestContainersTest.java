package org.intellij.examples.simple.plugin;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.utility.MountableFile;

public class TestContainersTest {

    @Test
    void testInContainer() throws InterruptedException {
        final GenericContainer container = new GenericContainer(
                new ImageFromDockerfile()
                        .withFileFromClasspath("Dockerfile", "docker/Dockerfile"))
                .withExposedPorts(5901, 6901)
                .withCopyFileToContainer(MountableFile.forHostPath(".."), "/headless/test")
                .withWorkingDirectory("/headless/test")
                .withCommand("./gradlew", "ui-test-example:runIdeForIiTests", "&");
        container.start();
        System.out.println("http://127.0.0.1:" + container.getMappedPort(6901) + "/?password=vncpassword");

        Thread.sleep(1600000);
    }
}
