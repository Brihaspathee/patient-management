package com.brihaspathee.patient;

import software.amazon.awscdk.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 27, March 2025
 * Time: 3:48 PM
 * Project: Default (Template) Project
 * Package Name: com.brihaspathee.streams
 * To change this template use File | Settings | File and Code Template
 */
public class LocalStack extends Stack {

    public LocalStack(final App scope,
                      final String id,
                      final StackProps props) {
        super(scope, id, props);

    }

    /**
     * The entry point of the application. This method initializes the CDK application, creates a stack,
     * and synthesizes the application configuration.
     *
     * @param args an array of command-line arguments for the application
     */
    public static void main(final String[] args) {
        App app = new App(AppProps.builder()
                .outdir("cdk.out")
                .build());
        StackProps stackProps = StackProps.builder()
                .synthesizer(new BootstraplessSynthesizer())
                .build();
        new LocalStack(app, "localstack", stackProps);
        app.synth();
        System.out.println("App synthesizing in progress...");
    }
}